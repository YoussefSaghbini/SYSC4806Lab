package Lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpMethodConstraint;
import java.util.Collection;
import java.util.List;


@Controller
public class ControllerAddressBook {

    @Autowired
    RepositoryAddressBook repositoryAddressBook;

    @GetMapping(path = "/greeting")
    public String all(Model model) {
        model.addAttribute("AddressBook", repositoryAddressBook.findAll());
        model.addAttribute("buddy", new BuddyInfo());
        return "greeting";
    }

    @GetMapping(path = "/size")
    @ResponseBody
    public Collection<AddressBook> allAddressbook() {
        return repositoryAddressBook.findAll();
    }

    @ResponseBody
    @PostMapping("/add-addressbook")
    @ResponseStatus(HttpStatus.CREATED)
    public String addAddressbook(){
        AddressBook addressBook = new AddressBook();
        repositoryAddressBook.save(addressBook);
        return "Address Book has been created!";
    }


    @ResponseBody
    @PostMapping(value = "/buddyadd", produces = "application/json")
    public String buddyAdd(@ModelAttribute BuddyInfo buddy, Model model){
        AddressBook addressBook  = repositoryAddressBook.findById(buddy.getAddressID());
        model.addAttribute("buddy", buddy);
        System.out.println(buddy);
        addressBook.addBuddy(new BuddyInfo(buddy.getAddressID(), buddy.getName(), buddy.getPhoneNumber()));
        repositoryAddressBook.save(addressBook);
        return "Buddy has been added!";
    }

    @PostMapping(path = "/buddyadd-ajax", consumes = "application/json")
    @ResponseBody
    public ResponseEntity addNewBuddy(@RequestBody BuddyInfo buddy) {
        AddressBook addressBook  = repositoryAddressBook.findById(buddy.getAddressID());
        addressBook.addBuddy(new BuddyInfo(buddy.getAddressID(), buddy.getName(), buddy.getPhoneNumber()));
        repositoryAddressBook.save(addressBook);
        return ResponseEntity.ok(addressBook);
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
