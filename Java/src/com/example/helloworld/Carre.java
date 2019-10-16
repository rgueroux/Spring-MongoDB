package com.example.helloworld;

public class Carre extends FigureGeo {

    private long cote;

    private long getCote() {
        return cote;
    }

    public long getPerimeter() {
        return 4 * cote;
    }
}
