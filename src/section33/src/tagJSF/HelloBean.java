package section33.src;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="hello")
@RequestScoped
public class HelloBean implements Serializable {
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
        return "";
    }
}
