package ibatis;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapLocator {//ibatis SqlMapConfig.xml ������ �о���� �κ�
	public static SqlMapClient getMapper(){
		SqlMapClient sqlMapper;
		try{
		Reader reader=Resources.getResourceAsReader("SqlMapConfig.xml");
		
		//SqlMapConfig.xml������ �о���δ�.
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		
		reader.close();//�Է½�Ʈ���� ����.
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		return sqlMapper;
	}
}
