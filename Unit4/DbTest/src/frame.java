import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;

public class frame {
    private static JTextPane txtPane;
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        txtPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(txtPane);

        JButton startBtn = new JButton("add");
        JButton removeBtn = new JButton("remove");

        JLabel titleLbl = new JLabel("Database test");

        txtPane.setEditable(false);
        txtPane.setFont(new Font(Font.MONOSPACED, 0, 14));
        titleLbl.setFont(new Font(Font.MONOSPACED, 0, 20));

        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DBTESTSOMETHING");

        scrollPane.setBounds(5, 25, 375, 200);

        startBtn.setBounds(140, 260, 100, 25);
        removeBtn.setBounds(140, 290, 100, 25);

        titleLbl.setBounds(115, 225, 300, 25);

        startBtn.addActionListener(e -> userClickedStart());
        removeBtn.addActionListener(e -> userClickedRemove());

        frame.add(panel);
        panel.add(scrollPane);
        panel.add(startBtn);
        panel.add(removeBtn);
        panel.add(titleLbl);
        frame.setVisible(true);
    }
    static void userClickedStart()
    {
        test.AddRow();
    }
    static void userClickedRemove()
    {
        test.DeleteRow();
    }
    public static void finished()
    {
        try (BufferedReader br = new BufferedReader(new FileReader("src/input.txt")))
        {
            txtPane.read(br, null);
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
