package ru.tsurkanenko.vladimir.hscodes.database.generic;



public class ScopeDemo{
    public static void main(String[] args) {
        ScopeGroups scopeGroups = new ScopeGroups("dic/TNVED1.TXT");
        Groups[] section = scopeGroups.get();
        System.out.println(section[0].toString());
        System.out.println(section[0].getPrim());
        System.out.println(scopeGroups.startsWith("10")[0].toString());

        ScopeItems scopeItems = new ScopeItems("dic/TNVED4.TXT");
        Items[] item = scopeItems.get();
        System.out.println(item[0].toString());

        System.out.println(scopeItems.startsWith("10")[0].toString());
        System.out.println(scopeItems.startsWith("10")[0].getNestlingLevel());
        System.out.println(scopeGroups.get()[0].compareTo(section[0]));
    }

}
