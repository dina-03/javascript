package de.telran.contacts_onepager.dto;

public class ContactDto {
    public int id;
    public String name;
    public String lastName;
    public int age;

    public ContactDto(int id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
