package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mOnCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

            releaseMediaPlayer();

        }
    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<words> word=new ArrayList<words>();

        word.add(new words("one", "lutti", R.drawable.number_one,R.raw.number_one));
        word.add(new words("two", "otiiko", R.drawable.number_two,R.raw.number_two));
        word.add(new words("three", "tolookosu", R.drawable.number_three,R.raw.number_three));
        word.add(new words("four", "oyyisa", R.drawable.number_four,R.raw.number_four));
        word.add(new words("five", "massokka", R.drawable.number_five,R.raw.number_five));
        word.add(new words("six", "temmokka", R.drawable.number_six,R.raw.number_six));
        word.add(new words("seven", "kenekaku", R.drawable.number_seven,R.raw.number_seven));
        word.add(new words("eight", "kawinta", R.drawable.number_eight,R.raw.number_eight));
        word.add(new words("nine", "wo’e", R.drawable.number_nine,R.raw.number_nine));
        word.add(new words("ten", "na’aacha", R.drawable.number_ten,R.raw.number_ten));

        wordAdapter adapter = new wordAdapter(this,word,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.numberList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                words currentWord = word.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,currentWord.getAudioResId());
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