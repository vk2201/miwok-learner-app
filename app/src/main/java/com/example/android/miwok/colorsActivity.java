package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class colorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);


        ArrayList<words> word = new ArrayList<words>();
        word.add(new words("red", "weṭeṭṭi", R.drawable.color_red));
        word.add(new words("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));
        word.add(new words("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        word.add(new words("green", "chokokki", R.drawable.color_green));
        word.add(new words("brown", "ṭakaakki", R.drawable.color_brown));
        word.add(new words("gray", "ṭopoppi", R.drawable.color_gray));
        word.add(new words("black", "kululli", R.drawable.color_black));
        word.add(new words("white", "kelelli", R.drawable.color_white));



        wordAdapter adapter = new wordAdapter(this,word,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.colorList);
        listView.setAdapter(adapter);

    }
}