package com.zageno.urlshortner.service;

import com.zageno.urlshortner.dto.UrlDto;
import com.zageno.urlshortner.dto.ShortUrlResponse;
import com.zageno.urlshortner.model.Url;

import java.util.List;

/** Represents the service interface
 * @author Rishi Pathania
 * @version 1.0
 */
public interface ShortLinkService {

    public ShortUrlResponse convertToShortUrl(UrlDto urlDto);

    public String convertToOriginalUrl(String shortUrl);

    public List<Url> deleteExpiredUrls();
}
