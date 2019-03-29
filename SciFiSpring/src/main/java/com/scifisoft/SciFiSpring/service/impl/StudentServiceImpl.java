package com.scifisoft.SciFiSpring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scifisoft.SciFiSpring.dao.StudentDao;
import com.scifisoft.SciFiSpring.dto.StudentDTO;
import com.scifisoft.SciFiSpring.models.Student;
import com.scifisoft.SciFiSpring.service.StudentService;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	@Transactional(readOnly = false)
	public StudentDTO createOrUpdate(StudentDTO studentDTO) {

		Student student = new Student();

		try {
			String studentId = studentDTO.getStudentID();

			int size = studentDao.findAll().size();
			size = size + 1;

			if (studentId == null) {
				// save new record
				student.setStudentID(" " + size);

			} else {
				// Update old record
				Student studentEntity = studentDao.findById(studentId);
				student.setStudentID(studentEntity.getStudentID());

			}
			student.setStudentName(studentDTO.getStudentName());
			student.setStudentClass(studentDTO.getStudentClass());
			student.setStudentAddress(studentDTO.getStudentAddress());

			studentDao.saveOrUpdate(student);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentDTO;
	}

	@Override
	public StudentDTO getById(String studentId) {

		StudentDTO dto = new StudentDTO();

		try {
			Student student = studentDao.findById(studentId);

			dto.setStudentID(student.getStudentID());
			dto.setStudentName(student.getStudentName());
			dto.setStudentClass(student.getStudentClass());
			dto.setStudentAddress(student.getStudentAddress());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<StudentDTO> getAll() {

		List<StudentDTO> dtoList = new ArrayList<>();
		try {
			List<Student> studentList = studentDao.findAll();
			for (Student student : studentList) {
				StudentDTO dto = new StudentDTO();

				dto.setStudentID(student.getStudentID());
				dto.setStudentName(student.getStudentName());
				dto.setStudentClass(student.getStudentClass());
				dto.setStudentAddress(student.getStudentAddress());
				dtoList.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteById(String studentId) {
		try {
			studentDao.deleteById(Student.class, studentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
