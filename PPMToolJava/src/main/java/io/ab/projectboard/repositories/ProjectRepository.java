package io.ab.projectboard.repositories;

import io.ab.projectboard.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    //@Override
    //Iterable<Project> findAllById(Iterable<Long> iterable);
    Project findByProjectIdentifier(String projectId);



}
