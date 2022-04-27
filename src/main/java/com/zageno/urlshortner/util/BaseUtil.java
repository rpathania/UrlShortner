package com.zageno.urlshortner.util;

import com.zageno.urlshortner.dto.UrlDto;
import com.zageno.urlshortner.exceptions.UrlInvalidException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
/** Represents general utility methods.
 * @author Rishi Pathania
 * @version 1.0
 */
public class BaseUtil {

    public static boolean checkRequestBody(UrlDto urlDto)  {

        try {
            new URL(urlDto.getLongUrl()).toURI();
            return true;
        }
        catch(MalformedURLException | URISyntaxException malformedURLException){
            throw new UrlInvalidException("Please enter a valid URL");
        }

    }

    public static String extractShortUrl(String url){

        return url.substring(url.lastIndexOf("/")+1);
    }
}
