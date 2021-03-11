import org.apache.ibatis.type.JdbcType;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "${DATA}")
public class ${CLASSNAME} {

	/**
	 * 主键
	 * */
	@TableId(value = "ID", type = IdType.UUID)
	private String id;
	
    ${COLUMS}
    
    public void setId(String id){
		this.id = id;
	} 
	
	public String getId(){
		return  id;
	} 
	
    ${SETGETCOLUMS}
	
}	