import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;

public class Text {
    public static final String FONT = "./src/main/resources/Times New Roman.ttf";
    public static final String BOLD = "./src/main/resources/Times New Roman Полужирный.ttf";


    public Document setPDF(String text) throws IOException {
        //Добавляем шрифты
        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);
        PdfFont bold = PdfFontFactory.createFont(BOLD, PdfEncodings.IDENTITY_H);

        //Указываем путь рассположения pdf файла
        String path = "C:\\Temp\\sample1.pdf";
        PdfWriter writer = new PdfWriter(path);

        //Создаём pdf документ
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.addNewPage();

        //Добавляем текст
        com.itextpdf.layout.element.Text text1 = new com.itextpdf.layout.element.Text("ТЕХНИКО-КОММЕРЧЕСКОЕ ПРЕДЛОЖЕНИЕ").setFont(font);
        com.itextpdf.layout.element.Text text2 = new com.itextpdf.layout.element.Text("Предмет предложения: ").setFont(bold);
        com.itextpdf.layout.element.Text text3 = new com.itextpdf.layout.element.Text("Типовой шкаф управления ESQ").setFont(font);
        com.itextpdf.layout.element.Text text4 = new com.itextpdf.layout.element.Text("Заказчик: ").setFont(bold);
        com.itextpdf.layout.element.Text text7 = new com.itextpdf.layout.element.Text(text).setFont(font);
        com.itextpdf.layout.element.Text text5 = new com.itextpdf.layout.element.Text("Санкт-Петербург").setFont(font);
        com.itextpdf.layout.element.Text text6 = new com.itextpdf.layout.element.Text("2021").setFont(font);

        //Создаём документ
        Document document = new Document(pdfDoc);

        // Создаём параграф
        Paragraph paragraph1 = new Paragraph(text1);
        Paragraph paragraph2 = new Paragraph(text2);
        Paragraph paragraph3 = new Paragraph(text4);
        Paragraph paragraph4 = new Paragraph(text5);
        Paragraph paragraph5 = new Paragraph(text6);

        paragraph1.setFontSize(20f);
        paragraph1.setTextAlignment(TextAlignment.CENTER);
        paragraph1.setFontColor(new DeviceRgb(64, 128, 128));

        paragraph2.setFontSize(14f);
        paragraph2.add(text3);

        paragraph3.setFontSize(14f);
        paragraph3.add(text7);

        paragraph4.setTextAlignment(TextAlignment.CENTER);
        paragraph4.setFontSize(14f);


        paragraph5.setTextAlignment(TextAlignment.CENTER);
        paragraph5.setFontSize(14f);


        //Создаём изображение
        String imagePath1 = "./src/main/resources/Элком1.jpg";
        ImageData data1 = ImageDataFactory.create(imagePath1);
        String imagePath2 = "./src/main/resources/Элком2.jpg";
        ImageData data2 = ImageDataFactory.create(imagePath2);

        //Создаём объект изображения
        Image image1 = new Image(data1);
        Image image2 = new Image(data2);

        //Добавляем позицию изображения
        image1.setRelativePosition(0,0,0,0);
        image2.setRelativePosition(0,670,0,0);
        paragraph1.setFixedPosition(1,157, 500, 300);
        paragraph2.setFixedPosition(1,50, 300, 400);
        paragraph3.setFixedPosition(1,50, 280, 200);
        paragraph4.setFixedPosition(1,203, 90, 200);
        paragraph5.setFixedPosition(1,203, 75, 200);

        //Добавляем изображение в документ
        document.add(image1);
        document.add(image2);
        document.add(paragraph1);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);

        //Закрываем документ
        document.close();
        System.out.println("Изображение добавлено");
        return document;
    }
}
