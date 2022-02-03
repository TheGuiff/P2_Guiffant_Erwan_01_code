package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomReader {
	/**
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable If no data is available, return an empty List
	 */
	List<String> getSymptoms ();
}
