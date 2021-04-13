package Training.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Training.Student;

public interface TrainingRepository extends CrudRepository<Student, Long> {

	List<Student> findByNameContaining(String keyword);


}
