package com.loresky.zoom.test.fragment;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2015/3/2.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime()
    {
        mId = UUID.randomUUID();
    }
    public UUID getId()
    {
        return mId;
    }
    public String getTitle()
    {
        return mTitle;
    }
    public void setTitle(String mTitle)
    {
        this.mTitle = mTitle;
    }
    public Date getmDate()
    {
        return mDate;
    }
    public void setmDate(Date mDate)
    {
        this.mDate = mDate;
    }
    public boolean ismSolved()
    {
        return mSolved;
    }
    public void setmSolved(boolean mSolved)
    {
        this.mSolved = mSolved;
    }
}
