<#list columnList as column>  

     /**
	 * 
	 * */
	@TableField(value = "${column.name}  ",jdbcType = JdbcType.VARCHAR)
	private String ${column.tfName} ;
</#list>   