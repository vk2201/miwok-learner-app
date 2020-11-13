package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class phrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

         final ArrayList<words> word = new ArrayList<words>();

        word.add(new words("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        word.add(new words("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        word.add(new words("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        word.add(new words("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        word.add(new words("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        word.add(new words("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        word.add(new words("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        word.add(new words("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        word.add(new words("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        word.add(new words("Come here.", "әnni'nem",R.raw.phrase_come_here));


        wordAdapter adapter = new wordAdapter(this, word, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.phrasesList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                words currword = word.get(i);

                mMediaPlayer =MediaPlayer.create(phrasesActivity.this,currword.getAudioResId());

                mMediaPlayer.start();

            }
        });
    }
}