package com.aop.requestbody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(value = MockitoExtension.class)
@ActiveProfiles("test")
public class RequestControllerUnitTest {

    private static final String PATH = "/request-body";
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @InjectMocks
    private Controller controller;

    @BeforeEach
    void setUp() {
        setUpMockMvc();
        setUpObjectMapper();
    }

    private void setUpObjectMapper() {
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    private void setUpMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(new Controller()).build();
    }

    @Test
    public void controllerTest() throws Exception {
        // given
        RequestDto requestDto = new RequestDto("tom", 15);
        String requestBody = objectMapper.writeValueAsString(requestDto);
        String responseBody = objectMapper.writeValueAsString(requestDto);

        // when
        ResultActions perform = mockMvc.perform(put(PATH + "/used")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));

        // then
        perform.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(responseBody));
    }
}
