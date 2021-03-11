import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.font.otf.LanguageRecord;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static final String FONT = "./src/main/resources/arial.ttf";

    public static void main(String[] args) throws IOException {
        String path = "C:\\Temp\\sample1.pdf";
        PdfWriter writer = new PdfWriter(path);

        //Создаём pdf документ
        PdfDocument pdfDoc = new PdfDocument(writer);

        //Создаём новую страницу
        pdfDoc.addNewPage();

        //Добавляем текст
        Text text1 = new Text("ТЕХНИКОЕ-КОММЕРЧЕСКОЕ ПРЕДЛОЖЕНИЕ");

        // Setting font of the text
        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);
        text1.setFont(font);

        //Создаём документ
        Document document = new Document(pdfDoc);

        // Создаём параграф
        Paragraph paragraph1 = new Paragraph(text1);


        //Создаём изображение
        String imagePath1 = "C:\\Temp\\Элком.JPG";
        ImageData data1 = ImageDataFactory.create(imagePath1);
        String imagePath2 = "C:\\Temp\\Элком1.JPG";
        ImageData data2 = ImageDataFactory.create(imagePath2);

        //Создаём объект изображения
        Image image1 = new Image(data1);
        Image image2 = new Image(data2);

        //Добавляем позицию изображения
        image1.setRelativePosition(0,0,0,0);
        image2.setRelativePosition(20,670,0,0);
        paragraph1.setRelativePosition(20, 20, 20, 20);

        //Добавляем изображение в документ
        document.add(image1);
        document.add(image2);
        document.add(paragraph1);


        //Закрываем документ
        document.close();
        System.out.println("Изображение добавлено");
    }
}
