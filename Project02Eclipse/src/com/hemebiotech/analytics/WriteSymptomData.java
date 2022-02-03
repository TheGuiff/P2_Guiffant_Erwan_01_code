package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomData implements ISymptomWriter {

	public static final String MESSAGE_IO_ERROR = "Error on the output file results.out";
	public static final String MESSAGE_FILE_CLOSE_ERROR = "Output file not closed";

	private String filepath;

	public WriteSymptomData(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> listSymptoms) {

		FileWriter writer = null;

		try {
			writer = new FileWriter(filepath);
			for (Map.Entry<String, Integer> m : listSymptoms.entrySet()) {
				writer.write(m.getKey() + " : " + m.getValue() + "\n");
				}
			writer.close();
		} catch (IOException e) {
			System.err.println(MESSAGE_IO_ERROR);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException f) {
					System.err.println(MESSAGE_FILE_CLOSE_ERROR);
				}
			}
		}
	}
}
