package Lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ControllerAddressBook {

    @Autowired
    RepositoryAddressBook repositoryAddressBook;

    @GetMapping(path = "/greeting")
    public String all(Model model) {
        String all = "";
        for(AddressBook addressBook : repositoryAddressBook.findAll())
            all += "<br>\nAddressBook ID: " + addressBook.id + " \nBuddy Info: " + addressBook.toString() + "\n<br>";
        model.addAttribute("AddressBook", all);
        return "greeting";
    }

    @ResponseBody
    @PostMapping("/add-addressbook")
    public ResponseEntity addAddressbook(){
        AddressBook addressBook = new AddressBook();
        repositoryAddressBook.save(addressBook);
        return ResponseEntity.ok(addressBook);
    }

    @ResponseBody
    @PostMapping(value = "/buddyadd/{id}/{name}/{phoneNumber}", consumes = "application/json", produces = "application/json")
    public AddressBook buddyAdd(@PathVariable int id, @PathVariable String name, @PathVariable String phoneNumber){
        System.out.println("Adding Buddy...");
        AddressBook addressBook = repositoryAddressBook.findById(id);
        addressBook.addBuddy(new BuddyInfo(name, phoneNumber));
        return repositoryAddressBook.save(addressBook);
    }

    @ResponseBody
    @DeleteMapping(value = "/removebuddy/{id}/{i}", consumes = "application/json", produces = "application/json")
    public ResponseEntity removeBuddy(@PathVariable final int id, @RequestParam int i ){
        System.out.println("Removing Buddy...");
        AddressBook addressBook = repositoryAddressBook.findById(id);
        addressBook.removeBuddy(i);
        repositoryAddressBook.save(addressBook);
        return ResponseEntity.ok(addressBook);
    }
}