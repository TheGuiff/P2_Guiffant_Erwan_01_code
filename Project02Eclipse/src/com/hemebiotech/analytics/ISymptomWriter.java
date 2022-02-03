package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	/**
	 * @param listSymptoms map - key : symptom, value : nb of occurs, sorted by
	 *                     symptoms
	 */
	void writeSymptoms(Map<String, Integer> listSymptoms);

}
