package com.zageno.urlshortner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents short link response object to be sent as a response
 * @author Rishi Pathania
 * @version 1.0
 */
public class ShortUrlResponse {
    @JsonProperty("short_link")
    private String shortLink;
    @JsonProperty("expires_at")
    private String expiresOn;
    @JsonProperty("created_at")
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getShortLink() {
        return shortLink;
    }

    public String getExpiresOn() {
        return expiresOn;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public void setExpiresOn(String expiresOn) {
        this.expiresOn = expiresOn;
    }
}
