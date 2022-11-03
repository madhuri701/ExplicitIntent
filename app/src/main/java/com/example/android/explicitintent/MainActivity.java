package com.example.android.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mEditText;
    private Button doSomethingCoolButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doSomethingCoolButton=(Button) findViewById(R.id.do_something_cool);
        mEditText=(TextView) findViewById(R.id.edit_text_item);

        doSomethingCoolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //we'll first get the text entered by the user in the EditText

                String textEntered=mEditText.getText().toString();
                Context context = MainActivity.this;
                Class destinationActivity = ChildActivity.class;


                Intent startChildActivityIntent = new Intent(context,destinationActivity);

                // we use the putExtra method of the intent class to pass some extra stuff to
                // the activity that we are starting.Generally, this data is quite simple,such as
                // a String or a number.However, there are ways to pass more complex objects.
                startChildActivityIntent.putExtra(Intent.EXTRA_TEXT,textEntered);
                startActivity(startChildActivityIntent);

            }
        });

    }
}