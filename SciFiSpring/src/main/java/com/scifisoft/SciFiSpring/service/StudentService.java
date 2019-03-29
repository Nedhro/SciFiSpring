package com.scifisoft.SciFiSpring.service;

import java.util.List;

import com.scifisoft.SciFiSpring.dto.StudentDTO;

public interface StudentService {

	StudentDTO createOrUpdate(StudentDTO studentDTO);

	StudentDTO getById(String studentId);

	List<StudentDTO> getAll();

	boolean deleteById(String studentId);
}
