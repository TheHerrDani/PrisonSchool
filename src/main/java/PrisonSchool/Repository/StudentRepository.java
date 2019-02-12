
package PrisonSchool.Repository;

import PrisonSchool.Repository.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}