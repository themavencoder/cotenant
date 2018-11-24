package com.getmobileltd.cotenant.database.table;



import com.getmobileltd.cotenant.database.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.parceler.Parcel;

import java.util.UUID;

@Table(database = MyDatabase.class)
@Parcel(analyze = {Favorites.class})
public class Favorites extends BaseModel {

    @PrimaryKey
    private int id;

    @Column
    private boolean isLike;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
