package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class colorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mOnCompleteListenernew = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    } ;
    private MediaPlayer.OnCompletionListener mOnCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

            releaseMediaPlayer();

        }
    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);


        final ArrayList<words> word = new ArrayList<words>();
        word.add(new words("red", "weṭeṭṭi", R.drawable.color_red,R.raw.color_red));
        word.add(new words("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        word.add(new words("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        word.add(new words("green", "chokokki", R.drawable.color_green,R.raw.color_green));
        word.add(new words("brown", "ṭakaakki", R.drawable.color_brown,R.raw.color_brown));
        word.add(new words("gray", "ṭopoppi", R.drawable.color_gray,R.raw.color_gray));
        word.add(new words("black", "kululli", R.drawable.color_black,R.raw.color_black));
        word.add(new words("white", "kelelli", R.drawable.color_white,R.raw.color_white));



        wordAdapter adapter = new wordAdapter(this,word,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.colorList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                words currentWord = word.get(i);
                mMediaPlayer = MediaPlayer.create(colorsActivity.this,currentWord.getAudioResId());

                releaseMediaPlayer();

                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mOnCompleteListener);
            }
        });


    }

    private void releaseMediaPlayer()
    {
        if(mMediaPlayer != null )
        {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}