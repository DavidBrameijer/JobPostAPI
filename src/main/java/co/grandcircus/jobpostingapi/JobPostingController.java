package co.grandcircus.jobpostingapi;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
public class JobPostingController {

    @Autowired
    private JobPostingRepository jobPostingRepo;

    @GetMapping("/")
    public String getDefault(){
        return "Hi";
    }

    @GetMapping("/JobPosting")
    public List<JobPosting> GetAll(@RequestParam(required = false) String title, @RequestParam(required = false) Optional<Boolean> applied, @RequestParam(required = false) LocalDate dateApplied, @RequestParam(required = false) Company company) {
        if(title != null){
            return jobPostingRepo.findByTitle(title);
        }
        if(applied.isPresent()){
            return jobPostingRepo.findByApplied(applied);
        }
        if(dateApplied != null){
            return jobPostingRepo.findByDateApplied(dateApplied);
        }
        if(company != null){
            return jobPostingRepo.findByCompany(company);
        }
        return this.jobPostingRepo.findAll();
    }

    @GetMapping("/JobPosting/{id}")
    public JobPosting GetById(@PathVariable("id") Long id){
        return this.jobPostingRepo.findById(id).orElse(null);
    }
    
    @PostMapping("/JobPosting")
    public JobPosting AddJobPosting(@RequestBody JobPosting newJ){
        newJ.setId(null);
        this.jobPostingRepo.save(newJ);
        return newJ;
    }

    @PutMapping("/JobPosting/{id}")
    public JobPosting UpdateJobPosting(@PathVariable("id") Long id, @RequestBody JobPosting updated){
        jobPostingRepo.save(updated);
        return updated;
    }

    @DeleteMapping("/JobPosting/{id}")
    public void DeleteJobPosting(@PathVariable("id") Long id){
        jobPostingRepo.deleteById(id);
    }
}
