package com.dolores.weather.service.fetcher;

import com.dolores.weather.fetcher.dto.DarkskyResponseDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAnd;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class DarkskyForecastFetcherImplIT {

    private final String url = "https://api.darksky.net/forecast";
    private final String accessToken = "ced014343d18fd41780ceb0d9ed8c6a2";
    private final Double lat = 37.8267D;
    private final Double lng = -122.4233D;

    @Test
    @DisplayName("Method fetch should should work correctly when Darksky is up")
    public void happyPath() {

        // Given
        final DarkskyForecastFetcherImpl fetcher = new DarkskyForecastFetcherImpl(url, accessToken);

        // When
        final Optional<DarkskyResponseDto> optDto = fetcher.fetch(lat, lng);

        // Then
        assertThat(optDto, isPresentAnd(instanceOf(DarkskyResponseDto.class)));
    }
}
