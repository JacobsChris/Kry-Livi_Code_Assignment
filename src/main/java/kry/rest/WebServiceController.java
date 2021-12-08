package kry.rest;

import kry.WebService.WebServiceService;
import kry.persistence.domain.WebService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class WebServiceController {

    private final WebServiceService webServiceService;

    public WebServiceController(WebServiceService webServiceService) {
        this.webServiceService = webServiceService;
    }

    @GetMapping("/getAlL")
    public List<WebService> getAllServices() { return webServiceService.getAllServices();}

    @PostMapping("/create")
    public WebService addNewService(@RequestBody WebService service) {
        return webServiceService.addNewWebService(service);
    }

    @PutMapping("/update/{serviceID}")
    public WebService updateService(@RequestBody WebService service, @PathVariable int serviceID) {
        return webServiceService.updateWebService(service, serviceID);
    }

    @GetMapping("/getStatus/{id}")
    public Integer getStatus(@PathVariable long id){
        return webServiceService.getStatus(id);

    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteService(@PathVariable Integer id) {return webServiceService.deleteService(id);}
}
