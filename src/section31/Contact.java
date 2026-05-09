package section31;

public class Contact {
    private int id;
    private String name;
    private String surname;
    private String phone;

    // getter
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public String getPhone() {
        return this.phone;
    }

    // setter
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
