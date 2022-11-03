package com.example.android.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
private TextView mDisplayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        mDisplayText = (TextView) findViewById(R.id.display_item);
//the getIntent method will give us the Intent
        Intent intentThatstartedThisActivity = getIntent();

        /*
        Although there is always an Intent that starts any particulars Activity, we can't
        guarantee that the extra we are looking for was passed as well. Because of that,
        we need to check to see if the intent has the extra that we specified when we created
        the intent that we use to start this activity.
         */
        if(intentThatstartedThisActivity.hasExtra(Intent.EXTRA_TEXT))
        {
            /*
            Now that we've checked to make sure the extra we are looking for is contained within
            the Intent, we can extract the extra.
             */

            String textEntered = intentThatstartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);

 /*
 finally, we can set the text of our TextView(using setText) to the text that was
 passed to this Activity
  */
            mDisplayText.setText(textEntered);
        }

    }
}