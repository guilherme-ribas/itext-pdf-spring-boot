package com.example.pdf_generator.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;

@Service
public class PdfService {

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public ByteArrayInputStream createPdf() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            // Add a simple paragraph
            document.add(new Paragraph("Hello, World!"));

            Paragraph preface = new Paragraph();
            addEmptyLine(preface, 1);

            document.add(new Paragraph("Table example: "));
            addEmptyLine(preface, 1);

            // Create table
            PdfPTable table = new PdfPTable(3); // 3 colunas
            table.addCell(new PdfPCell(new Paragraph("Header 1")));
            table.addCell(new PdfPCell(new Paragraph("Header 2")));
            table.addCell(new PdfPCell(new Paragraph("Header 3")));
            table.addCell(new PdfPCell(new Paragraph("Data 1")));
            table.addCell(new PdfPCell(new Paragraph("Data 2")));
            table.addCell(new PdfPCell(new Paragraph("Data 3")));

            document.add(table);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private static void addMetaData(Document document) {
        document.addTitle("My first PDF generated");
        document.addSubject("Using iText + Spring Boot");
        document.addKeywords("Java, PDF, iText, Spring Boot");
        document.addAuthor(System.getProperty("user.name"));
        document.addCreator(System.getProperty("user.name"));
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
