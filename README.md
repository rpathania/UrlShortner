# UrlShortner service

The url shortening service provides the following functionalities:
>Shorten the URL posted and
>Redirect to the site once short url is provided

Please refer to the URLShortner_Api_doc.html for API docs


Algo used for encoding and decoding:
  
  encoding(Id,Offset):
    while(number > 0)
    remainder = number % 62
    number = number / 62
    
    while(offset > 0)
    remainder = offset % 62
    offset = offset / 62
    
   decoding:
   while(i < shortUrl lenght)
	    counter = i + 1
	    mapped = base62alphabet.indexOf(shortUrl[i]) 
	    result = result + mapped * 62^(shortUrl lenght - counter)
	    i++
    
