package com.appcpu.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class LrcFormat {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		int a = 0;
		//for text
		if (a != 0) {
			try {
				System.out.println("lrc format --- begin");
				String files;
				String pathSrc = "/Users/yangeric/Documents/study/subtitle/hous_of_card/hous_of_card_simple/";
				String pathDir = "/Users/yangeric/Documents/study/subtitle/hous_of_card/hous_of_card_simple2/";
				File folderSrc = new File(pathSrc);
				(new File(pathDir)).mkdirs();
				File[] listOfFiles = folderSrc.listFiles();
				for (int i = 0; i < listOfFiles.length; i++) {

					if (listOfFiles[i].isFile()) {
						files = listOfFiles[i].getName();
						System.out.println(files);
						BufferedReader br;
						br = new BufferedReader(new FileReader(pathSrc + files));
						// br = new BufferedReader(new InputStreamReader(
						// new FileInputStream(pathSrc+files), "UTF8"));
						BufferedWriter bw = new BufferedWriter(new FileWriter(
								pathDir + files));
						String line;
						int j = 0;
						String swap = "";
						while ((line = br.readLine()) != null) {
							// process the line.
							System.out.println(containsChinese(line) + " "
									+ line + "\n");
							if (!line.contains("-->") && !isInteger(line)
									&& !line.isEmpty()) {
								if (containsChinese(line)) {
									swap = line;
								} else {
									bw.write(line + "\n");
									bw.write(swap + "\n\n");
								}

							} else {
								// bw.write("\n");
							}
							j++;
						}
						br.close();
						bw.close();
					}
					// if (i>=1) {
					// break;
					// }

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//for pdf
		if (a == 0) {
			try {
				System.out.println("lrc format --- begin");
				String files;
				String pathSrc = "/Users/yangeric/Documents/study/subtitle/hous_of_card/hous_of_card_simple/";
				String pathDir = "/Users/yangeric/Documents/study/subtitle/hous_of_card/hous_of_card_simple_pdf_1/";
				File folderSrc = new File(pathSrc);
				(new File(pathDir)).mkdirs();
				File[] listOfFiles = folderSrc.listFiles();
				for (int i = 0; i < listOfFiles.length; i++) {

					if (listOfFiles[i].isFile()) {
						files = listOfFiles[i].getName();
						System.out.println(files);
						BufferedReader br;
						br = new BufferedReader(new FileReader(pathSrc + files));
						// br = new BufferedReader(new InputStreamReader(
						// new FileInputStream(pathSrc+files), "UTF8"));
//						BufferedWriter bw = new BufferedWriter(new FileWriter(pathDir + files));
						File fileDestPath=new File(pathDir + files+".pdf");
						PDDocument document = new PDDocument();
						PDPage page = new PDPage();
						document.addPage( page );

						// Create a new font object selecting one of the PDF base fonts
						PDFont font = PDType1Font.HELVETICA;

						// Start a new content stream which will "hold" the to be created content
						PDPageContentStream contentStream = new PDPageContentStream(document, page);

						// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
						contentStream.beginText();
						contentStream.setFont( font, 12 );
						contentStream.moveTextPositionByAmount( 100, 700 );
						
						
						String line;
						int j = 0;
						String swap = "";
						while ((line = br.readLine()) != null) {
							// process the line.
							System.out.println(containsChinese(line) + " "
									+ line + "\n");
							if (!line.contains("-->") && !isInteger(line)
									&& !line.isEmpty()) {
								if (containsChinese(line)) {
									swap = line;
								} else {
									contentStream.drawString( line + "\n");
									contentStream.drawString( swap + "\n\n" );
								}

							}
							j++;
						}
						br.close();
						contentStream.endText();

						// Make sure that the content stream is closed:
						contentStream.close();

						// Save the results and ensure that the document is properly closed:
						document.save(fileDestPath);
						document.close();
					}
					 if (i>=1) {
					 break;
					 }

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
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

	public static boolean containsChinese(String s) {

		for (int i = 0; i < s.length(); i++) {

			if (isJapanese(s.charAt(i))) {

				return true;

			}

		}

		return false;

	}

	public static boolean isJapanese(char c) {

		if (c >= '\u0100' && c <= '\uffff')
			return true;

		return false;

		// simpler: return c>'\u00ff';

	}

}
