package com.getmobileltd.cotenant.database.table;

import com.getmobileltd.cotenant.database.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.parceler.Parcel;

@Table(database = MyDatabase.class)
@Parcel(analyze = {SavedCards.class})
public class SavedCards extends BaseModel {

    @PrimaryKey
    private int id;

    @Column
    private int card_digits;

    @Column
    private int expiration_date;

    @Column
    private int expiration_year;

    @Column
    private int cvv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCard_digits() {
        return card_digits;
    }

    public void setCard_digits(int card_digits) {
        this.card_digits = card_digits;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(int expiration_date) {
        this.expiration_date = expiration_date;
    }

    public int getExpiration_year() {
        return expiration_year;
    }

    public void setExpiration_year(int expiration_year) {
        this.expiration_year = expiration_year;
    }

}
