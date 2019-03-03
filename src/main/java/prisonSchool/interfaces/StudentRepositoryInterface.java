
package prisonSchool.interfaces;

import prisonSchool.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositoryInterface extends CrudRepository<StudentEntity, Integer> {

}