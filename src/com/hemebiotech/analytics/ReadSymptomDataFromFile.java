package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * @author Theo Conte
	 * @param filepath of the file
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}


	@Override
	public List<String> getSymptoms() {

		List<String> result = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
				String line = reader.readLine();
				while (line != null) {

					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		
		return result;
	}

}
