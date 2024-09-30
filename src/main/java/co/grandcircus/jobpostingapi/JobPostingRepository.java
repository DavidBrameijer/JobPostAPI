package co.grandcircus.jobpostingapi;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;



public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByTitle(String title);
    List<JobPosting> findByApplied(Optional<Boolean> applied);
    List<JobPosting> findByDateApplied(LocalDate dateApplied);
    List<JobPosting> findByCompany(Company company);
}
