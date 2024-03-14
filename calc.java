package fsd;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

import javax.swing.*;

public class calc extends JFrame implements KeyListener {
	private DefaultListModel<String> model;
	private JList jList;
	private JButton[] bt;
	private JTextField edi;

	public calc() {
		setSize(400, 600);
		setLocationRelativeTo(null);
		;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		String[] keysets = { "1", "2", "3", "+", "-", "4", "5", "6", "x", "/", "7", "8", "9", "(", ")", "0", ".", "c","=" };
		int keysize = keysets.length;

		// 레이아웃 설정하기
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// 화면 배치하기
		edi = new JTextField();
		jList = new JList<>();
		model = new DefaultListModel<>();
		model.addElement("0");

		gbc.gridwidth = 5;
		gbc.gridheight = 4;
		gbc.weightx = 1;
		gbc.weighty = 5;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		jList.setModel(model);
		jList.addKeyListener(this);
		add(jList, gbc);
		gbc.gridy = 4;
		gbc.weighty = 0.2;
		gbc.gridheight = 1;
		edi.addKeyListener(this);
		add(edi, gbc);
		
		// 버튼 배치하기
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		bt = new JButton[keysize];
		for (int i = 0; i < keysize; i++) {
			bt[i] = new JButton(keysets[i]);
			if (i == keysize - 1) {
				// =버튼에 대한 기능
				bt[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ed = edi.getText();
						if (Equation.validEq(ed)) {
							model.clear();
							model.addElement(ed + " = " + Equation.eq(ed));
						} else {
							model.clear();
							model.addElement("잘못된 수식");
						}
						jList.setModel(model);
						edi.setText(null);
					}
				});
			}
			// c 버튼에 대한 기능
			else if (i == keysize - 2) {
				bt[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						edi.setText(null);
						model.clear();
						model.addElement("0");
						jList.setModel(model);
					}
				});
			} else {
				bt[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ed = edi.getText();
						JButton b = (JButton) e.getSource();
						ed += b.getText();
						edi.setText(ed);
					}
				});
			}
			bt[i].addKeyListener(this);
			gbc.gridx = i % 5;
			gbc.gridy = i / 5 + 5;
			gbc.weightx = 1;
			gbc.weighty = 1;
			gbc.gridwidth = 1;
			if (i == keysize - 4) {
				gbc.gridwidth = 2;
			} else if (i == keysize - 3 || i == keysize - 2 || i == keysize - 1) {
				gbc.gridx += 1;
			}
			add(bt[i], gbc);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new calc();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String ed = edi.getText();
		if (e.getKeyCode() == e.VK_ENTER || e.getKeyCode() == e.VK_EQUALS) {
			ed = Equation.onlyEq(ed);
			if(ed.equals("")) ed="0";
			if (Equation.validEq(ed)) {
				model.clear();
				model.addElement(ed + " = " + Equation.eq(ed));
			} else {
				model.clear();
				model.addElement("잘못된 수식");
			}
			jList.setModel(model);
			edi.setText(null);
		}
		else if(e.getKeyCode() == e.VK_BACK_SPACE){
			ed = ed.substring(0,ed.length()-1);
			edi.setText(ed);
		}
		else if(e.getKeyCode()==e.VK_SHIFT) {}
		else {
			ed += e.getKeyChar();
			edi.setText(ed);
		}
//		throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
//		throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
	}

}
