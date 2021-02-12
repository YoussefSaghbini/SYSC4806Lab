package Lab4;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestingApplication {

    @Autowired
    private MockMvc mockMvc;

    final TestRestTemplate restTemplate = new TestRestTemplate();

//    @Test
//    public void testLocalhostResponse() throws Exception {
//
//        String message = restTemplate.getForObject("http://localhost:" + 8082 + "/", String.class);
//        org.junit.jupiter.api.Assertions.assertNotEquals("This is a test message", message);
//    }
    
    @Test
    public void addAddressBookTest() throws Exception
    {
        AddressBook addressBook = new AddressBook();
        mockMvc.perform(post("/add-addressbook/")
                .content(asJsonString(addressBook))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
