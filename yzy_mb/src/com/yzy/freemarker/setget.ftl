<#list columnList as column>  

	public void set${column.tfName}(String ${column.name}){
		this.${column.name} = ${column.name};
	} 
	
	public String get${column.tfName}(){
		return  ${column.name};
	} 	
</#list>