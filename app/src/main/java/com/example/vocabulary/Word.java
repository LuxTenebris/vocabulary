package com.example.vocabulary;

public class Word {
    private String english;
    private String russian;

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
}