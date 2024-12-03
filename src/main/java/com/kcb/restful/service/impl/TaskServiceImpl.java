package com.kcb.restful.service.impl;

import com.kcb.restful.entity.TaskEntity;
import com.kcb.restful.exemptionhandler.ProcessingException;
import com.kcb.restful.repository.ProjectRepository;
import com.kcb.restful.repository.TaskRepository;
import com.kcb.restful.service.TaskService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TaskServiceImpl implements TaskService {
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public TaskServiceImpl(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }



    @Override
    public Mono<TaskEntity> createTask(Long projectId, TaskEntity requestCSM, String refId) {
        //Add find by id
        //if does not exist return not found
        // if exist save task
        return null;
}


}
