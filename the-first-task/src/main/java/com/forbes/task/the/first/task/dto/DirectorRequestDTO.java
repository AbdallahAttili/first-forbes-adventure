package com.forbes.task.the.first.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorRequestDTO {

    private String id;
    private String name;
    private LocalDateTime birthDate;
    private String nationality;
    private String photoUrl;
}
