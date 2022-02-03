package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	public static final String MESSAGE_FILE_NOT_FOUND = "No file in found symptoms.txt";
	public static final String MESSAGE_OTHER_IO_ERROR = "Reading issue with the file in symptoms.txt";
	public static final String MESSAGE_FILE_CLOSE_ERROR = "File in not closed";

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {

		if (filepath == null) {
			return null;
		}

		List<String> result = new ArrayList<String>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(filepath));
			String line = reader.readLine();
				
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.err.println(MESSAGE_FILE_NOT_FOUND);
			return null;
		} catch (IOException e) {
			System.err.println(MESSAGE_OTHER_IO_ERROR);
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException f) {
					System.err.println(MESSAGE_FILE_CLOSE_ERROR);
				}
			}
		}
		
		return result;
	}

}
