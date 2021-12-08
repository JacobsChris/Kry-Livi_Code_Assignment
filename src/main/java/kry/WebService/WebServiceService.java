package kry.WebService;

import kry.WebServiceExceptions.WebServiceNotFoundException;
import kry.persistence.domain.WebService;
import kry.persistence.repo.WebServiceRepo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class WebServiceService {

    private final WebServiceRepo webServiceRepo;

    public WebServiceService(WebServiceRepo webServiceRepo) {
        this.webServiceRepo = webServiceRepo;
    }

    public List<WebService> getAllServices() {
        List<WebService> allServices = webServiceRepo.findAll();
        for (WebService service : allServices) {
            // poll each service
            checkStatusOfWebService(service);
        }

        return webServiceRepo.findAll();
    }

    private void checkStatusOfWebService(WebService service) {
        HttpURLConnection con = null;
        try {
            URL url = new URL(service.getUrl());
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            service.setStatus(status);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.disconnect();
        }
    }

    public WebService addNewWebService(WebService service) {
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

