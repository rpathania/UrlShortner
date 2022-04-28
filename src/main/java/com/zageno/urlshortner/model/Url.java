package com.zageno.urlshortner.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

/** The model class, represents the table to store the urls
 * @author Rishi Pathania
 * @version 1.0
 */
@Entity
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "url_id_generator")
    @SequenceGenerator(name="url_id_generator",initialValue = 999, allocationSize = 3)
    @JsonIgnore
    private long id;

    @Column(nullable = false)
    @JsonProperty("long_url")
    private String longUrl;

    @Column(nullable = false)
    @JsonProperty("created_at")
    private LocalDateTime createdDate;

    @JsonProperty("expires_at")
    private LocalDateTime expiresDate;

    public long getId() {
        return id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getExpiresDate() {
        return expiresDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setExpiresDate(LocalDateTime expiresDate) {
        this.expiresDate = expiresDate;
    }
}
