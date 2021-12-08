package WebService;

import WebServiceExceptions.WebServiceNotFoundException;
import org.springframework.stereotype.Service;
import persistence.domain.WebService;
import persistence.repo.WebServiceRepo;

import java.util.List;

@Service
public class WebServiceService {

    private final WebServiceRepo webServiceRepo;

    public WebServiceService(WebServiceRepo webServiceRepo) {
        this.webServiceRepo = webServiceRepo;
    }

    public List<WebService> getAllServices() {return webServiceRepo.findAll();}

    public WebService addNewWebService(WebService service){
        // TODO: handle constraints
        return webServiceRepo.save(service);
    }

    public WebService updateWebService(WebService newService, Integer id) {
        WebService toUpdate = findServiceByID(Long.valueOf(id));
        toUpdate.setStatus(newService.getStatus());
        toUpdate.setSiteName(newService.getSiteName());
        toUpdate.setUrl(newService.getUrl());

        return webServiceRepo.save(toUpdate);
    }

    public boolean deleteService(Integer id){
        try {webServiceRepo.deleteById(Long.valueOf(id));}
        catch (Exception e){return false;}
        return true;
    }

    public WebService findServiceByID(Long id) {
        return webServiceRepo.findById( id).orElseThrow(WebServiceNotFoundException::new);
    }

    public Integer getStatus(Long id) {
        return webServiceRepo.findById(id).orElseThrow(WebServiceNotFoundException::new).getStatus();
    }


}

