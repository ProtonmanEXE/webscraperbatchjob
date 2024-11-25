package protonmanexe.com.webscraperjob.models;

public class GreenwoodNewsArticle {

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
    public String toString() {
        return "{" +
            " itemNumber='" + getItemNumber() + "'" +
            ", headlines='" + getHeadlines() + "'" +
            ", description='" + getDescription() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }

}