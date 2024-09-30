package co.grandcircus.jobpostingapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepo;

    @GetMapping("/Company")
    private List<Company> GetAllCompanies(@RequestParam(required = false) String name){
        if(name != null){
            return companyRepo.findByNameContains(name);
        }
        return this.companyRepo.findAll();
    }

    @GetMapping("/Company/{id}")
    public Company GetById(@PathVariable("id") Long id){
        return this.companyRepo.findById(id).orElse(null);
    }

    @PostMapping("/Company")
    public Company AddCompany(@RequestBody Company newC){
        newC.setId(null);
        this.companyRepo.save(newC);
        return newC;
    }

    @PutMapping("/Company/{id}")
    public Company UpdateCompany(@PathVariable("id") Long id, @RequestBody Company updated){
        companyRepo.save(updated);
        return updated;
    }

    @DeleteMapping("/Company/{id}")
    public void DeleteCompany(@PathVariable("id") Long id){
        companyRepo.deleteById(id);
    }
}
