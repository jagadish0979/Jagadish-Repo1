package com.assignments.service;

import com.assignments.model.CustomerRecord;


/**
 * @author Jagadish Anala
 *
 */
public interface XmlToObjectService {

	public CustomerRecord getXmlRecords(String xmlFileContent);
}
