package protonmanexe.com.webscraperjob.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import protonmanexe.com.webscraperjob.models.GreenwoodNewsArticle;

@Component
public class GeneralUtils {

    public List<GreenwoodNewsArticle> checkForDuplicateNews(List<GreenwoodNewsArticle> list) {
        List<GreenwoodNewsArticle> newList = new ArrayList<>();
        boolean duplicateFlag = false;

        for (GreenwoodNewsArticle article : list) {
            if (newList.isEmpty()) {
                newList.add(article);
            } else {
                for (GreenwoodNewsArticle addedArticle : newList) {
                    if (article.getHeadlines().equalsIgnoreCase(addedArticle.getHeadlines())) {
                        duplicateFlag = true;
                        break;
                    } else duplicateFlag = false;
                }

                if (!duplicateFlag) newList.add(article);
            }
        }
        
        return newList;
    }

}
