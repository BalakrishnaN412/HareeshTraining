package com.toko.dates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWordsAndCharecters {
    public static void main(String[] args) {
        new FindWordsAndCharecters().m1("balakrishna");
        System.out.println("----------");
        new FindWordsAndCharecters().m2("bala krishna is a good boy bala krishna is a not bad boy Bala");

    }


    public void m1(String text){
        Character[] du=new Character[text.length()];
        for(int i=0;i<text.length();i++){
            du[i]=text.charAt(i);
        }

        List<Character> n=Arrays.asList(du);
        Set<Character> uniqueWord = new HashSet<Character>(n);
        for (Character word : uniqueWord) {
            System.out.println(word + ": " + Collections.frequency(n, word));
        }
    }


    public void m2(String text){
        List<String> list = Arrays.asList(text.split(" "));

        Set<String> uniqueWords = new HashSet<String>(list);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(list, word));
        }

    }
}
