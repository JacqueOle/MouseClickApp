import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseClickCounter extends JFrame implements MouseListener {
    private int leftClickCount = 0;
    private int rightClickCount = 0;
    private JLabel leftClickLabel;
    private JLabel rightClickLabel;

    public MouseClickCounter() {
        setTitle("Mouse Click Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel leftLabel = new JLabel("Left Clicks:");
        leftClickLabel = new JLabel("0");

        JLabel rightLabel = new JLabel("Right Clicks:");
        rightClickLabel = new JLabel("0");

        panel.add(leftLabel);
        panel.add(leftClickLabel);
        panel.add(rightLabel);
        panel.add(rightClickLabel);

        add(panel);

        addMouseListener(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MouseClickCounter().setVisible(true);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            leftClickCount++;
            leftClickLabel.setText(String.valueOf(leftClickCount));
        } else if (SwingUtilities.isRightMouseButton(e)) {
            rightClickCount++;
            rightClickLabel.setText(String.valueOf(rightClickCount));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}