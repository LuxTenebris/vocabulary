package com.example.vocabulary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class WordAdapter extends ArrayAdapter {

    private List data;
    private Context context;

    public WordAdapter(@NonNull Context context, List data) {
        super(context, R.layout.word);
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        // возвращаем количество элементов списка
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Word word = (Word) data.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.word, parent, false);

        ((TextView) view.findViewById(R.id.english_word)).setText(word.getEnglish());

        ((TextView) view.findViewById(R.id.russian_word)).setText(word.getRussian());

        return view;
    }
}
