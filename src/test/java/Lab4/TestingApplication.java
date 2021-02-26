package Lab4;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestingApplication {

    @Autowired
    private MockMvc mockMvc;

    final TestRestTemplate restTemplate = new TestRestTemplate();

    @BeforeEach
    public void addAddressBookTest() throws Exception {
        mockMvc.perform(post("/add-addressbook")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void addBuddyTest() throws Exception
    {
        mockMvc.perform(
                post("/buddyadd")
                        .param("id", "1")
                        .param("name", "Test")
                        .param("phoneNumber", "Number")
                        .param("addressID", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void removeBuddyTest() throws Exception
    {
        addBuddyTest();

        mockMvc.perform(
                post("/removebuddy")
                        .param("id", "1")
                        .param("i", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
