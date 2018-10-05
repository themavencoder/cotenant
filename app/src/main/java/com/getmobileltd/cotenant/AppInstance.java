package com.getmobileltd.cotenant;

import android.app.Application;

import com.getmobileltd.cotenant.registration.chooseworkmvp.ChooseWorkModel;

public class AppInstance extends Application{
    private static AppInstance sInstance = null;
private String firstName;
private String lastName;
private String work;


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
public String getWork() {
        return work;
}
public void setWork(String work) {
        this.work = work;
}
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}


}
