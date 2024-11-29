package protonmanexe.com.webscraperjob.models;

import java.io.Serializable;

public class GreenwoodNewsArticle implements Serializable{

    private int itemNumber;
    private String headlines;
    private String description;
    private String url;

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

    public String getDescription() {
      return this.description;
    }
    public void setDescription(String value) {
      this.description = value;
    }

    public String getUrl() {
      return this.url;
    }
    public void setUrl(String value) {
      this.url = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        GreenwoodNewsArticle that = (GreenwoodNewsArticle) object;
        return getItemNumber() == that.getItemNumber() && java.util.Objects.equals(getHeadlines(), 
            that.getHeadlines()) && java.util.Objects.equals(getDescription(), 
            that.getDescription()) && java.util.Objects.equals(getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getItemNumber(), getHeadlines(), getDescription(), getUrl());
    }

    @Override
    public String toString() {
        return "{" +
            " itemNumber='" + getItemNumber() + "'" +
            ", headlines='" + getHeadlines() + "'" +
            ", description='" + getDescription() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }

}