package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
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

public class phrasesActivity extends AppCompatActivity {

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

                releaseMediaPlayer();

                mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

                int res = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    mMediaPlayer = MediaPlayer.create(phrasesActivity.this,currword.getAudioResId());
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