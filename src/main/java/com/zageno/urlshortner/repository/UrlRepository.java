package com.zageno.urlshortner.repository;
import com.zageno.urlshortner.model.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/** Represents the url repository.
 * @author Rishi Pathania
 * @version 1.0
 */
@Repository
public interface UrlRepository extends CrudRepository<Url,Long> {


}
