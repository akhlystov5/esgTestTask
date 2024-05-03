package info.fa.rest.controller;

import info.fa.model.dto.CustomerDto;
import info.fa.rest.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void testSearch() throws Exception {

        given(customerService.search("ref1")).willReturn(new CustomerDto("ref9"
                ,"Gandalf the bearer of bad news","38 High Street"
                ,"Mountain Walk"
                ,"Exeter"
                ,"Devon"
                ,"UK"
                ,"EX4 3LN"));

        mvc.perform(get("/v1/customer/ref1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerRef").value("ref9"))
                .andExpect(jsonPath("$.customerName").value("Gandalf the bearer of bad news"))
                .andExpect(jsonPath("$.addressLine1").value("38 High Street"))
                .andExpect(jsonPath("$.addressLine2").value("Mountain Walk"))
                .andExpect(jsonPath("$.town").value("Exeter"))
                .andExpect(jsonPath("$.county").value("Devon"))
                .andExpect(jsonPath("$.country").value("UK"))
                .andExpect(jsonPath("$.postcode").value("EX4 3LN"));

    }
}