package com.example.mealrater;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mealrater.data.Data;
import com.example.mealrater.data.RestaurantDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView txtRate;
    private EditText edRestaurant, edDish;
    double rateValue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edRestaurant = findViewById(R.id.ed_restaurant);
        edDish = findViewById(R.id.ed_dish);

        Button btnRateMeal = findViewById(R.id.btn_rate_meal);
        btnRateMeal.setOnClickListener(view -> {
            rateValue = 1;
            displayRatingDialog();
        });
        Button btnSaveRating = findViewById(R.id.btn_save_ratings);
        btnSaveRating.setOnClickListener(view -> {
            if (!(edDish.getText().toString().isEmpty() || edRestaurant.getText().toString().isEmpty())) {
                RestaurantDatabase restaurantDatabase = RestaurantDatabase.getInstance(MainActivity.this);
                Data data = new Data(edRestaurant.getText().toString(), edDish.getText().toString(), String.valueOf(rateValue));
                restaurantDatabase.addRestaurant(data);
                Toast.makeText(this, "Restaurant and Rating Saved!!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Failed!! You have empty fields", Toast.LENGTH_LONG).show();
            }
        });
        txtRate = findViewById(R.id.txt_rating);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void displayRatingDialog() {
        View root = LayoutInflater.from(this).inflate(R.layout.rating_dialog_layout, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog;
        builder.setView(root);
        dialog = builder.create();
        dialog.show();

        List<TextView> rateViews = new ArrayList<>();

        TextView txtRate1 = root.findViewById(R.id.rate1);
        TextView txtRate2 = root.findViewById(R.id.rate2);
        TextView txtRate3 = root.findViewById(R.id.rate3);
        TextView txtRate4 = root.findViewById(R.id.rate4);
        TextView txtRate5 = root.findViewById(R.id.rate5);

        rateViews.add(txtRate1);
        rateViews.add(txtRate2);
        rateViews.add(txtRate3);
        rateViews.add(txtRate4);
        rateViews.add(txtRate5);

        TextView btnRate = root.findViewById(R.id.btn_rate);
        TextView btnCancel = root.findViewById(R.id.btn_cancel);

        txtRate1.setOnClickListener(view -> {
            for (int i = 0; i < rateViews.size(); i++) {
                if (i == 0) {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.filled_rectangle, null));
                    rateViews.get(i).setTextColor(Color.WHITE);
                } else {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.border_rectangle, null));
                    rateViews.get(i).setTextColor(Color.BLACK);
                }
            }
            rateValue = 1;
        });
        txtRate5.setOnClickListener(view -> {
            for (int i = 0; i < rateViews.size(); i++) {
                if (i == 4) {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.filled_rectangle, null));
                    rateViews.get(i).setTextColor(Color.WHITE);
                } else {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.border_rectangle, null));
                    rateViews.get(i).setTextColor(Color.BLACK);
                }
            }
            rateValue = 5;
        });
        txtRate2.setOnClickListener(view -> {
            for (int i = 0; i < rateViews.size(); i++) {
                if (i == 1) {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.filled_rectangle, null));
                    rateViews.get(i).setTextColor(Color.WHITE);
                } else {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.border_rectangle, null));
                    rateViews.get(i).setTextColor(Color.BLACK);
                }
            }
            rateValue = 2;
        });
        txtRate3.setOnClickListener(view -> {
            for (int i = 0; i < rateViews.size(); i++) {
                if (i == 2) {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.filled_rectangle, null));
                    rateViews.get(i).setTextColor(Color.WHITE);
                } else {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.border_rectangle, null));
                    rateViews.get(i).setTextColor(Color.BLACK);
                }
            }
            rateValue = 3;
        });
        txtRate4.setOnClickListener(view -> {
            for (int i = 0; i < rateViews.size(); i++) {
                if (i == 3) {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.filled_rectangle, null));
                    rateViews.get(i).setTextColor(Color.WHITE);
                } else {
                    rateViews.get(i).setBackground(getResources().getDrawable(R.drawable.border_rectangle, null));
                    rateViews.get(i).setTextColor(Color.BLACK);
                }
            }
            rateValue = 4;
        });

        btnRate.setOnClickListener(view -> {
            txtRate.setText(String.valueOf(rateValue));
            dialog.dismiss();
        });

        btnCancel.setOnClickListener(view -> dialog.dismiss());
    }
}