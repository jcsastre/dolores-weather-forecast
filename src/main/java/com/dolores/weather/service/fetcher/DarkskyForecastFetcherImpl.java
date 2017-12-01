package com.dolores.weather.service.fetcher;

import com.dolores.weather.fetcher.dto.DarkskyResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
public class DarkskyForecastFetcherImpl implements DarkskyForecastFetcher {

    private final String url;
    private final String accessToken;

    public DarkskyForecastFetcherImpl(
        String url,
        String accessToken
    ) {
        this.url = url;
        this.accessToken = accessToken;
    }

    @Override
    public Optional<DarkskyResponseDto> fetch(Double lat, Double lng) {

        //TODO: Build URI based on UriComponentBuilder
        final String url = this.url + "/" + accessToken + "/" + lat + "," + lng + "?exclude=currently,minutely,flags";
        log.debug("Fetching: {}", url);

        DarkskyResponseDto dto = null;

        try {
            dto = new RestTemplate().getForObject(url, DarkskyResponseDto.class);
        } catch(RestClientException e) {
            log.error("Exception fetching", e);
        }

        return Optional.ofNullable(dto);
    }

//    @Override
//    public Mono<DarkskyResponseDto> fetchAsMono(Double lat, Double lng) {
//
//        final String url = this.url + "/" + accessToken + "/" + lat + "," + lng + "?exclude=currently,minutely,flags";
//        log.debug("Fetching: {}", url);
//
//        return
//            WebClient
//                .create(url)
//                .get()
////                .uri(uriBuilder -> uriBuilder.pathSegment())
//                .accept(MediaType.APPLICATION_JSON)
//                .acceptCharset(Charset.defaultCharset())
//                .exchange()
//                .flatMap(clientResponse -> clientResponse.bodyToMono(DarkskyResponseDto.class));
//    }
}
