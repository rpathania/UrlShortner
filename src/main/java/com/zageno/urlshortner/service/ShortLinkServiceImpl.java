package com.zageno.urlshortner.service;
import com.zageno.urlshortner.dto.UrlDto;
import com.zageno.urlshortner.exceptions.LinkExpiredException;
import com.zageno.urlshortner.exceptions.LinkNotSavedException;
import com.zageno.urlshortner.dto.ShortUrlResponse;
import com.zageno.urlshortner.model.Url;
import com.zageno.urlshortner.repository.UrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Date;

/** ShortLink service implementation class
 * @author Rishi Pathania
 * @version 1.0
 */
@Service
public class ShortLinkServiceImpl implements ShortLinkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShortLinkServiceImpl.class);
    @Autowired
    ConversionUtil conversionUtil;
    @Autowired
    UrlRepository urlRepository;

    private static final String DOMAIN = "https://atiny/";

    @Override
    public ShortUrlResponse convertToShortUrl(UrlDto urlDto) {
        LOGGER.info("Convert to short Url started");
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println(localDateTime.getSecond());
            Url url = new Url();
            url.setLongUrl(urlDto.getLongUrl());
            url.setExpiresDate(urlDto.getExpiresDate());
            url.setCreatedDate(localDateTime);
            Url savedUrl = urlRepository.save(url);
            ShortUrlResponse shortUrlResponse = new ShortUrlResponse();
            shortUrlResponse.setShortLink( DOMAIN + conversionUtil.encode(savedUrl.getId(), localDateTime.getSecond()));
            shortUrlResponse.setExpiresOn(urlDto.getExpiresDate()==null?null:urlDto.getExpiresDate().toString());
            shortUrlResponse.setCreatedAt(new Date().toString());
            return shortUrlResponse;
        } catch (Exception e){
            LOGGER.error("Exception occured while converting to short URL "+e.getMessage());
            throw new LinkNotSavedException("Link not saved");
        }

    }

    @Override
    public String convertToOriginalUrl(String shortUrl) {
        LOGGER.info("Convert to original Url started for :"+shortUrl);
        Long urlId = conversionUtil.decode(shortUrl.substring(1));
        LOGGER.info("urlid = "+urlId);
        Long offSet = conversionUtil.getOffsetValue(shortUrl);
        LOGGER.info("URLID = "+urlId + " offset " +offSet);
        Url url = urlRepository.findById(urlId-offSet)
                .orElseThrow(()-> new EntityNotFoundException("Entity not present for: "+shortUrl));
        if(url.getExpiresDate()!=null  && url.getExpiresDate().isBefore(LocalDateTime.now()))
            throw new LinkExpiredException("Link expired!");
        return url.getLongUrl();
    }
}
