package com.example.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RatingBar;


public class MainActivity extends AppCompatActivity {
    private Button btnShowRating;
    private TextView txtViewRating;
    private RatingBar ratingBar;
    private float increaseRating = 0.5F;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowRating = (Button) findViewById(R.id.btnGetRating);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtViewRating = (TextView) findViewById(R.id.txtViewRating);
        final float[] getRating = {ratingBar.getRating()};
        btnShowRating.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int noofStars = ratingBar.getNumStars();
                getRating[0] = getRating[0] + increaseRating;
                if (getRating[0] < 5){
                    txtViewRating.setText("Rating: "+ getRating[0] +"/"+noofStars);
                    txtViewRating.setTextColor(Color.parseColor("#2b2bbd"));
                    ratingBar.setRating(getRating[0]);
                }else{
                    txtViewRating.setText("Max Rating : "+ getRating[0] +"/"+noofStars);
                    txtViewRating.setTextColor(Color.parseColor("#234343"));
                    ratingBar.setRating(getRating[0]);
                    btnShowRating.setEnabled(false);
                }
            }
        });
    }
}