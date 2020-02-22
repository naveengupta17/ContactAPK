package method;

import defination.LinkesList;
import type.Person;

import java.util.ArrayList;

public class SearchMethod {
    Person person = new Person();

    public void search(String fname,ArrayList<Person> arrayList) {
        int counter = 0;
        for (Person person : arrayList) {

            if (person.getFirstName().equals(fname)) {
                counter++;
            }
        }
        System.out.println(counter + " match found!");
        for (Person person : arrayList) {
            if (person.getFirstName().equals(fname))
                System.out.println(person);
        }
    }
    }

