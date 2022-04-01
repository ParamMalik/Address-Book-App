package com.address.book.addressbookapi.externalservice;

import com.address.book.addressbookapi.dto.ContactDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@PropertySource(value = "classpath:application.properties")
public class ExternalAddressBookService {

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private RestTemplate restTemplate;

    private static final String URI = "http://10.50.2.211:8099/";

    // Search
    public ContactDTO[] getAddressList() throws JsonProcessingException {
        String addressList = restTemplate.getForObject(URI + "search", String.class);
        return objectMapper.readValue(addressList, ContactDTO[].class);
    }

    // Update
    public void deleteAddress(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        restTemplate.exchange(URI + id, HttpMethod.PUT, entity, String.class);
    }

    // Find By First Name
    public ContactDTO[] getAddressListByFirstName(String firstName) throws JsonProcessingException {

        String addressString = restTemplate.getForObject(URI + firstName, String.class);
        return objectMapper.readValue(addressString, ContactDTO[].class);

    }

    // Save
    public ContactDTO saveAddress(ContactDTO contact) {


        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = null;

        ContactDTO contactDTO = null;
        try {
            jsonString = objectMapper.writeValueAsString(contact);
            HttpEntity<String> stringHttpEntity = new HttpEntity<>(jsonString, httpHeaders);
            String responseEntity = restTemplate.postForObject(URI + "save", stringHttpEntity, String.class);
            contactDTO = objectMapper.readValue(responseEntity, ContactDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return contactDTO;
    }

}
