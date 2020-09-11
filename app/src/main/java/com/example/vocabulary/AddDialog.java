package com.example.vocabulary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddDialog extends DialogFragment implements View.OnClickListener {
    @NonNull
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_dialog, null);

        view.findViewById(R.id.add_word).setOnClickListener(this);
        view.findViewById(R.id.cansel_adding).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.add_word:
                Toast.makeText(getContext(),"ok",Toast.LENGTH_SHORT).show();
                break;

            case R.id.cansel_adding:
                getDialog().cancel();
                break;


            default:
                break;
        }

    }
}
