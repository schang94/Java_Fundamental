package java_20190807.unicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnicastClient implements ActionListener {
	private String id;
	private String ip;
	private int port;
	private JFrame jframe;
	private JTextArea jta;
	private JTextField jtf;
	private JButton jbtn;

	public UnicastClient(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;
		jframe = new JFrame("Unicast Chatting");

		/********************* 중앙 시작 ***********************/
		jta = new JTextArea("", 30, 50);
		jta.setEditable(false);
		jta.setBackground(new Color(255,255,245));
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		/********************* 상단 끝 *************************/

		/********************* 하단 시작 ***********************/
		JPanel j1 = new JPanel();
		jtf = new JTextField(30);
		jtf.setBackground(new Color(255,255,255));
		jbtn = new JButton("전송");
		jbtn.setBackground(new Color(232,226,192));

		j1.setLayout(new BorderLayout());
		j1.add(jtf, BorderLayout.CENTER);
		j1.add(jbtn, BorderLayout.EAST);
		/********************* 하단 끝 *************************/

		/********************* 상단 시작 ***********************/
		JPanel j2 = new JPanel();
		j2.setBackground(new Color(255,244,192));
		JLabel jl1 = new JLabel("User ID : [" + id + "]");
		JLabel jl2 = new JLabel("Server IP : " + ip);
		j2.setLayout(new BorderLayout());
		j2.add(jl1, BorderLayout.CENTER);
		j2.add(jl2, BorderLayout.EAST);
		/********************* 상단 끝 *************************/

		jframe.add(jsp, BorderLayout.CENTER);
		jframe.add(j1, BorderLayout.SOUTH);
		jframe.add(j2, BorderLayout.NORTH);

		jframe.pack();
		jframe.setResizable(true);
		jframe.setVisible(true);

		// x(종료)를 눌렀을 때 프로그램 종료하기 위한 코드
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});

		// 이벤트 등록
		jbtn.addActionListener(this);
		jtf.addActionListener(this);
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new UnicastClient("syh1011", "127.0.0.1", 5000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object obj = e.getSource();
		if (obj == jtf) {
			// 텍스트 필드 가져오기
			String message = jtf.getText();
			// 텍스트 에어리어에 추가
			if (message.trim().length() == 0) {
				JOptionPane.showMessageDialog(jframe, "공백","Warning",JOptionPane.ERROR_MESSAGE);
			} else {
				jta.append(id + " : " + message + "\n");
				// 텍스트 필드에 입력 값 초기화
			}
			jtf.setText("");
			jtf.requestFocus();

		} else if (obj == jbtn) {
			String message = jtf.getText();
			// 텍스트 에어리어에 추가
			// 텍스트 필드에 입력 값 초기화
			if (message.trim().length() == 0) {
				JOptionPane.showMessageDialog(jframe, "공백","Warning",JOptionPane.ERROR_MESSAGE);
			} else {
				jta.append(id + " : " + message + "\n");
				// 텍스트 필드에 입력 값 초기화
			}
			jtf.setText("");
			jtf.requestFocus();
		}
	}
}
