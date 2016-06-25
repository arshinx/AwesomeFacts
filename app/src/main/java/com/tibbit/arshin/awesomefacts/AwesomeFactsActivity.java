package com.tibbit.arshin.awesomefacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class AwesomeFactsActivity extends AppCompatActivity {

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    // Declare view variables
    private TextView mFactTextView; // Note: m prefix for fields is according to Android Style Guidelines
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Points to the layout xml file
        setContentView(R.layout.activity_awesome_facts);

        // Assign the views from the layout file to corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView); // Auto gen. R class contains resources id's
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        // Default View (ex: colors, facts)
        mFactTextView.setText(mFactBook.getFact());

        // Button Click - Press
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();
                int color = mColorWheel.getColor();

                // Button Tapped/Clicked
                mFactTextView.setText(fact);
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);

            }
        };
        mShowFactButton.setOnClickListener(listener);

        
        // Toast Notifications
        Toast.makeText(AwesomeFactsActivity.this, "Welcome to Fun Facts App!", Toast.LENGTH_SHORT).show();

    }
}
