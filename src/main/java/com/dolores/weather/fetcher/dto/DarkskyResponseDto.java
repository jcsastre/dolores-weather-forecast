package com.dolores.weather.fetcher.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DarkskyResponseDto {

    private Double latitude;
    private Double longitude;
    private String timezone;
    private Hourly hourly;

    @NoArgsConstructor
    @Getter
    @Setter
    public static class Hourly {

        private List<Condition> data;

        @NoArgsConstructor
        @Getter
        @Setter
        public static class Condition {

            private Long    time;
            private Double  precipIntensity;
            private Double  precipProbability;
            private String  precipType;
            private Double  temperature;
            private Double  apparentTemperature;
            private Double  dewPoint;
            private Double  humidity;
            private Double  pressure;
            private Double  windSpeed;
            private Double  windGust;
            private Integer windBearing;
            private Double  cloudCover;
            private Integer uvIndex;
            private Double  visibility;
            private Double  ozone;
        }
    }
}
