package com.company;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Alex","89372214545");
        phoneBook.addContact("Alex","89372214542");
        phoneBook.addContact("Alex","89372214548");
        phoneBook.addContact("Alexq","89372214541");

        Set<String> allContacts = phoneBook.getAllContacts();
        System.out.println(allContacts);

    }
}