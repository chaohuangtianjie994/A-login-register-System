package package1;
/*
 * 门面模式类
 */
public class Facade {
	
	SQLserver s=SQLserver.getInstance();
	
	//连接数据库
	public void ConnectSQL(){
		
		s.ConnectSQL();
	}
	
	//登录成功与否的验证
	public void SQLverify(String a,String b){
		s.SQLverify(a, b);
		
	}

	//是否注册成功
	public void zhuceverify(String a){
		s.ZhuceVerify(a);
		
	}
	
}
