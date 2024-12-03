package com.kcb.restful.service;

import com.kcb.restful.entity.ProjectEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectService {
    Flux<ProjectEntity> getAllProjects(String refId, int page, int size);

    Mono<ProjectEntity> createProject(ProjectEntity requestCSM);

    Mono<ProjectEntity> findProjectByID(Long id, String refId);
}
