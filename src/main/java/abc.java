import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.IOException;

public class abc {
    public static final String FONT = "./src/main/resources/arial.ttf";

    public static void main(String[] args) throws IOException {
        // Creating a PdfWriter object
        String dest = "C:\\Temp\\sample.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument object
        PdfDocument pdf = new PdfDocument(writer);

        // Creating a Document object
        Document doc = new Document(pdf);

        // Creating text object
        Text text1 = new Text("Элком");

        // Setting font of the text
        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);
        text1.setFont(font);

        // Setting font color
        text1.setFontColor(Color.BLACK);

        // Creating Paragraph
        Paragraph paragraph1 = new Paragraph();

        // Adding text1 to the paragraph
        paragraph1.add(text1);

        // Adding paragraphs to the document
        doc.add(paragraph1);
        doc.close();

        System.out.println("Документ создан");
    }
}