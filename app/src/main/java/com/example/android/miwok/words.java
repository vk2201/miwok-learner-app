package com.example.android.miwok;

public class words {

    private String mdefault , mMiwok;
    private int mImageResId=-1;
    private static final int initialId=-1;
    private int mAudioResId;

    public words(String eng,String miwok,int audioResId)
    {

        mdefault=eng;
        mMiwok=miwok;
        mAudioResId=audioResId;
    }
    public words(String  eng,String miwok, int imageId,int audioResId)
    {
        mdefault=eng;
        mMiwok=miwok;
        mImageResId=imageId;
        mAudioResId=audioResId;
    }



    public String getMdefault() {
        return mdefault;
    }

    public String getmMiwok() { return mMiwok; }

    public int getImageResId()
    {
        return mImageResId;
    }

    public boolean hasImage()
    {
        return mImageResId!=initialId;
    }

    public int getAudioResId() { return mAudioResId; }

}
