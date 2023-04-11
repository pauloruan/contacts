package com.pauloruan.contacts;

import java.time.LocalDate;

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
import com.pauloruan.contacts.model.dto.PersonDTO;
import com.pauloruan.contacts.service.PersonService;

@WebMvcTest(PersonService.class)
public class PersonServiceTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    private PersonService personService;

    PersonDTO personDTO = new PersonDTO();

    @Test
    public void testCreatePerson_Success() throws Exception {
        personDTO.setName("Sandoval");
        personDTO.setBirthDate(LocalDate.of(1990, 10, 10));

        Mockito.when(personService.createPerson(personDTO)).thenReturn(personDTO);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/api/v1/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(personDTO));

        mockMvc.perform(mockRequest)
                .andExpect(result -> Status.SUCCESSFUL.equals(result.getResponse().getStatus()));
    }

    @Test
    public void testCreatePerson_Fail() throws Exception {
        personDTO.setName("Sandoval");

        Mockito.when(personService.createPerson(personDTO)).thenReturn(personDTO);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/api/v1/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(personDTO));

        mockMvc.perform(mockRequest)
                .andExpect(result -> Status.FAILED.equals(result.getResponse().getStatus()));
    }
}
