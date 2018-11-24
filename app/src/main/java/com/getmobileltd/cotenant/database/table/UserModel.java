package com.getmobileltd.cotenant.database.table;



import com.getmobileltd.cotenant.database.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.parceler.Parcel;

import java.util.UUID;

@Table(database = MyDatabase.class)
@Parcel(analyze = {UserModel.class})
public class UserModel extends BaseModel {

    @PrimaryKey
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String placeOfWork;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

}
