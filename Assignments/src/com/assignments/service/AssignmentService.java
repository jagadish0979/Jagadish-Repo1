package com.assignments.service;

import com.assignments.model.CustomerStatement;


/**
 * @author Jagadish Anala
 *
 */
public interface AssignmentService {

	public CustomerStatement[] processCSV(String fileContent);

	public CustomerStatement[] processXML(String fileContent);
}
