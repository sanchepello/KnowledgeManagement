package com.example.knowledgemanagement;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.fragment.app.DialogFragment;

public class AboutWindow extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final FrameLayout frameView = new FrameLayout(getActivity());
        builder.setView(frameView);

        final AlertDialog alertDialog = builder.create();
        LayoutInflater inflater = alertDialog.getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.about, frameView);
        alertDialog.show();
        return alertDialog;
    }
}
