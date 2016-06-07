package package1;
/*
 * 功能：登录界面带着注册功能，弹出注册界面。
 *    将注册的信息保存在数据库中，并且可以进行登录操作。
 * author：ywq
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserRegister extends JFrame implements ActionListener{
	
	//定义登录界面的组件
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
		//创建组件
		 //创建组件
		jb1=new JButton("登录");
		jb2=new JButton("注册");
		jb3=new JButton("退出");
		//设置监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jlb1=new JLabel("用户名：");
		jlb2=new JLabel("密    码：");
		
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
		this.setTitle("注册登录界面");
		this.setLayout(new GridLayout(3,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 300, 180);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//监听各个按钮
		if(e.getActionCommand()=="退出")
		{
			System.exit(0);
		}else if(e.getActionCommand()=="登录")
		{
			//调用登录方法
			this.login();
		}else if(e.getActionCommand()=="注册")
		{
			//调用注册方法
			this.Regis();
		}
		
	}
	
	//注册方法
     public void Regis() {
    	 
    	 
    	 this.dispose();  //关闭当前界面
    	 new UI();   //打开新界面
    	 
		
		
	}

	//登录方法
	public void login() {
		
		SQLserver s=SQLserver.getInstance();
		s.ConnectSQL();
		s.SQLverify(jtf.getText(), jpf.getText());
		
		this.jtf.setText("");
		this.jpf.setText("");
		
	}

}
