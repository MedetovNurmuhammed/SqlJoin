package dao;

public class Idcounter {
    private static long counter = 0;
    public static long geneteId(){

        return ++counter;
}}
