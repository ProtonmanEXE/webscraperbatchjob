package protonmanexe.com.webscraperjob.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import protonmanexe.com.webscraperjob.models.GreenwoodNewsArticle;
import protonmanexe.com.webscraperjob.models.Product;

@Service
public class GreenwoodNewsService {

    private final static Logger log = LoggerFactory.getLogger(GreenwoodNewsService.class);

    @Value("${greenwood.news.home.page: https://www.indexjournal.com/}")
    private String greenwoodNewsUrl;

    @Autowired
    private Webscraper webscraper;

    public GreenwoodNewsArticle scrapeGreenwoodNewsWebsite() {
         
        List<Product> products = webscraper.scrapeNewsSite(greenwoodNewsUrl); 

		log.info("Number of objects scraped: {}", products.size());

        return null;
    }

}
