
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView numberView = (TextView) findViewById(R.id.numbers);

        numberView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        TextView colorsView = (TextView) findViewById(R.id.colors);

        colorsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent (MainActivity.this,colorsActivity.class);
                startActivity(colorsIntent);
            }
        });


        TextView phrasesView = (TextView) findViewById(R.id.phrases);

        phrasesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent (MainActivity.this,phrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });

        TextView familyView = (TextView) findViewById(R.id.family);

        familyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this,familyActivity.class);
                startActivity(familyIntent);
            }

        });

    }
}
