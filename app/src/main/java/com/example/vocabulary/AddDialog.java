package com.example.vocabulary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddDialog extends DialogFragment implements View.OnClickListener {
    EditText english;
    EditText russian;
    @NonNull
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_dialog, null);


        view.findViewById(R.id.add_word).setOnClickListener(this);
        view.findViewById(R.id.cansel_adding).setOnClickListener(this);
        english = view.findViewById(R.id.add_english_word);
        russian = view.findViewById(R.id.add_translate);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.add_word:
                String st_english = english.getText().toString();
                String st_russian = russian.getText().toString();

                Toast.makeText(getContext(),st_english + st_russian,Toast.LENGTH_SHORT).show();
                break;

            case R.id.cansel_adding:
                getDialog().cancel();
                break;


            default:
                break;
        }

    }
}
