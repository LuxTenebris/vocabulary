package com.example.vocabulary;

public class Word implements Comparable<Word> {
    private String english;
    private String russian;

    public Word(Object english, Object russian) {
        this.english = (String) english;
        this.russian = (String) russian;
    }

    public void setEnglish(String english_word){
        this.english = english_word;
    }

    public void setRussian(String russian_word){
        this.russian = russian_word;
    }

    public String getEnglish(){
        return this.english;
    }

    public String getRussian(){
        return this.russian;
    }

    @Override
    public int compareTo(Word o) {
        return english.compareTo(o.english);
    }
}
