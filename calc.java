package fsd;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class calc extends JFrame implements ActionListener, KeyListener{
    public calc(){
        setSize(400, 600);
        setLocation(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

              //FlowLayout 객체 전달하기
        setLayout(new FlowLayout(FlowLayout.LEFT));
        //버튼을 만들어서 
        JButton btn1=new JButton("버튼1");
        JButton btn2=new JButton("버튼2");
        JButton btn3=new JButton("버튼3");
        
        //프레임에 추가하기 
        add(btn1);
        add(btn2);
        add(btn3);
        
        setVisible(true);
    }

    
    public static void main(String[] args) {
        new calc();
    }



    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
