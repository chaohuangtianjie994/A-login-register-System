package package1;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;


/*
 * ע����档
 */
class UI extends JFrame implements ActionListener{
	
	
     //���������
	Facade fcd=new Facade();

	//�������
	JFrame jf;
	JPanel jp;
	JLabel jl1,jl2,jl3,jl4;
	static JTextField jtf1,jtf2,jtf3,jtf4;
	JButton jb1,jb2;
	
	public UI()
	{
		//��ʼ�����
		jf=new JFrame();
		jp=new JPanel();
		jl1=new JLabel("�������û�����");
		jtf1=new JTextField(10);
		jtf1.setToolTipText("�û�������Ϊ3-6λ��ĸ_��������");
		jl2=new JLabel("���������룺");
		jtf2=new JTextField(10);
		jtf2.setToolTipText("�������Ϊ6λ��ĸ_��������");
		jl3=new JLabel("������������");
		jtf3=new JTextField(10);
		jtf3.setToolTipText("�������뺺��2-4λ");
		jl4=new JLabel("������ѧ�ţ�");
		jtf4=new JTextField(10);
		jtf4.setToolTipText("ѧ�ű���Ϊ3-6λ����");
		
		jb1=new JButton("����");
		jb1.setToolTipText("���ҷ��ص�¼����Ŷ");
		jb2=new JButton("ע��");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp.setLayout(new GridLayout(5,2));
		
		jp.add(jl1);
		jp.add(jtf1);
		
		jp.add(jl2);
		jp.add(jtf2);
		
		jp.add(jl3);
		jp.add(jtf3);
		
		jp.add(jl4);
		jp.add(jtf4);
		
		jp.add(jb1);
		jp.add(jb2);
		
		this.add(jp);
		this.setTitle("ע�����");
		this.setBounds(200, 100, 250, 150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
		
		
		
	}
	
	
	
	

	public void actionPerformed(ActionEvent e) {
	
		if(e.getActionCommand()=="����")
		{
			this.dispose();
			new UserRegister();
//			System.out.println("-------");
			
		}else if(e.getActionCommand()=="ע��")
		{
				//����ע�᷽��
			this.zhuce();
			
		}
		
	}
   public void zhuce()
   {
	   String regex1="\\w{3,6}"; //�û���������3-6λ
		boolean flag1=jtf1.getText().matches(regex1);
		
		String regex2="\\w{6}"; //���������6λ
		boolean flag2=jtf2.getText().matches(regex2);
		
		String regex3="[\\u4e00-\\u9fa5]{2,4}"; //���������Ǻ���2-4����
		boolean flag3=jtf3.getText().matches(regex3);
		
		String regex4="\\d{3,6}";  //ѧ�ű�����3-6λ
		boolean flag4=jtf4.getText().matches(regex4);
		
//		if(jtf1.getText()==null||jtf2.getText()==null||jtf3.getText()==null||jtf4.getText()==null)
		if(flag1==false)
		{
			JOptionPane.showMessageDialog(null, "�û�����д����,����Ϊ3-6λ��ĸ_��������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			jtf1.setText("");
		}else if(flag2==false)
		{
			JOptionPane.showMessageDialog(null, "������д����,����Ϊ6λ��ĸ_��������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			jtf2.setText("");
		}else if(flag3==false)
		{
			JOptionPane.showMessageDialog(null, "������д����,���뺺��2-4λ", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			jtf3.setText("");
		}else if(flag4==false)
		{
			JOptionPane.showMessageDialog(null, "ѧ����д����,����Ϊ3-6λ����", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			jtf4.setText("");
		}else
		{			
			//����ע�᷽��/�ȼ��Ҫע����û����Ƿ����
//			 SQLserver ss=new SQLserver();
//	    	 ss.ConnectSQL();
//	    	 ss.ZhuceVerify(jtf1.getText());
			
//			SQLserver ss=SQLserver.getInstance();
//	    	 ss.ConnectSQL();
//	    	 ss.ZhuceVerify(jtf1.getText());
			
			//ʹ������ģʽ
			fcd.ConnectSQL();
			fcd.zhuceverify(jtf1.getText());
	    	 
//			ss.UserRegis(jtf1.getText(),jtf2.getText(),jtf3.getText(), jtf4.getText());
		    this.jtf1.setText("");
		    this.jtf2.setText("");
		    this.jtf3.setText("");
		    this.jtf4.setText("");
		    
		}
   }
	
}
