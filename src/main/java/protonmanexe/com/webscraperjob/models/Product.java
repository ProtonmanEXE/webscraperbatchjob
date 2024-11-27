package protonmanexe.com.webscraperjob.models;

public class Product {

    private String url; 
	private String image; 
	private String name; 
	private String price; 

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
            " url='" + getUrl() + "'" +
            ", image='" + getImage() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
    
}