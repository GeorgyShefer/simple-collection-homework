package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    private Map<String, Set<String>> contactBook = new HashMap<>();

    public void addContact(String name, String phone) {
        // TODO проверь корректность формата имени и телефона
        // TODO (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // TODO если такой номер уже есть в списке, то перезаписать имя абонента
        if(isValidName(name) && isValidPhone(phone)){
            contactBook = contactBook.entrySet().stream()
                    .peek(e -> e.getValue().remove(phone))
                    .filter(e -> !e.getValue().isEmpty())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            contactBook.putIfAbsent(name, new HashSet<>());
            contactBook.get(name).add(phone);
        }
    }
    public boolean isValidName(String name){
        return name.matches("^[а-яА-ЯA-Za-zёЁ]+$");
    }
    public boolean isValidPhone(String phone){
        return phone.matches("\\d{11}");
    }
    //Может быть новое имя и новый телефон x
    //New name and old phone
    //Old name and new phone X
    //Old name and old phone
    public Set<String> getContactByName(String name) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найден - вернуть пустой TreeSet
       /* for (Map.Entry<String,Set<String>> entry : contactBook.entrySet()){
            if(entry.getKey().contains(name)){
                return entry.getValue();
            }
        }*/
        if(!contactBook.containsKey(name)){
            return new TreeSet<>();
        }
       return contactBook.entrySet().stream()
                .filter(e -> e.getKey().contains(name))
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.toSet());
    }

    public String getContactByPhone(String phone) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найдены - вернуть пустую строку
        /*for (Map.Entry<String,Set<String>> entry : contactBook.entrySet()){
            if(entry.getValue().contains(phone)){
                return entry.getKey();
            }
        }*/
       return contactBook.entrySet().stream()
                .filter(e -> e.getValue().contains(phone))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(" ");

    }

    public Set<String> getAllContacts() {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контактов нет в телефонной книге - вернуть пустой TreeSet
        /*for (Map.Entry<String,Set<String>> entry : contactBook.entrySet()){
            return entry.getValue();
        }*/
      return   contactBook.entrySet().stream()
                .filter(e -> !e.getValue().isEmpty())
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.toSet());

    }
}
