package type;

import defination.LinkesList;

import java.nio.file.LinkOption;
import java.util.ArrayList;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    ArrayList<Long> numberList = new ArrayList<>();

    public Person(){}
    public Person(String firstName, String lastName, String email, ArrayList<Long> numberList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.numberList = numberList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Long> getNumberList() {
        return numberList;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumberList(ArrayList<Long> numberList) {
        this.numberList = numberList;
    }
    private StringBuilder printContact(){
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        for(long i : numberList){
            stringBuilder.append(i);
            k++;
            stringBuilder.append((k<numberList.size())?",":"");

        }
        return stringBuilder;
    }
    @Override
    public String toString() {
        return "-------- * -------- * -------- * --------"+"\n"+
                "First Name: "+ firstName+"\n"+
                "Last Name: "+ lastName+"\n"+
                (numberList.size() ==1 ?"Contact Number: ":"Contact Number(s): ") +printContact()+"\n"+
                "Email address: "+ email+"\n"+
                "-------- * -------- * -------- * --------"+"\n";
    }
}
