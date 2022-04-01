package com.address.book.addressbookapi.mapper;

import com.address.book.addressbookapi.dto.ContactDTO;
import com.address.book.addressbookapi.entity.ContactEntity;
import com.address.book.addressbookapi.entity.MobileEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-01T11:42:48+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
public class DtoAndEntityMapperImpl implements DtoAndEntityMapper {

    @Override
    public ContactDTO entityToDto(ContactEntity contactEntity) {
        if ( contactEntity == null ) {
            return null;
        }

        ContactDTO contactDTO = new ContactDTO();

        contactDTO.setContactId( contactEntity.getContactId() );
        contactDTO.setFirstName( contactEntity.getFirstName() );
        contactDTO.setLastName( contactEntity.getLastName() );
        contactDTO.setEmailAddress( contactEntity.getEmailAddress() );
        contactDTO.setCreatedBy( contactEntity.getCreatedBy() );
        contactDTO.setCreatedDate( contactEntity.getCreatedDate() );
        contactDTO.setUpdatedBy( contactEntity.getUpdatedBy() );
        contactDTO.setUpdatedDate( contactEntity.getUpdatedDate() );
        contactDTO.setIsActive( contactEntity.getIsActive() );
        List<MobileEntity> list = contactEntity.getMobileEntities();
        if ( list != null ) {
            contactDTO.setMobileEntities( new ArrayList<MobileEntity>( list ) );
        }

        return contactDTO;
    }

    @Override
    public ContactEntity dtoToEntity(ContactDTO contactDTO) {
        if ( contactDTO == null ) {
            return null;
        }

        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setContactId( contactDTO.getContactId() );
        contactEntity.setFirstName( contactDTO.getFirstName() );
        contactEntity.setLastName( contactDTO.getLastName() );
        contactEntity.setEmailAddress( contactDTO.getEmailAddress() );
        contactEntity.setCreatedBy( contactDTO.getCreatedBy() );
        contactEntity.setCreatedDate( contactDTO.getCreatedDate() );
        contactEntity.setUpdatedBy( contactDTO.getUpdatedBy() );
        contactEntity.setUpdatedDate( contactDTO.getUpdatedDate() );
        contactEntity.setIsActive( contactDTO.getIsActive() );
        List<MobileEntity> list = contactDTO.getMobileEntities();
        if ( list != null ) {
            contactEntity.setMobileEntities( new ArrayList<MobileEntity>( list ) );
        }

        return contactEntity;
    }

    @Override
    public List<ContactDTO> contactEntityListToDto(List<ContactEntity> contactEntityList) {
        if ( contactEntityList == null ) {
            return null;
        }

        List<ContactDTO> list = new ArrayList<ContactDTO>( contactEntityList.size() );
        for ( ContactEntity contactEntity : contactEntityList ) {
            list.add( entityToDto( contactEntity ) );
        }

        return list;
    }
}
