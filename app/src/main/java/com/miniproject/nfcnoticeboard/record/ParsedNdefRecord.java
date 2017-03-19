package com.miniproject.nfcnoticeboard.record;

/**
 * Created by ACJLionsRoar on 20/03/17.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public interface ParsedNdefRecord {

    /**
     * Returns a view to display this record.
     */
    public View getView(Activity activity, LayoutInflater inflater, ViewGroup parent,
                        int offset);

}