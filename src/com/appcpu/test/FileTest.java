package com.appcpu.test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.Test;

public class FileTest {

	@Test
	public void test() {
		try {
			PDDocument document;
			document = new PDDocument();

			// Create a new blank page and add it to the document
			PDPage blankPage = new PDPage();
			document.addPage(blankPage);

			// Save the newly created document
			document.save("BlankPage.pdf");

			// finally make sure that the document is properly
			// closed.
			document.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		try {
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
			contentStream.drawString( "Hello World" );
			contentStream.endText();

			// Make sure that the content stream is closed:
			contentStream.close();

			// Save the results and ensure that the document is properly closed:
			document.save( "Hello World.pdf");
			document.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fail("Not yet implemented");
	}
	@Test
	public void test3() {
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fail("Not yet implemented");
	}
	@Test
	public void test4() {
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fail("Not yet implemented");
	}
	@Test
	public void test5() {
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fail("Not yet implemented");
	}
	
}
