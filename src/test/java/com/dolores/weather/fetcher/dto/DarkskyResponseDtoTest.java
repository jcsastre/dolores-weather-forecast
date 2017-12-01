package com.dolores.weather.fetcher.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DarkskyResponseDtoTest {

    @Test
    public void shouldDeserializeCorrectly() throws Exception {

        // Given
        final URL urlToSuccessfulJsonResponse =
            getClass().getResource("/com/dolores/weather/fetcher/dto/successful-response.json");

        // When
        final DarkskyResponseDto darkskyResponseDto =
            new ObjectMapper()
//                .registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule())
                .readerFor(DarkskyResponseDto.class)
                .readValue(urlToSuccessfulJsonResponse);

        // Then
        assertThat(darkskyResponseDto.getLatitude(), is(37.8267D));
        assertThat(darkskyResponseDto.getLongitude(), is(-122.4233));
        assertThat(darkskyResponseDto.getTimezone(), is("America/Los_Angeles"));

        assertThat(darkskyResponseDto.getHourly().getData().get(0).getTime(), is(1511884800L));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getPrecipIntensity(), is(0.0002D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getPrecipProbability(), is(0.03D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getPrecipType(), is("rain"));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getTemperature(), is(46.04D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getApparentTemperature(), is(46.04D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getDewPoint(), is(42.33D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getHumidity(), is(0.87D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getPressure(), is(1021.14D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getWindSpeed(), is(1.41D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getWindGust(), is(1.93D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getWindBearing(), is(26));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getCloudCover(), is(0.22D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getUvIndex(), is(0));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getVisibility(), is(9.99D));
        assertThat(darkskyResponseDto.getHourly().getData().get(0).getOzone(), is(276.73D));

        assertThat(darkskyResponseDto.getHourly().getData().get(1).getTime(), is(1511888400L));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getPrecipIntensity(), is(0.0002D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getPrecipProbability(), is(0.02D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getPrecipType(), is("rain"));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getTemperature(), is(50.26D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getApparentTemperature(), is(50.26D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getDewPoint(), is(44.18D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getHumidity(), is(0.8D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getPressure(), is(1021.56D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getWindSpeed(), is(2.54D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getWindGust(), is(3.14D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getWindBearing(), is(308));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getCloudCover(), is(0.4D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getUvIndex(), is(1));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getVisibility(), is(10D));
        assertThat(darkskyResponseDto.getHourly().getData().get(1).getOzone(), is(277.32D));
    }
}
