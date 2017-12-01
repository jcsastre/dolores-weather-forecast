package com.dolores.weather.service.fetcher;

import com.dolores.weather.fetcher.dto.DarkskyResponseDto;

import java.util.Optional;

public interface DarkskyForecastFetcher {

    public Optional<DarkskyResponseDto> fetch(Double lat, Double lng);

//    public Mono<DarkskyResponseDto> fetchAsMono(Double lat, Double lng);
}
