package sg.edu.nus.iss.vttp5_day16l.service;

import java.io.StringReader;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import sg.edu.nus.iss.vttp5_day16l.constant.Url;
import sg.edu.nus.iss.vttp5_day16l.model.Country;

@Service
public class CountryRestService {
    
    RestTemplate restTemplate = new RestTemplate(); // use resttemplate to call the API to retrieve smth smth

    public List<Country> getCountries()
    {
        String countryData = restTemplate.getForObject(Url.countryUrl, String.class); // we expect a string back?
        // System.out.println(countryData); // show output before we do anything, but where is this sout print at?

        JsonReader jReader = Json.createReader(new StringReader(countryData));
        JsonObject jObject = jReader.readObject();

        JsonObject jDataObject = jObject.getJsonObject("data");

        Set<Entry<String, JsonValue>> entries = jDataObject.entrySet();

        for(Entry<String, JsonValue> entry : entries)
        {
            Country c = new Country();
            c.setCode(entry.getKey());
            c.setName(entry.getValue().asJsonObject().getString("country"));
            
        }




        return null;
    }
}
