package package1;
/*
 * ����ģʽ��
 */
public class Facade {
	
	SQLserver s=SQLserver.getInstance();
	
	//�������ݿ�
	public void ConnectSQL(){
		
		s.ConnectSQL();
	}
	
	//��¼�ɹ�������֤
	public void SQLverify(String a,String b){
		s.SQLverify(a, b);
		
	}

	//�Ƿ�ע��ɹ�
	public void zhuceverify(String a){
		s.ZhuceVerify(a);
		
	}
	
}
