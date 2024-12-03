package com.kcb.restful.service.impl;

import com.kcb.restful.entity.ProjectEntity;
import com.kcb.restful.exemptionhandler.ProcessingException;
import com.kcb.restful.repository.ProjectRepository;
import com.kcb.restful.service.ProjectService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Flux<ProjectEntity> getAllProjects(String refId, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        List<ProjectEntity> data = projectRepository.findAllBy(paging);
        return Flux.fromIterable(data);
    }


    @Override
    public Mono<ProjectEntity> createProject(ProjectEntity requestCSM) {
        return Mono.fromCallable(() -> projectRepository.save(requestCSM))
                .onErrorMap(throwable -> new ProcessingException("Error creating project" + throwable.getMessage()));
    }


    @Override
    public Mono<ProjectEntity> findProjectByID(Long id, String refId) {
        return Mono.fromCallable(() -> projectRepository.findById(id))
                .flatMap(optionalProject -> optionalProject
                        .map(Mono::just)
                        .orElseGet(() -> Mono.error(new ProcessingException("Project not found with ID: " + id))))
                .onErrorMap(throwable -> new ProcessingException("Error finding project: " + throwable.getMessage()));
    }

}
