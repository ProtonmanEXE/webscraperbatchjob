package protonmanexe.com.webscraperjob.service;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Webscraper {

    private final static Logger log = LoggerFactory.getLogger(Webscraper.class);
    
    public Elements scrapeNewsSite(String url, String cssQuery) {
        log.info("Initialising webscraping");
 
        // Initializing HTML Document page variable
        Document doc;
    
        try {
        // Scraping target website
            log.info("Connecting to {}", url);
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) + AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
                    .get();
            log.info("Connected to {} successfully", url);
        } catch (IOException e) {
            log.error("Error connecting to {}", url);
            throw new RuntimeException(e);
        }

        // Retrieving list of HTML elements in the target page
        return doc.select(cssQuery);
    }
}