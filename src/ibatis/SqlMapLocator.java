package ibatis;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapLocator {//ibatis SqlMapConfig.xml 파일을 읽어오는 부분
	public static SqlMapClient getMapper(){
		SqlMapClient sqlMapper;
		try{
		Reader reader=Resources.getResourceAsReader("SqlMapConfig.xml");
		
		//SqlMapConfig.xml파일을 읽어들인다.
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		
		reader.close();//입력스트림을 닫음.
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		return sqlMapper;
	}
}
