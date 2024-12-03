package com.kcb.restful.service;

import com.kcb.restful.entity.TaskEntity;
import reactor.core.publisher.Mono;

public interface TaskService {
    Mono<TaskEntity> createTask(Long projectId, TaskEntity requestCSM, String refId);

    Mono<TaskEntity> updateTask(Long taskId, String refId);

    Mono<TaskEntity> delete(Long taskId, String refId);
}
