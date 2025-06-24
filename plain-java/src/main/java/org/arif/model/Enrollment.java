package org.arif.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Enrollment {

    private Long id;
    private Student student;
    private Course course;
    private java.time.LocalDate enrollmentDate;

}
