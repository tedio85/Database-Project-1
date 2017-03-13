package stage1.test;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.Vector;
import java.lang.IllegalArgumentException;

import org.junit.Test;

import stage1.VectorTable;

public class VectorTableTest {

	// simple test
	@Test
	public void test() {
		
		String name = "test";
		String pk = "pk";
		String[] attrs = {"\'A\'","\'B\'","\'C\'","\'pk\'","\'D\'"};
		String[] attrTypes = {"\'int\'", "\'varchar\'", "\'int\'", "\'varchar\'", "\'int\'"};
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
			tuple.add("\'"+wordsB.get(j)+"\'");
			tuple.add(++j);
			tuple.add("\'"+wordsPk.get(++j)+"\'");
			tuple.add(++j);
			
			
			Vector<String> tmp = new Vector<String>();
			for(Object t: tuple)
				tmp.add(t.toString());

			table.insert(tmp);
			String str = (String) tuple.get(1);
			str = str.replaceAll("\'", "");
			tuple.set(1, str);
			str = (String) tuple.get(3);
			str = str.replaceAll("\'", "");
			tuple.set(3, str);
			
			data.add(tuple);
		}
		
		table.show();
		
		Vector<Vector<Object>> t = table.getTable();
		for(int i=0;i<data.size();i++) {
			assertArrayEquals(data.get(i).toArray(), t.get(i).toArray());
		}
	}
	
	// test for unmatched types
	@Test()
	public void test2() {
		String name = "test2";
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
		
		
		String[] s = {"10", "\'b1\'", "11", "\'pk1\'", "5"};
		String[] w = {"1", "11", "asdflkj", "\'pk2\'", "6"};
		Vector<Object> correct = new Vector<Object>();
		correct.add(10);
		correct.add("b1");
		correct.add(11);
		correct.add("pk1");
		correct.add(5);
		Vector<String> correctStr = new Vector<String>(Arrays.asList(s));
		Vector<String> wrong = new Vector<String>(Arrays.asList(w));
		
		table.insert(correctStr);
		String test = "not in catch";
		try {
			table.insert(wrong);
		}
		catch(IllegalArgumentException e) {
			test = "in catch";
		}
		assertEquals("in catch", test);
		table.show();
		Vector<Vector<Object>> t = table.getTable();
		assertArrayEquals(correct.toArray(), t.get(0).toArray());
		
	}
	
	// test for tuples with null attributes
	@Test
	public void test3() {
		String name = "test3";
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
		
		Vector<String> attrName = new Vector<String>();
		attrName.add("\'A\'");
		attrName.add("\'pk\'");
		attrName.add("\'D\'");
		
		Vector<String> tup = new Vector<String>();
		tup.add(new Integer(1).toString());
		tup.add("\'pk!\'");
		tup.add(new Integer(3).toString());
		
		Vector<Object> ans = new Vector<Object>();
		ans.add(1);
		ans.add(null);
		ans.add(null);
		ans.add("pk!");
		ans.add(3);
			
		table.insert(attrName, tup);
		
		table.show();
		Vector<Vector<Object>> t = table.getTable();
		assertArrayEquals(ans.toArray(), t.get(0).toArray());
	}
	
	// test for duplicated records with NULL primary key
	@Test(expected=IllegalArgumentException.class)
	public void test4() {
		String name = "test4";
		String[] attrs = {"DogId","Territory","BD"};
		String[] attrTypes = {"int", "int", "int"};
		VectorTable table = new VectorTable(name,
											null,
											new Vector<String>(Arrays.asList(attrs)),
											new Vector<String>(Arrays.asList(attrTypes)),
											new Vector<Integer>());
		
		Vector<String> vec = new Vector<String>();
		for(int i=0;i<attrs.length;i++) {
			vec.add(new Integer(i).toString());
		}
			
		table.insert(new Vector<String>(Arrays.asList(attrs)), vec);
		table.insert(new Vector<String>(Arrays.asList(attrs)), vec);		
	}
}
