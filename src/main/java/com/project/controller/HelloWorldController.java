package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;

@RestController
@RequestMapping("/")
public class HelloWorldController {

	static final Logger logger = Logger.getLogger(HelloWorldController.class);

	@RequestMapping(value = "/get/students", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getStudents() {

		List<Student> students = new ArrayList<Student>();

		Student student = new Student();
		student.setFirstName("Anurag");
		student.setLastName("Pundir");
		student.setEmail("anuragPundir@gmial.com");

		Student student1 = new Student();
		student1.setFirstName("AKash");
		student1.setLastName("chauhan");
		student1.setEmail("anuragPundir@gmial.com");

		Student student2 = new Student();
		student2.setFirstName("ankush");
		student2.setLastName("verma");
		student2.setEmail("anuragPundir@gmial.com");

		students.add(student);
		students.add(student1);
		students.add(student2);

		return students;
	}

	@RequestMapping(value = "/get/student/{studentName}/{age}", method = RequestMethod.GET)
	@ResponseBody
	public Student getStudent(@PathVariable("studentName") String studentName) throws Exception {
		Student student = null;
		if (studentName.equals("anurag")) {
			student = new Student();
			student.setFirstName("Anurag");
			student.setLastName("Pundir");
			student.setEmail("anuragPundir@gmial.com");
			return student;
		} else if (studentName.equals("akash")) {
			student = new Student();
			student.setFirstName("AKash");
			student.setLastName("chauhan");
			student.setEmail("anuragPundir@gmial.com");
			return student;
		} else if (studentName.equals("ankush")) {
			student = new Student();
			student.setFirstName("ankush");
			student.setLastName("verma");
			student.setEmail("anuragPundir@gmial.com");
			return student;
		} else {
			throw new Exception("Data not found");
		}
	}

	@RequestMapping(value = "/get/students/{studentName}/{age}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Student> getStudentRE(@PathVariable("studentName") String studentName) throws Exception {
		ResponseEntity<Student> responseEntity = null;
		Student student = null;
		if (studentName.equals("anurag")) {
			student = new Student();
			student.setFirstName("Anurag");
			student.setLastName("Pundir");
			student.setEmail("anuragPundir@gmial.com");
			responseEntity = new ResponseEntity<Student>(student, HttpStatus.OK);
			return responseEntity;
		} else if (studentName.equals("akash")) {
			student = new Student();
			student.setFirstName("AKash");
			student.setLastName("chauhan");
			student.setEmail("anuragPundir@gmial.com");
			responseEntity = new ResponseEntity<Student>(student, HttpStatus.OK);
			return responseEntity;
		} else if (studentName.equals("ankush")) {
			student = new Student();
			student.setFirstName("ankush");
			student.setLastName("verma");
			student.setEmail("anuragPundir@gmial.com");
			responseEntity = new ResponseEntity<Student>(student, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new Exception("Data not found");
		}
	}

	@RequestMapping(value = "/insert/student", method = RequestMethod.POST, headers = "Content-Type=application/json")
	@ResponseBody
	public ResponseEntity<String> insertStudent(@RequestBody Student student) {
		return new ResponseEntity<String>("Data Saved", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/insert/info/student", method = RequestMethod.POST, headers = "Content-Type=application/json")
	@ResponseBody
	public Student insertStudentInfo(@RequestBody Student student) {
		return student;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException() {
		return new ResponseEntity<String>(
				"<html>\n" + "<body>\n" + "\n" + "<h1>Exception occured</h1>\n" + "\n" + "</body>\n" + "</html>",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}