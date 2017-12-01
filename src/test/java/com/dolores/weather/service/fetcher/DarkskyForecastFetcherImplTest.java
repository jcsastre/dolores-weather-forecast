package com.dolores.weather.service.fetcher;

import com.dolores.weather.fetcher.dto.DarkskyResponseDto;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isEmpty;
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAnd;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class DarkskyForecastFetcherImplTest {

    private final String url = "http://localhost:8080";
    private final String accessToken = "ced014343d18fd41780ceb0d9ed8c6a2";
    private final Double lat = 37.8267D;
    private final Double lng = -122.4233D;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Test
    @DisplayName("Should fetch correctly")
    public void happyPath() throws IOException {

        // Given
        String responseContentAsString = new Scanner(getClass().getResourceAsStream("/com/dolores/weather/dto/fetcher/successful-response.json"), "UTF-8").useDelimiter("\\A").next();

        final StubMapping stubMapping = stubFor(
            get(urlPathMatching("/" + accessToken + "/" + lat + "," + lng))
                .withQueryParam("exclude", WireMock.equalTo("currently,minutely,flags"))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(responseContentAsString)
                )
            );
        final DarkskyForecastFetcherImpl fetcher = new DarkskyForecastFetcherImpl(url, accessToken);

        // When
        final Optional<DarkskyResponseDto> optDto = fetcher.fetch(lat, lng);

        // Then
        assertThat(optDto, isPresentAnd(instanceOf(DarkskyResponseDto.class)));
    }

    @Test
    @DisplayName("Should return empty when some exceptional happens")
    public void failPath() {

        // Given
        final StubMapping stubMapping = stubFor(
            get(urlPathMatching("/" + accessToken + "/" + lat + "," + lng))
                .withQueryParam("exclude", WireMock.equalTo("currently,minutely,flags"))
                .willReturn(
                    aResponse()
                        .withStatus(400)
                        .withHeader("Content-Type", "application/json")
                )
        );
        final DarkskyForecastFetcherImpl fetcher = new DarkskyForecastFetcherImpl(url, accessToken);

        // When
        final Optional<DarkskyResponseDto> optDto = fetcher.fetch(lat, lng);

        // Then
        assertThat(optDto, isEmpty());
    }
}
