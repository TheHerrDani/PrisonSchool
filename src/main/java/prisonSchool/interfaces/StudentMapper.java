package prisonSchool.interfaces;

import org.mapstruct.Mapper;
import prisonSchool.domains.StudentDomain;
import prisonSchool.entities.StudentEntity;

@Mapper
public interface StudentMapper {
    StudentDomain repositoryToService(StudentEntity source);
    StudentEntity serviceToRepository(StudentDomain destination);
}
