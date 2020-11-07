package com.example.android.miwok;

public class words {
    private
        String mdefault,mMiwok;
        int mImageResId=-1;
        static final int initialId=-1;

    public words(String eng,String miwok)
    {
        mdefault=eng;
        mMiwok=miwok;
    }
    public words(String eng,String miwok, int imageId)
    {
        mdefault=eng;
        mMiwok=miwok;
        mImageResId=imageId;
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

}
