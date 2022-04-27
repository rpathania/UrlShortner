package com.zageno.urlshortner.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** Represents the utility class for encoding and decoding the urls
 * @author Rishi Pathania
 * @version 1.0
 */
@Service
public class ConversionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversionUtil.class);
    private static final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] allowedCharacters = allowedString.toCharArray();
    private int len = allowedCharacters.length;

    public String encode(long inputId, long offset){
        LOGGER.info("offset:"+offset);
        LOGGER.info("inpiutid:"+offset);
        StringBuilder encodedString= new StringBuilder();

       /* if(inputId == 0) {
            return String.valueOf(allowedCharacters[0]);
        }*/

        while (inputId > 0) {
            encodedString.append(allowedCharacters[(int) (inputId % len)]);
            inputId = inputId / len;
        }
        LOGGER.info("encodedString:"+encodedString);
        while (offset > 0) {
            encodedString.append(allowedCharacters[(int) (offset % len)]);
            offset = offset / len;
        }

        return encodedString.reverse().toString();
    }

    public long decode(String input) {
        char[] characters = input.toCharArray();
        int length = characters.length;

        int decoded = 0;

        //counter is used to avoid reversing input string
        var counter = 1;
        for (int i = 0; i < length; i++) {
            decoded += allowedString.indexOf(characters[i]) * Math.pow(len, length - counter);
            counter++;
        }
        return decoded;
    }

    public long getOffsetValue(String inputValue){

        return decode(inputValue.substring(0,0));

    }

}
