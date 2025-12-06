package com.dykyi.toad.dto;

import com.dykyi.toad.entity.Address;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class StudentDTO {
    String id;
    String name;
    String birthDate;
    String group;
    Integer number;
    Address address;
    CuratorDTO curator;
    List<CourseDTO> finishedCourses;
}