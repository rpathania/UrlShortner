package com.zageno.urlshortner.service;

import com.zageno.urlshortner.dto.UrlDto;
import com.zageno.urlshortner.dto.ShortUrlResponse;

/** Represents the service interface
 * @author Rishi Pathania
 * @version 1.0
 */
public interface ShortLinkService {

    public ShortUrlResponse convertToShortUrl(UrlDto urlDto);

    public String convertToOriginalUrl(String shortUrl);
}
