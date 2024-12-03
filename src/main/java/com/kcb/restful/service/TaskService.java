package com.kcb.restful.service;

import com.kcb.restful.entity.TaskEntity;
import reactor.core.publisher.Mono;

public interface TaskService {
    Mono<TaskEntity> createTask(Long projectId, TaskEntity requestCSM, String refId);
}
