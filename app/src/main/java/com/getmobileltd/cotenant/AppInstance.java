package com.getmobileltd.cotenant;

public class AppInstance {
    private static AppInstance sInstance = null;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phone_number;
    private String password;
    private String gender;
    private Integer code;


    public static AppInstance getInstance() {
        if (sInstance == null) {
            sInstance = new AppInstance();
        }
        return sInstance;
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
public void setGender(String gender){
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
    public String getPassword() {return password; }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}

    public void setPhone_number(String phone_number) {this.phone_number = phone_number;}

    public void setPassword(String password) {this.password = password;}




}
