package com.getmobileltd.cotenant;

public class AppInstance {
    private static AppInstance sInstance = null;
    //User attributes.
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phone_number;
    private String password;
    private String gender;
    private Integer code;
    private Integer user_id;


    //Cotenant attributes.
    private String co_gender;
    private String religion;
    private String co_religion;
    private String smoke;
    private String co_smoke;
    private String disabled;
    private String co_disabled;
    private String location_1;
    private String location_2;
    private String work;
    private String salary;
    private String rent;
    private String duration;
    private Integer co_id;

    public static AppInstance getInstance() {
        if (sInstance == null) {
            sInstance = new AppInstance();
        }
        return sInstance;
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCo_gender() {
        return co_gender;
    }

    public void setCo_gender(String co_gender) {
        this.co_gender = co_gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCo_religion() {
        return co_religion;
    }

    public void setCo_religion(String co_religion) {
        this.co_religion = co_religion;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getCo_smoke() {
        return co_smoke;
    }

    public void setCo_smoke(String co_smoke) {
        this.co_smoke = co_smoke;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getCo_disabled() {
        return co_disabled;
    }

    public void setCo_disabled(String co_disabled) {
        this.co_disabled = co_disabled;
    }

    public String getLocation_1() {
        return location_1;
    }

    public void setLocation_1(String location_1) {
        this.location_1 = location_1;
    }

    public String getLocation_2() {
        return location_2;
    }

    public void setLocation_2(String location_2) {
        this.location_2 = location_2;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getCo_id() {
        return co_id;
    }

    public void setCo_id(Integer co_id) {
        this.co_id = co_id;
    }




    public String getFirstName() {
        return firstName;

    }

    public String getLastName() {
        return lastName;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
