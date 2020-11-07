package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class phrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<words> word = new ArrayList<words>();

        word.add(new words("Where are you going?", "minto wuksus"));
        word.add(new words("What is your name?", "tinnә oyaase'nә"));
        word.add(new words("My name is...", "oyaaset..."));
        word.add(new words("How are you feeling?", "michәksәs?"));
        word.add(new words("I’m feeling good.", "kuchi achit"));
        word.add(new words("Are you coming?", "әәnәs'aa?"));
        word.add(new words("Yes, I’m coming.", "hәә’ әәnәm"));
        word.add(new words("I’m coming.", "әәnәm"));
        word.add(new words("Let’s go.", "yoowutis"));
        word.add(new words("Come here.", "әnni'nem"));


        wordAdapter adapter = new wordAdapter(this, word, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.phrasesList);

        listView.setAdapter(adapter);
    }
}