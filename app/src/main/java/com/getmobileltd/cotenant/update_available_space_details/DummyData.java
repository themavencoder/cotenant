package com.getmobileltd.cotenant.update_available_space_details;

public class DummyData {
    private static DummyData sData = null;
    private int id;
    private boolean isLIke;

    public static DummyData getDummyData() {
        if (sData == null) {
            sData = new DummyData();
        }
        return  sData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLIke(boolean LIke) {
        isLIke = LIke;
    }

    public boolean isLIke() {
        return isLIke;
    }
}

