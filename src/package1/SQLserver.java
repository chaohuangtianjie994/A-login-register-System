package package1;

import java.sql.*;

import javax.swing.JOptionPane;
/*
 * 与数据库相关的操作，单独封装成类
 */

class SQLserver {

	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	String user,pwd;
	
	/*
	 * 将此类设置为单例模式。
	 * 1、私有化构造函数
	 * 2、创建对象
	 * 3、设置一个用来获取实例的public方法。
	 */
	private SQLserver()
	{
		
	}
	private static final SQLserver ss=new SQLserver();
	
	public static SQLserver getInstance()
	{
		return ss;
		
	}
	
	//将连接数据库的方法封装为一个方法
	public void ConnectSQL()
	{
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //加载驱动
			
			ct=DriverManager.getConnection("jdbc:odbc:ywq"); //得到连接
			
			System.out.println("已成功连接数据库...");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//注册用户的方法
	public void UserRegis(String a,String b,String c,String d)
	{
		//创建火箭车
		try {
			ps=ct.prepareStatement("insert into users values(?,?,?,?)");
			ps.setString(1,a);
			ps.setString(2,b);
			ps.setString(3,c);
			ps.setString(4,d);
			
			//执行
			int i=ps.executeUpdate();
			if(i==1)
			{
				JOptionPane.showMessageDialog(null, "注册成功","提示消息",JOptionPane.WARNING_MESSAGE);
			    
			}else
			{
				JOptionPane.showMessageDialog(null, "注册失败","提示消息",JOptionPane.ERROR_MESSAGE);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	登录验证方法
	public void SQLverify(String a,String b)
	{
		try {
			ps=ct.prepareStatement("select * from users where 用户名=? and 密码=? ");
			ps.setString(1, a);
			ps.setString(2, b);
			
			// ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				user = rs.getString(1);
				pwd = rs.getString(2);
				JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);
				System.out.println("成功获取到密码和用户名from数据库");
				System.out.println(user + "\t" + pwd + "\t");
			}else
			{
				JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.ERROR_MESSAGE);
			    
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//注册验证方法，判断用户名是否已经存在
	public void ZhuceVerify(String a)
	{
		try {
			ps=ct.prepareStatement("select * from users where 用户名=?");
//			System.out.println(ps);
			ps.setString(1, a);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "该用户名已经存在", "提示信息", JOptionPane.WARNING_MESSAGE);
			}else
			{
//				进行注册
//				UI ui=new UI();
				this.UserRegis(UI.jtf1.getText(),UI.jtf2.getText(),UI.jtf3.getText(),UI.jtf4.getText());
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
