import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        jFrame.add(jPanel);
        jPanel.add(new JLabel("Название организации"));
        JTextField textField = new JTextField(20);
        jPanel.add(textField);
        JButton jButton = new JButton("Запустить");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Text text = new Text();
                try {
                    text.setPDF(textField.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jPanel.revalidate();
    }

    static JFrame getFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("PDF writer application");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(352, 370);
        frame.setLocation(500, 200);
        frame.setVisible(true);

        return frame;
    }
}
