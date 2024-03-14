package fsd;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MySwingApp extends JFrame implements KeyListener {
    public MySwingApp() {
        setTitle("My Swing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
//        JPanel contentPane = new JPanel();
//        contentPane.setLayout(new FlowLayout()); // 레이아웃 설정
        JButton j = new JButton("d");
        add(j);
        // 키 리스너 등록
        j.addKeyListener(this);
//        contentPane.addKeyListener(this);
        addKeyListener(this);
//        contentPane.setFocusable(true); 
        setVisible(true);
    }

    // 키 리스너 구현
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter 키가 눌렸을 때 실행할 동작
            System.out.println("Enter 키가 눌렸습니다!");
            // 여기에 원하는 동작을 추가하세요.
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 필요 없는 경우 빈 메서드로 남겨둡니다.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 필요 없는 경우 빈 메서드로 남겨둡니다.
    }

    public static void main(String[] args) {
        new MySwingApp();
    }
}
