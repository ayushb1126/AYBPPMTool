package io.ab.projectboard.services;

import io.ab.projectboard.domain.Project;
import io.ab.projectboard.exceptions.ProjectIdException;
import io.ab.projectboard.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired

    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        //Logic
        try{
            return projectRepository.save(project);
        }
        catch(Exception e){
            throw new ProjectIdException("Project ID "+ project.getProjectIdentifier().toUpperCase());
        }
        //return projectRepository.save(project);
    }
    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Project ID '"+projectId+"' does not exist");

        }


        return project;
    }


    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }
    public void deleteProjectByIdentifier(String projectId){
        Project project=projectRepository.findByProjectIdentifier(projectId);
        if(project==null)
        {
            throw new ProjectIdException("Cannot find Project with ID "+projectId+" This project does not exists");
        }
        projectRepository.delete(project);
    }

}
