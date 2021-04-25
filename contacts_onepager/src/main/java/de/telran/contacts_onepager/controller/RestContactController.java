package de.telran.contacts_onepager.controller;

import de.telran.contacts_onepager.dto.ContactDto;
import de.telran.contacts_onepager.entity.Contact;
import de.telran.contacts_onepager.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/contacts")
@RestController
public class RestContactController {

    private final ContactService contactService;

    public RestContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactDto> getAll() {
        // returns data in the following format: [{"name": "Vasya", ...}, {...}, ...]
        List<Contact> contacts = contactService.getAll();
        return contacts.stream()
                .map(contact -> new ContactDto(contact.getId(),
                        contact.getName(),
                        contact.getName(),
                        contact.getAge()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
   public ContactDto get(@PathVariable int id) {
        Contact contact = contactService.get(id);
        return new ContactDto(contact.getId(), contact.getName(), contact.getLastName(), contact.getAge());
    }

    @PostMapping
    public ContactDto create(@RequestBody ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.name);
        contact.setLastName(contactDto.lastName);
        contact.setAge(contactDto.age);

        contactService.save(contact);
        // after saving the contact has got its id
        contactDto.id = contact.getId();
        return contactDto;
    }

    @PutMapping
    public void edit(@RequestBody ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setId(contactDto.id);
        contact.setName(contactDto.name);
        contact.setLastName(contactDto.lastName);
        contact.setAge(contactDto.age);

        contactService.save(contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        contactService.remove(id);
    }
}
