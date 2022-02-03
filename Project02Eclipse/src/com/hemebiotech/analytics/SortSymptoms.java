package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author S076562
 * @version 1.0
 * 
 */

public class SortSymptoms {

	public Map<String, Integer> sortAndCountSymptoms(String filepath) {

		Map<String, Integer> result = new TreeMap<String, Integer>();
		List<String> listSymptomsIn;

		ISymptomReader fichierLu = new ReadSymptomDataFromFile(filepath);

		listSymptomsIn = fichierLu.getSymptoms();
		if (listSymptomsIn == null) {
			return null;
		}

		for (String symptom : listSymptomsIn) {
			if (result.containsKey(symptom)) {
				result.put(symptom, result.get(symptom) + 1);
			} else {
				result.put(symptom, 1);
			}
		}
		return result;
	}

}