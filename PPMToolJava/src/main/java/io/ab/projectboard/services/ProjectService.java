package io.ab.projectboard.services;

import io.ab.projectboard.domain.Project;
import io.ab.projectboard.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired

    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        //Logic
        return projectRepository.save(project);
    }

}
