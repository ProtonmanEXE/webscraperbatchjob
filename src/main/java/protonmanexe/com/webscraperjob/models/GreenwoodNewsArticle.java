package protonmanexe.com.webscraperjob.models;

import java.io.Serializable;

public class GreenwoodNewsArticle implements Serializable{

    private static final long serialVersionUID = 664672716035062719L;

    private int itemNumber;
    private String headlines;
    private String date;
    private String url;
    private String sourceUrl;

    public GreenwoodNewsArticle() {}
    
    public GreenwoodNewsArticle(int itemNumber) {
      this.itemNumber = itemNumber;
    }

    public int getItemNumber() {
      return this.itemNumber;
    }
    public void setItemNumber(int value) {
      this.itemNumber = value;
    }

    public String getHeadlines() {
      return this.headlines;
    }
    public void setHeadlines(String value) {
      this.headlines = value;
    }

    public String getDate() {
      return this.date;
    }

    public void setDate(String date) {
      this.date = date;
    }

    public String getUrl() {
      return this.url;
    }
    public void setUrl(String value) {
      this.url = value;
    }

    public String getSourceUrl() {
      return this.sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
      this.sourceUrl = sourceUrl;
    }

    @Override
    public String toString() {
      return "{" +
        " itemNumber='" + getItemNumber() + "'" +
        ", headlines='" + getHeadlines() + "'" +
        ", date='" + getDate() + "'" +
        ", url='" + getUrl() + "'" +
        ", sourceUrl='" + getSourceUrl() + "'" +
        "}";
  }

}