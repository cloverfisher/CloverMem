package com.shiguang1q84.clovermemory;

import androidx.fragment.app.Fragment;

import com.shiguang1q84.clovermemory.view.MemViewAdapter;

public abstract class MemFragment extends Fragment {
    private boolean isContentVisable = true;

    public boolean isContentVisable() {
        return isContentVisable;
    }

    public void setContentVisable(boolean contentVisable) {
        isContentVisable = contentVisable;
    }




    protected abstract MemViewAdapter getMyAdapter();


}
