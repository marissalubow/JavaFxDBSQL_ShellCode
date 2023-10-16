package com.mycompany.javafx_db_example;

public class Person2 {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private int salary;

    public Person2() {
    }


    public Person2(String name, String phone, String password, String address, String email, int salary) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.salary = salary;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public String getphone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =password;
    }

    public String getAddress() {return address;}

    public void setAddress(String address) {
        this.address =address;
    }

    public int getSalary(){return salary;}

    public void setSalary(int salary){this.salary = salary;}


}

