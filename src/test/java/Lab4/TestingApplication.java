package Lab4;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestingApplication {

    @Autowired
    private MockMvc mockMvc;

    final TestRestTemplate restTemplate = new TestRestTemplate();
    
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

    @Test
    public void addBuddyInfoTest() throws Exception
    {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Test", "Number");
        addressBook.addBuddy(buddy);
        mockMvc.perform(
                post("/buddyadd/{id}/{name}/{phoneNumber}", "1", "Test", "Number")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void removeBuddyTest() throws Exception
    {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Test", "Number");
        BuddyInfo buddy1 = new BuddyInfo("Test1", "Number1");
        addressBook.addBuddy(buddy);
        addressBook.addBuddy(buddy1);
        mockMvc.perform(
                post("/removebuddy/{id}/{i}", "1", "1")
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
