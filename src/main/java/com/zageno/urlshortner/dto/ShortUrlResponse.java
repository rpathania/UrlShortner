package com.zageno.urlshortner.dto;

/** Represents short link response object to be sent as a response
 * @author Rishi Pathania
 * @version 1.0
 */
public class ShortUrlResponse {

    private String shortLink;
    private String expiresOn;
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
