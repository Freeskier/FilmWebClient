package com.client.CustomViews;

import android.content.Context;


public class StarImageView extends androidx.appcompat.widget.AppCompatImageView {
    private int position;
    public StarImageView(Context context, int position) {
        super(context);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
