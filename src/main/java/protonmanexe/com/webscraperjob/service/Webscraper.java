package protonmanexe.com.webscraperjob.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import protonmanexe.com.webscraperjob.models.Product;

@Service
public class Webscraper {

    private final static Logger log = LoggerFactory.getLogger(Webscraper.class);
    
    public List<Product> scrapeNewsSite(String url) {
        log.info("Initialising webscraping");
 
        // initializing the HTML Document page variable
        Document doc;
		List<Product> products = new ArrayList<>(); 
    
        try {
            // fetching the target website
            log.info("Connecting to {}", url);
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) + AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
                    .get();
            log.info("Connected to {} successfully", url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // retrieving the list of product HTML elements in the target page
        Elements productElements = doc.select("h3.tnt-headline");

        // iterating over the list of HTML products
        for (Element productElement : productElements) {
            Product product = new Product();

            // extracting the data of interest from the product HTML element
            // and storing it in Product
            product.setUrl(productElement.selectFirst("a").attr("href"));
            product.setName(productElement.selectFirst("a").text());

            // adding Product to the list of the scraped products
            products.add(product);
            log.info("Discovered {}", product.getName());
        }

        return products;
    }
}