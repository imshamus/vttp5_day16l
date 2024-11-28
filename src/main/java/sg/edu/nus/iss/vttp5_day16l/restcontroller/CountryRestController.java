package sg.edu.nus.iss.vttp5_day16l.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.vttp5_day16l.service.CountryRestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/countires")
public class CountryRestController {
    
    @Autowired
    CountryRestService countryRestService;

    @GetMapping()
    public ResponseEntity<String> getCountires()
    {
        List<Country>countries
        return ResponseEntity.o
    }
}
