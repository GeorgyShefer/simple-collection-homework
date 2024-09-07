package com.company;

import java.awt.font.FontRenderContext;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookApp {
    PhoneBook phoneBook = new PhoneBook();

    public void init() {
        while (true) {
            System.out.println(Constant.ENTER_VALUE);
            String input = new Scanner(System.in).next();
            if (input.equals(Constant.LIST)) {
               /* for (String listContact : phoneBook.getAllContacts()) {
                    String contactByPhone = phoneBook.getContactByPhone(listContact);
                    System.out.println(contactByPhone + " - " + phoneBook.getContactByName(contactByPhone));
                }*/
                System.out.println(phoneBook.getAllContacts());
            } else if (phoneBook.isValidName(input)) {
                    if (phoneBook.getContactByName(input).isEmpty()) {
                        System.out.println(Constant.NOT_NAME);
                        System.out.println(Constant.INPUT_NUMBER + input);
                        String phoneNumber = new Scanner(System.in).next();
                        if (phoneBook.isValidPhone(phoneNumber)) {
                            phoneBook.addContact(input, phoneNumber);
                            System.out.println(Constant.SAVE_CONTACT);
                        }
                    }
                }
            else if(phoneBook.isValidPhone(input)) {
                    if (phoneBook.getContactByPhone(input).isEmpty()) {
                        System.out.println(Constant.NOT_NUMBER);
                        System.out.println(Constant.INPUT_NAME + input);
                        String inputName = new Scanner(System.in).next();
                        if (phoneBook.isValidName(inputName)) {
                            phoneBook.addContact(inputName, input);
                            System.out.println(Constant.SAVE_CONTACT);
                        }
                    }
                } else {
                    System.out.println(Constant.WRONG_INPUT);
                }
            }
        }
    }


