package stage1;

import java.util.ArrayList;
import java.util.Map;

import com.google.common.collect.Multimap;

public class IndexTable extends VectorTable{
	private Map<String, MultiMap<Object, Object>> map = new Map<String, Multimap<Object, Object>>();
	
	IndexTable(DB db, CreateTableStmt statement){
		super(db, statement);
		for(int i = 0; i < attrs.size(); i++) {
			Multimap tmp = new Multimap<Object, Object>();
			map.put(attrs.get(i).getName(), tmp);
		}
	}
	@Override
	public void insert(InsertStmt statement) throws IllegalArgumentException{
		super.insert(statement);
		ArrayList<ColNameValuePair> colNameValuePair = statement.getNameValuePair();
		if(statement.isUsingDefaultAttrOrder()) {
			for(int i=0; i<attrs.size(); i++) {
				
			}
		} 
		else {
			
		}
	}
}
