package com.assignments.controller;

import java.util.logging.Logger;

import javax.servlet.annotation.MultipartConfig;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignments.model.CustomerStatement;
import com.assignments.model.FileModel;
import com.assignments.service.AssignmentService;



/**
 * @author Jagadish Anala
 *
 */
@RestController
@MultipartConfig
@RequestMapping("/")
public class AssignmentController {
	private static final Logger logger = Logger.getLogger(AssignmentController.class.getName());

	@Autowired
	private AssignmentService assignmentService;
	
	@RequestMapping(value = "/processCSV", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerStatement[]> processCSV(@RequestBody FileModel fileModel) {
		String fileContents = StringUtils.EMPTY;
		logger.info("fileName========>" + fileModel.getFileName());
		logger.info("fileContents========>" + fileModel.getFileContent());
		fileContents = fileModel.getFileContent();
		CustomerStatement[] customerStatements = assignmentService.processCSV(fileContents);
		return new ResponseEntity<CustomerStatement[]>(customerStatements, HttpStatus.OK);
	}

	@RequestMapping(value = "/processXML", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerStatement[]> processXML(@RequestBody FileModel fileModel) {
		String fileContents = StringUtils.EMPTY;
		logger.info("fileName========>" + fileModel.getFileName());
		logger.info("fileContents========>" + fileModel.getFileContent());
		fileContents = fileModel.getFileContent();
		CustomerStatement[] customerStatements = assignmentService.processXML(fileContents);
		return new ResponseEntity<CustomerStatement[]>(customerStatements, HttpStatus.OK);
	}
}
