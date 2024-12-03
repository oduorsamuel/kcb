package com.kcb.restful.controller;

import com.kcb.restful.entity.ProjectEntity;
import com.kcb.restful.entity.TaskEntity;
import com.kcb.restful.service.ProjectService;
import com.kcb.restful.service.TaskService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("v1/kcb")
public class ProjectController {
    public  final ProjectService projectservice;
    private final TaskService taskService;

    public ProjectController(ProjectService projectservice, TaskService taskService) {
        this.projectservice = projectservice;
        this.taskService = taskService;
    }
//   ADD DTO later
    @GetMapping("/projects")
    public Flux<ProjectEntity> getProjects(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size, @RequestHeader("x-request-ref-Id") String refId){
        return projectservice.getAllProjects(refId,page,size);

    }


    @PostMapping("/projects")

    public Mono<ProjectEntity> createProject(@RequestBody ProjectEntity requestCSM){
        return projectservice.createProject(requestCSM);
    }

    @GetMapping(value = "/projects/{id}")
    public Mono<ProjectEntity> findProjectByID(@PathVariable Long id, @RequestHeader("x-request-ref-Id") String refId){
        return projectservice.findProjectByID(id, refId);
    }


    @PostMapping(value = "/projects/{id}/task")
    public Mono<TaskEntity> createTask(@PathVariable Long projectId, @RequestHeader("x-request-ref-Id") String refId,@RequestBody TaskEntity requestCSM){

        return taskService.createTask(projectId, requestCSM, refId);
    }
}
