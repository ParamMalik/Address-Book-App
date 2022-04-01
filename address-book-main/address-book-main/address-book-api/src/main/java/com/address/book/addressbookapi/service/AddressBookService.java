package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.dto.ContactDTO;
import com.address.book.addressbookapi.entity.ContactEntity;
import com.address.book.addressbookapi.mapper.DtoAndEntityMapper;
import com.address.book.addressbookapi.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {

    @Autowired
    private ContactRepository contactRepository;

    // Save New Address
    public ContactDTO saveAddress(ContactDTO contactDTO) {
        ContactEntity save = contactRepository.save(DtoAndEntityMapper.MAPPER.dtoToEntity(contactDTO));
        return DtoAndEntityMapper.MAPPER.entityToDto(save);
    }


    // Get All Address
    public List<ContactDTO> getListofAddress() {

        return DtoAndEntityMapper.MAPPER.contactEntityListToDto(contactRepository.findAll());

    }

    // Get Address By firstName
    public List<ContactDTO> findAddressByFirstName(String firstName) {

        return DtoAndEntityMapper.MAPPER.contactEntityListToDto(contactRepository.findByFirstName(firstName));


    }

    // Delete Address By changing the status
    public void deleteContact(Long customerId) {
        ContactEntity byContactId = contactRepository.findByContactId(customerId);
        byContactId.setIsActive("N");
        contactRepository.save(byContactId);

    }

}
