package main;

import defination.LinkesList;
import method.SearchMethod;
import type.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i =1;
        LinkesList<Person> linkesList = new LinkesList<>();
        SearchMethod searchMethod = new SearchMethod();
        do{
            System.out.println("Welcome to Naveen's Contact App");
            System.out.println("Press 1 to add a new Contact");
            System.out.println("Press 2 to view all contacts");
            System.out.println("Press 3 to search for a contact");
            System.out.println("Press 4 to delete a contact");
            System.out.println("Press 5 to exit the programe");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:{
                    System.out.println("You choose to add a new contact:");
                    System.out.println("Entre  name of the person:");
                    System.out.println("First name:");
                    String fName = scanner.nextLine().trim();
                    System.out.println("Last Name:");
                    String lName = scanner.nextLine().trim();
                    ArrayList<Long> arrayList = new ArrayList<>();
                    String choiceContact;
                    do{
                        System.out.println("Contact Number:");
                        long no = scanner.nextLong();
                        arrayList.add(no);
                        System.out.println("Would you like to add another Contact Number(y/n)");
                        scanner.nextLine();
                        choiceContact = scanner.nextLine();

                    }
                    while (choiceContact.equals("y"));
                    String email = null;
                    System.out.println("Would you like to add Email(y/n)");

                    char choice2 = scanner.nextLine().charAt(0);
                    if( choice2 == 'y'){
                        System.out.println("Email: ");
                        email = scanner.nextLine().trim();
                    }

                    Person person = new Person(fName,lName,email,arrayList);

                    linkesList.add(person);
                    break;

                }

                case 2:
                    linkesList.print();
                    break;
                case 3:{
                    System.out.println("You could search for a contact from their first Name:");
                    String firstName = scanner.nextLine().trim();
                    searchMethod.search(firstName,linkesList.searchForContact1());
                    break;



                }
                case 4: {
                    int k = 1;
                    int limit = 0;
                    for (Person person : linkesList.searchForContact1()) {
                        System.out.println(k + "- " + person.getFirstName() + " " + person.getLastName());
                        k++;

                    }
                    System.out.println("Press the number against contact to delete it:");
                    int choice99 = scanner.nextInt();
                    for (Person person : linkesList.searchForContact1()) {
                        if( limit == choice99-1){
                            System.out.println(person.getFirstName() + " " + person.getLastName() + "'s" + " contact deleted from list ");
                            break;
                        }
                        limit++;
                    }
                    linkesList.removeByIndex(choice99 - 1);
                    break;
                }

                case 5:
                    i = 0;
                    break;
                default:
                    System.out.println("Please choose valid option:");
            }

        }
        while( i == 1);



        }

    }

