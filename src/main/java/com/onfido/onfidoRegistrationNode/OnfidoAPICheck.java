package com.onfido.onfidoRegistrationNode;

import java.sql.Timestamp;

import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onfido.Onfido;
import com.onfido.exceptions.OnfidoException;
import com.onfido.models.Check;


public class OnfidoAPICheck {


    private final onfidoCheckNode.Config registrationConfig;

    private final Onfido onfido;
    
    private String loggerPrefix = "[OnfidoAPICheck]" + onfidoRegistrationNodePlugin.logAppender;
    private static final Logger log = LoggerFactory.getLogger(OnfidoAPICheck.class);
    

    public OnfidoAPICheck(onfidoCheckNode.Config config) throws NodeProcessException {
        log.debug("initializing OnfidoAPICheck: {}", config);

        this.registrationConfig = config;


        this.onfido = Onfido.builder()
                            .apiToken(getApiToken())
                            .unknownApiUrl(getBaseUrl())
                            .build();
    }



    public String checkStatus(String checkId) throws NodeProcessException {
    	
        log.debug(loggerPrefix + "Getting check for checkId: {}", checkId);

        log.debug(loggerPrefix + "START: {}", new Timestamp(System.currentTimeMillis()));

        // Get check
        try {
            Check check = onfido.check.find(checkId);
            log.debug(loggerPrefix + "Check: {}", check);
            if(check.getStatus().equals("pending") || check.getStatus().equals("in_progress")) {
                return "pending";
            }

            return check.getResult();
        } catch (OnfidoException e) {
            log.error(loggerPrefix + "Exception creating the check");
            log.error(loggerPrefix + e.toString());
            e.printStackTrace();

            throw new NodeProcessException(e);
        } finally {
            log.debug(loggerPrefix + "END: {}", new Timestamp(System.currentTimeMillis()));
        }
    }


    private String getApiToken() throws NodeProcessException {
        if (registrationConfig != null) {
            return new String(registrationConfig.onfidoToken());
        }

        throw new NodeProcessException("Onfido API Token not configured");
    }

    private String getBaseUrl() throws NodeProcessException {
        if (registrationConfig != null) {
            return registrationConfig.onfidoApiBaseUrl();
        } 

        throw new NodeProcessException("Onfido API Base URL not configured");
    }



}
