package com.zageno.urlshortner.dto;

import java.time.LocalDateTime;

/** Represents a data transfer object for url request.
 * @author Rishi Pathania
 * @version 1.0
 */
public class UrlDto {

    private String longUrl;

    private LocalDateTime expiresDate;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public LocalDateTime getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(LocalDateTime expiresDate) {
        this.expiresDate = expiresDate;
    }
}
