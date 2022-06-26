package com.rusen.harfapp.model;

import android.view.View;

public class ViewList {

    private View[] views;

    public ViewList(View[] views){
        this.views = views;
    }

    public ViewList(){

    }


    public View[] getViews() {
        return views;
    }

    public void setViews(View[] views) {
        this.views = views;
    }
}
