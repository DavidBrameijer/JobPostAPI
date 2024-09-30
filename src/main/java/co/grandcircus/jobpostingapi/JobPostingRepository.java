package co.grandcircus.jobpostingapi;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;



public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByTitleContains(String title);
    List<JobPosting> findByApplied(Boolean applied);
    List<JobPosting> findByDateAppliedGreaterThanEqual(LocalDate dateApplied);
    List<JobPosting> findByCompanyNameContains(Company company);
}
