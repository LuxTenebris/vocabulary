package com.example.vocabulary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddDialog extends DialogFragment implements View.OnClickListener {
    EditText english;
    EditText russian;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Map<String, Object> note = new HashMap<>();

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
                if(st_english.length() == 0){
                    Toast.makeText(getContext(),"You do not enter an english word",Toast.LENGTH_SHORT).show();
                } else {
                    if(st_russian.length() == 0){
                        Toast.makeText(getContext(),"You do not enter an russian word",Toast.LENGTH_SHORT).show();
                    } else {

                        note.put("english", st_english);
                        note.put("russian", st_russian);
                        db.collection("Words")
                                .add(note)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d("Tag", "DocumentSnapshot added with ID: " + documentReference.getId());
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w("Tag", "Error adding document", e);
                                    }
                                });

                        Toast.makeText(getContext(),"successfully added",Toast.LENGTH_SHORT).show();
                        getDialog().cancel();
                    }
                }
                break;

            case R.id.cansel_adding:
                getDialog().cancel();
                break;


            default:
                break;
        }

    }
}
