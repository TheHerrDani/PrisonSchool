
package prisonSchool.interfaces;

import prisonSchool.repository.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositoryInterface extends CrudRepository<Student, Integer> {

}