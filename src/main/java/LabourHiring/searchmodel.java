package LabourHiring;

public class searchmodel {
    String Name, Email, Address, Area, Category;
    Integer Phone;

    public searchmodel(String Name, Integer Phone, String Email, String Address, String Area, String Category) {
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Area = Area;
        this.Category = Category;


    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getArea() {
        return Area;
    }

    public String getCategory() {
        return Category;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setArea(String area) {
        Area = area;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }
}