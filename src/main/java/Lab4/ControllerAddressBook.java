package Lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpMethodConstraint;


@Controller
public class ControllerAddressBook {

    @Autowired
    RepositoryAddressBook repositoryAddressBook;

    @GetMapping(path = "/greeting")
    public String all(Model model) {
        model.addAttribute("AddressBook", repositoryAddressBook.findAll());
        return "greeting";
    }

    @ResponseBody
    @PostMapping("/add-addressbook")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addAddressbook(){
        AddressBook addressBook = new AddressBook();
        repositoryAddressBook.save(addressBook);
        return ResponseEntity.ok(addressBook);
    }

    @ResponseBody
    @PostMapping(value = "/buddyadd", produces = "application/json")
    public AddressBook buddyAdd(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name, @RequestParam(name = "phoneNumber") String phoneNumber){
        System.out.println("Adding Buddy...");
        AddressBook addressBook = repositoryAddressBook.findById(id);
        addressBook.addBuddy(new BuddyInfo(name, phoneNumber));
        return repositoryAddressBook.save(addressBook);
    }

    @ResponseBody
    @DeleteMapping(value = "/removebuddy", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity removeBuddy(@RequestParam(name = "id") final int id, @RequestParam(name = "i") int i ){
        System.out.println("Removing Buddy...");
        AddressBook addressBook = repositoryAddressBook.findById(id);
        addressBook.removeBuddy(i);
        repositoryAddressBook.save(addressBook);
        return ResponseEntity.ok(addressBook);
    }
}
