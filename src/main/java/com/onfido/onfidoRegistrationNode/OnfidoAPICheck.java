package com.onfido.onfidoRegistrationNode;

import com.google.common.collect.Lists;
import com.onfido.Onfido;
import com.onfido.exceptions.OnfidoException;
import com.onfido.models.Applicant;
import com.onfido.models.Check;
import com.onfido.models.Document;
import com.onfido.models.Extraction;
import com.onfido.models.Report;
import com.onfido.models.SdkToken;
import lombok.extern.slf4j.Slf4j;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.owasp.esapi.Logger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j(topic="amAuth")
public class OnfidoAPICheck {
    private static final String DEFAULT_FIRST_NAME = "anonymous";
    private static final String DEFAULT_LAST_NAME = "anonymous";

    private final onfidoCheckNode.Config registrationConfig;
    private final onfidoWebhookNode.Config webhookConfig;
    private final Onfido onfido;

    public OnfidoAPICheck(onfidoCheckNode.Config config) throws NodeProcessException {
        log.debug("initializing OnfidoAPICheck: {}", config);

        this.registrationConfig = config;
        this.webhookConfig = null;

        this.onfido = Onfido.builder()
                            .apiToken(getApiToken())
                            .unknownApiUrl(getBaseUrl())
                            .build();
    }

    public OnfidoAPICheck(onfidoWebhookNode.Config config) throws NodeProcessException {
        log.debug("initializing OnfidoAPI: {}", config);

        this.registrationConfig = null;
        this.webhookConfig = config;

        this.onfido = Onfido.builder()
                            .apiToken(getApiToken())
                            .unknownApiUrl(getBaseUrl())
                            .build();
    }

    public String checkStatus(String checkId) throws NodeProcessException {
    	
        log.debug("Getting check for checkId: {}", checkId);

        log.debug("START: {}", new Timestamp(System.currentTimeMillis()));

        // Get check
        try {
            Check check = onfido.check.find(checkId);
            log.debug("Check: {}", check);
            if(check.getStatus().equals("pending") || check.getStatus().equals("in_progress")) {
                return "pending";
            }

            return check.getResult();
        } catch (OnfidoException e) {
            log.error("Exception creating the check");
            log.error(e.toString());
            e.printStackTrace();

            throw new NodeProcessException(e);
        } finally {
            log.debug("END: {}", new Timestamp(System.currentTimeMillis()));
        }
    }


    private String getApiToken() throws NodeProcessException {
        if (registrationConfig != null) {
            return new String(registrationConfig.onfidoToken());
        } else if (webhookConfig != null){
            return new String(webhookConfig.onfidoToken());
        }

        throw new NodeProcessException("Onfido API Token not configured");
    }

    private String getBaseUrl() throws NodeProcessException {
        if (registrationConfig != null) {
            return registrationConfig.onfidoApiBaseUrl();
        } else if (webhookConfig != null) {
            return webhookConfig.onfidoApiBaseUrl();
        }

        throw new NodeProcessException("Onfido API Base URL not configured");
    }

    private List<String> getReportTypes() throws NodeProcessException {
        if (null == registrationConfig) {
            throw new NodeProcessException("Registration Configuration not initialized");
        }

        ArrayList<String> reports = Lists.newArrayList();
        
        switch (registrationConfig.biometricCheck()) {
            case None:
                reports.add(ReportNames.DOCUMENT.toString());
                break;

            case Live:
                reports.add(ReportNames.DOCUMENT.toString());
                reports.add(ReportNames.FACIAL_SIMILARITY_VIDEO.toString());
                break;

            case Selfie:
                reports.add(ReportNames.DOCUMENT.toString());
                reports.add(ReportNames.FACIAL_SIMILARITY_PHOTO.toString());
                break;

            default:
                throw new NodeProcessException("Unknown Report Type selected");
        }

        return reports;
    }

}
