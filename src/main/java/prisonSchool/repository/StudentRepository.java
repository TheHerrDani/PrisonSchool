
package prisonSchool.repository;

import prisonSchool.repository.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}