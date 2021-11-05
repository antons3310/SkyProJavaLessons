package ru.ashebalkin.skypro.lesson8;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private static final List instances = new ArrayList();
    private static int numberOfAuthors = 0;
    private final String firstName;
    private final String lastName;

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        instances.add(this);
        numberOfAuthors = Author.numberOfAuthors + 1;
    }

    public static List getInstances() {
        return instances;
    }

    public static int getNumberOfAuthors(){
        return numberOfAuthors;
    }

    public String getFirstName (){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
