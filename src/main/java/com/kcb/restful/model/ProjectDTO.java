package com.kcb.restful.model;
import com.kcb.restful.entity.TaskEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private List<TaskEntity> tasks;
}

