package edu.csupomona.cs480;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class asartoonianA6 {

    private final String givenName;
    private final String surname;

    asartoonianA6(String givenName, String surname) {
        this.givenName = givenName;
        this.surname = surname;
    }

    String getDisplayName() {
        return surname + ", " + givenName;
    }

}
