package section33.src.tagJSF;

import java.io.Serializable;

import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="hello")
@RequestScoped
public class HelloBean implements Serializable {
    @ManagedProperty(value="#param.number")
    private String page;

    private String name;
    private String biography;

    // getter
    public String getName() {
        return this.name;
    }
    
    public String getBiography() {
        return this.biography;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String sayHello() {
        setBiography("BIO");
        
        switch(this.page != null ? this.page : "") {
            case "1":
                return "home1";
            case "2":
                return "home2";
            case "1red":
                return "home1?faces-redirect=true";
            default:
                return "home";
        }
    }
}
