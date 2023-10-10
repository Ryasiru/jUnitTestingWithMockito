package com.ceyentra.junitWithMockito.controller;

import com.ceyentra.junitWithMockito.controller.StudentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTesting {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void studentAdd_basic() throws Exception{

        MockHttpServletRequestBuilder accept = MockMvcRequestBuilders.post("").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(accept).andReturn();

        JSONAssert.assertEquals("{student_id:1,student_name:'Yasiru',student_address: 'Panadura',student_contact: '0710821117'}",mvcResult.getResponse().getContentAsString(),true);


    }
}
