package com.pauloruan.contacts;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult.Status;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pauloruan.contacts.model.dto.AddressDTO;
import com.pauloruan.contacts.service.AddressService;

@WebMvcTest(AddressService.class)
public class AddressServiceTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;


    @MockBean
    private AddressService addressService;

    AddressDTO addressDTO = new AddressDTO();

    @Test
    public void testCreateAddress_Success() throws Exception {
        addressDTO.setCity("Fortaleza");
        addressDTO.setNumber("81");
        addressDTO.setStreet("Rua Dragão do Mar");
        addressDTO.setZipCode("60060390");

        Mockito.when(addressService.createAddress(null, addressDTO)).thenReturn(addressDTO);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/address")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(addressDTO));


        mockMvc.perform(mockRequest)
                .andExpect(result -> Status.SUCCESSFUL.equals(result.getResponse().getStatus()));
    }

    @Test
    public void testCreateAddress_Fail() throws Exception {
        addressDTO.setCity("Fortaleza");

        Mockito.when(addressService.createAddress(null, addressDTO)).thenReturn(addressDTO);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/address")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(addressDTO));

        mockMvc.perform(mockRequest)
                .andExpect(result -> Status.FAILED.equals(result.getResponse().getStatus()));

    }
}
