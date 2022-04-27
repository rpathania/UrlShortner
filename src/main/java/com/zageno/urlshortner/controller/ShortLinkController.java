package com.zageno.urlshortner.controller;

import com.zageno.urlshortner.dto.UrlDto;
import com.zageno.urlshortner.dto.ShortUrlResponse;
import com.zageno.urlshortner.service.ShortLinkService;

import com.zageno.urlshortner.util.BaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.net.URI;

/** Controller class.
 * @author Rishi Pathania
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/acme*")
public class ShortLinkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShortLinkController.class);
    @Autowired
    ShortLinkService shortLinkService;

    @PostMapping("generate-short-url") // post mapping
    public ResponseEntity generateShortUrl(@RequestBody UrlDto urlDto){
        LOGGER.info("POST request for url : "+urlDto.getLongUrl());
        if(BaseUtil.checkRequestBody(urlDto)) {
            ShortUrlResponse shortUrlResponse = shortLinkService.convertToShortUrl(urlDto);
            return new ResponseEntity(shortUrlResponse, HttpStatus.CREATED);
        }
        return null;
    }

    @GetMapping("/https://atiny/{shortUrl}") // get mapping, {shortUrl} is the generated short link
    public ResponseEntity<Void> getUrlAndRedirect(@PathVariable String shortUrl) throws EntityNotFoundException {
        LOGGER.info("GET request for shortUrl: "+shortUrl);
        String  url = shortLinkService.convertToOriginalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();

    }


}
