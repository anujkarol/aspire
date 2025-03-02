package com.aspiree.person.aspire.service;

import com.aspiree.person.aspire.dto.ProjectDto;
import com.aspiree.person.aspire.model.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    public ProjectDto toDto(Project project){
        ProjectDto result = new ProjectDto();

        result.setId(project.getId());
        result.setTechnology(project.getTechnology());
        result.setTitle(project.getTitle());
        return result;
    }

    public Project toEntity(ProjectDto projectDto){
        Project result = new Project();
        result.setId(projectDto.getId());
        result.setTechnology(projectDto.getTechnology());
        result.setTitle(projectDto.getTitle());
        return result;
    }
}
