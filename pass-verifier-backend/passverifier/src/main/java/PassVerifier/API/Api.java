package PassVerifier.API;
import PassVerifier.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Api {

    @Autowired
    Service service = new Service();
    @CrossOrigin(origins = "http://localhost:1111")
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public ResponseEntity<Integer> VerifyValidity(@RequestHeader String password){
        return new ResponseEntity<>(service.VerifyValidityPassword(password), HttpStatus.OK);
    }
}
