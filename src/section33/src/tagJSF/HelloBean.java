package section33.src.tagJSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.BarChartModel;

@ManagedBean(name="hello")
@RequestScoped
public class HelloBean implements Serializable {
    @ManagedProperty(value="#param.number")
    private String page;
    private String name;
    private String biography;
    private List<String> options;
    private List<String> images;
    private BarChartModel barModel;

    // getter
    public String getName() {
        return this.name;
    }
    
    public String getBiography() {
        return this.biography;
    }

    public List<String> getOptions() {
        return this.options;
    }
    
    public List<String> getImages() {
        return this.images;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
    
    public void setImages(List<String> images) {
        this.images = images;
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

    public void update() {
        //...//
    }

    public List<String> search(String query) {
        List<String> r = new ArrayList<String>();

        if(query.equals("course")) {
            r.add("course Java");
            r.add("course JSF");
            r.add("course PrimeFaces");
            r.add("course Java EE");
        }
        return r;
    }
    
    public void init() {
        this.options = new ArrayList<String>();
        this.options.add("course Java");
        this.options.add("course JSF");
        this.options.add("course PrimeFaces");
        this.options.add("course Java EE");
        
        this.images = new ArrayList<String>();
        this.images.add("image.png");
        this.images.add("image1.png");

        this.barModel = new BarChartModel();
        ChartSeries s1 = new ChartSeries("Cars sold");
        s1.set("2010", 10000);
        s1.set("2011", 12355);
        s1.set("2012", 100);
        s1.set("2013", 10456);
        s1.set("2015", 56800);
        s1.set("2010", 67780);
        
        ChartSeries s2 = new ChartSeries("motorbikes sold");
        s1.set("2010", 10600);
        s1.set("2011", 1235);
        s1.set("2012", 1456);
        s1.set("2013", 14556);
        s1.set("2014", 54400);
        s1.set("2015", 3330);

        this.barModel.addSeries(s1);
        this.barModel.addSeries(s2);
        
        this.barModel.setTitle("car/motorcycle sales comparison");
        
        Axis x = this.barModel.getAxis(AxisType.X);
        x.setLabel("Years");
        Axis y = this.barModel.getAxis(AxisType.Y);
        y.setLabel("sales");
    }
}
