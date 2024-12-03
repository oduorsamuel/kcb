package com.kcb.restful.controller;

import com.kcb.restful.entity.ProjectEntity;
import com.kcb.restful.service.ProjectService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("v1/kcb")
public class ProjectController {
    public  final ProjectService projectservice;

    public ProjectController(ProjectService projectservice) {
        this.projectservice = projectservice;
    }

    @GetMapping("/projects")
    public Flux<ProjectEntity> getProjects(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size, @RequestHeader("x-request-ref-Id") String refId){
        return projectservice.getAllProjects(refId,page,size);

    }
}
