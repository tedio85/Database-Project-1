package stage1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Test;

public class VectorTableTest {

	@Test
	public void test() {
		
		String name = "test";
		String pk = "pk";
		String[] attrs = {"A","B","C","pk","D"};
		String[] attrTypes = {"int", "varchar", "int", "varchar", "int"};
		Vector<Integer> strLen = new Vector<Integer>();
		strLen.add(10);
		strLen.add(40);
		
		VectorTable table = new VectorTable(name,
											pk,
											new Vector<String>(Arrays.asList(attrs)),
											new Vector<String>(Arrays.asList(attrTypes)),
											strLen);
		
		Vector<String> wordsB = new Vector<String>();
		Vector<String> wordsPk = new Vector<String>();
		for(Integer i=0;i<100;i++) {
				wordsB.add("B"+i.toString());
				wordsPk.add("pk"+i.toString());
		}
		
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		int j=0;
		for(int i=0;i<10;i++) {
			Vector<Object> tuple = new Vector<Object>();
			tuple.add(j++);
			tuple.add(wordsB.get(j));
			tuple.add(++j);
			tuple.add(wordsPk.get(++j));
			tuple.add(++j);
			table.insert(tuple);
			data.add(tuple);
		}
		
		table.show();
		
		Vector<Vector<Object>> t = table.getTable();
		for(int i=0;i<data.size();i++) {
			assertArrayEquals(data.get(i).toArray(), t.get(i).toArray());
		}
	}

}
