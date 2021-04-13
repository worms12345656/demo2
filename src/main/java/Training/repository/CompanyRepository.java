package Training.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Training.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

	List<Company> findAllByNameContaining(String keyword);

}
