package com.onfido.onfidoRegistrationNode.mocks;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.io.IOException;

import org.powermock.reflect.Whitebox;

import com.onfido.Onfido;
import com.onfido.onfidoRegistrationNode.ApiIntegrationTest;
import com.onfido.onfidoRegistrationNode.OnfidoAPI;
import com.onfido.onfidoRegistrationNode.onfidoRegistrationNode;

import okhttp3.mockwebserver.MockWebServer;

public class MockOnfidoApiFactory extends ApiIntegrationTest {

    public static OnfidoAPI fakeOnfidoApi(MockOnfidoApiConfiguration mockOnfidoApiConfiguration, MockWebServer mockWebServer) throws IOException {

        Onfido mockOnfido = Onfido.builder()
                                  .apiToken(mockOnfidoApiConfiguration.token)
                                  .unknownApiUrl(mockWebServer.url("/").toString())
                                  .build();

        OnfidoAPI mockOnfidoAPI = mock(OnfidoAPI.class);
        Whitebox.setInternalState(mockOnfidoAPI, "onfido", mockOnfido);

        onfidoRegistrationNode.Config mockRegistrationConfig = mock(onfidoRegistrationNode.Config.class);
        when(mockRegistrationConfig.biometricCheck()).thenReturn(mockOnfidoApiConfiguration.checkType);
        Whitebox.setInternalState(mockOnfidoAPI, "registrationConfig", mockRegistrationConfig);

        return mockOnfidoAPI;
    }
}
