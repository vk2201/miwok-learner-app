package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class familyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<words> word = new ArrayList<words>();

        word.add(new words("father", "әpә", R.drawable.family_father));
        word.add(new words("mother", "әṭa", R.drawable.family_mother));
        word.add(new words("son", "angsi", R.drawable.family_son));
        word.add(new words("daughter", "tune", R.drawable.family_daughter));
        word.add(new words("older brother", "taachi", R.drawable.family_older_brother));
        word.add(new words("younger brother", "chalitti", R.drawable.family_younger_brother));
        word.add(new words("older sister", "teṭe", R.drawable.family_older_sister));
        word.add(new words("younger sister", "kolliti", R.drawable.family_younger_sister));
        word.add(new words("grandmother ", "ama", R.drawable.family_grandmother));
        word.add(new words("grandfather", "paapa", R.drawable.family_grandfather));

        wordAdapter adapter = new wordAdapter(this,word,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.familyList);

        listView.setAdapter(adapter);
    }
}