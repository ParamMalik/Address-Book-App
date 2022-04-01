package com.address.book.addressbookapi.controller;

import com.address.book.addressbookapi.dto.ContactDTO;
import com.address.book.addressbookapi.externalservice.ExternalAddressBookService;
import com.address.book.addressbookapi.service.AddressBookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @Autowired
    private ExternalAddressBookService externalAddressBookService;

    @GetMapping("/search/flag")

    public List<ContactDTO> getAllAddressBook(@RequestParam String flag) throws JsonProcessingException {
        if (flag.equals("y")) {
            return List.of(externalAddressBookService.getAddressList());
        } else {
            return addressBookService.getListofAddress();
        }
    }

    @GetMapping("/search/{firstName}/flag")
    public List<ContactDTO> getAddressByFirstName(@PathVariable String firstName, @RequestParam String flag) throws JsonProcessingException {
        if (flag.equals("y")) {
            return List.of(externalAddressBookService.getAddressListByFirstName(firstName));
        } else {
            return addressBookService.findAddressByFirstName(firstName);
        }


    }

    @PostMapping(path = "/save/flag")
    public ContactDTO saveAddress(@RequestBody ContactDTO contactDTO, @RequestParam String flag) {
        if (flag.equals("y")) {
            return externalAddressBookService.saveAddress(contactDTO);
        } else {
            return addressBookService.saveAddress(contactDTO);
        }


    }

    @PutMapping(path = "/update/{contactId}/flag")
    public void updateAddressBook(@PathVariable Long contactId, @RequestParam String flag) {
        if (flag.equals("y")) {
            externalAddressBookService.deleteAddress(contactId);
        } else {
            addressBookService.deleteContact(contactId);
        }


    }

    @PostMapping(path = "/external")
    public ContactDTO getExternal(@RequestBody ContactDTO dto) {
        return externalAddressBookService.saveAddress(dto);
    }

    @GetMapping(path = "/external")
    public ContactDTO[] getExternalAddress() {
        ContactDTO[] addressList = null;
        try {
            addressList = externalAddressBookService.getAddressList();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return addressList;
    }

    @PutMapping(path = "/external/{id}")
    public void deleteExternalContact(@PathVariable Long id) {
        externalAddressBookService.deleteAddress(id);

    }


}
