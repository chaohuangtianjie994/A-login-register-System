package package1;
/*
 * ���ܣ���¼�������ע�Ṧ�ܣ�����ע����档
 *    ��ע�����Ϣ���������ݿ��У����ҿ��Խ��е�¼������
 * author��ywq
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserRegister extends JFrame implements ActionListener{
	
	//�����¼��������
		JButton jb1,jb2,jb3=null;
		JRadioButton jrb1,jrb2=null;
		JPanel jp1,jp2,jp3=null;
	    JTextField jtf=null;
		JLabel jlb1,jlb2=null;
		JPasswordField jpf=null;
			
	
	public static void main(String[] args)
	{
		UserRegister ur=new UserRegister();
	}
	
	public UserRegister()
	{
		//�������
		 //�������
		jb1=new JButton("��¼");
		jb2=new JButton("ע��");
		jb3=new JButton("�˳�");
		//���ü���
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jlb1=new JLabel("�û�����");
		jlb2=new JLabel("��    �룺");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("ע���¼����");
		this.setLayout(new GridLayout(3,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 300, 180);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//����������ť
		if(e.getActionCommand()=="�˳�")
		{
			System.exit(0);
		}else if(e.getActionCommand()=="��¼")
		{
			//���õ�¼����
			this.login();
		}else if(e.getActionCommand()=="ע��")
		{
			//����ע�᷽��
			this.Regis();
		}
		
	}
	
	//ע�᷽��
     public void Regis() {
    	 
    	 
    	 this.dispose();  //�رյ�ǰ����
    	 new UI();   //���½���
    	 
		
		
	}

	//��¼����
	public void login() {
		
		SQLserver s=SQLserver.getInstance();
		s.ConnectSQL();
		s.SQLverify(jtf.getText(), jpf.getText());
		
		this.jtf.setText("");
		this.jpf.setText("");
		
	}

}
