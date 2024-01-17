package org.example.testing.task;


public class User {
    private Integer userId;
    private String name;
    private String email;
    private Address address;
    private String phoneNumber;

    private Integer age;

    public User(Integer id, String name, String email, Address address, String phoneNumber, Integer age)
    {
        setUserId(id);
        setName(name);
        setEmail(email);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setAge(age);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
