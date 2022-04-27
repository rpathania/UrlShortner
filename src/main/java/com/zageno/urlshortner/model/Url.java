package com.zageno.urlshortner.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

/** The model class, represents the table to store the urls
 * @author Rishi Pathania
 * @version 1.0
 */
@Entity
@Table(name = "url_tbl")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_generator1")
    @SequenceGenerator(name="id_generator1",initialValue = 999, allocationSize = 3)
    private long id;

    @Column(nullable = false)
    private String longUrl;

    @Column(nullable = false)
    private LocalDateTime createdDate;

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
