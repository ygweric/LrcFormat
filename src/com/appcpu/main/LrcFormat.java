package com.appcpu.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class LrcFormat {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		try {
			System.out.println("lrc format --- begin");
			String files;
			String pathSrc="/Users/yangeric/Documents/study/subtitle/hous_of_card/";
			String pathDir="/Users/yangeric/Documents/study/subtitle/hous_of_card_simple/";
			File folderSrc = new File(pathSrc);
			(new File(pathDir)).mkdirs();
			File[] listOfFiles = folderSrc.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {

				if (listOfFiles[i].isFile()) {
					files = listOfFiles[i].getName();
					System.out.println(files);
					BufferedReader br;
					br = new BufferedReader(new FileReader(
							pathSrc+files));
//					br = new BufferedReader(new InputStreamReader(
//		                      new FileInputStream(pathSrc+files), "UTF8"));
					BufferedWriter bw = new BufferedWriter(new FileWriter(
							pathDir+files));
					String line;
					while ((line = br.readLine()) != null) {
						// process the line.
//						System.out.println("line: " + line);
						if (!line.contains("-->") && !isInteger(line)) {
							bw.write(line + "\n");
						} else {
							// bw.write("\n");
						}

					}
					br.close();
					bw.close();
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}
}
