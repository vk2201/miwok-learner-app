package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class colorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mOnCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    } ;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {

            if( i== AUDIOFOCUS_LOSS_TRANSIENT|| i == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK )
            {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if( i == AUDIOFOCUS_GAIN )
            {
                mMediaPlayer.start();
            }
            else if( i == AUDIOFOCUS_LOSS )
            {
                releaseMediaPlayer();

            }

        }
    };

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

                releaseMediaPlayer();

                mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

                int res = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    mMediaPlayer = MediaPlayer.create(colorsActivity.this,currentWord.getAudioResId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mOnCompleteListener);
                }
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(mMediaPlayer != null )
        {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener );
        }
    }
}