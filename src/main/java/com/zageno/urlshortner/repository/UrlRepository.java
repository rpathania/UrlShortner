package com.zageno.urlshortner.repository;
import com.zageno.urlshortner.model.Url;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/** Represents the url repository.
 * @author Rishi Pathania
 * @version 1.0
 */
@Repository
public interface UrlRepository extends CrudRepository<Url,Long> {

    @Query("select u from Url u where u.expiresDate < :present")
    public List<Url> getExpiredUrls(@Param("present")LocalDateTime present);
}
