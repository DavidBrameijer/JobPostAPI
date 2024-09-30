package co.grandcircus.jobpostingapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>{
    List<Company> findByNameContains(String name);
}
