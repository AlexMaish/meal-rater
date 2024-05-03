package com.example.mealrater.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RestaurantDatabase extends SQLiteOpenHelper {

    private static RestaurantDatabase restaurantDatabase;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "RestaurantDatabase";

    private static final String TABLE_NAME = "Restaurants";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_RESTAURANT_NAME = "restaurant_name";
    private static final String COLUMN_DISH_NAME = "dish_name";
    private static final String COLUMN_RATING = "rating";

    public static RestaurantDatabase getInstance(Context context){
        if (restaurantDatabase==null){
            restaurantDatabase = new RestaurantDatabase(context);
        }
        return restaurantDatabase;
    }

    private RestaurantDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_RESTAURANT_NAME + " TEXT, " +
                COLUMN_DISH_NAME + " TEXT, " +
                COLUMN_RATING + " INTEGER " +
                " ) ";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addRestaurant(Data data) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_RESTAURANT_NAME + ", " +
                COLUMN_DISH_NAME + ", " +
                COLUMN_RATING +
                ") VALUES ('" +
                data.getRestaurantName() + "', '" +
                data.getDishName() + "', '" +
                data.getRating() + "')";
        db.execSQL(query);
        db.close();
    }
}

