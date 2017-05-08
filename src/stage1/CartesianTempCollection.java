package stage1;

import java.util.ArrayList;

public class CartesianTempCollection {
	private ArrayList<CartesianTemp> CartesianTempList;
	private boolean isSingleTable;
	private String lTName;
	private String rTName;
	
	CartesianTempCollection() {
		this.CartesianTempList = null;
		this.isSingleTable = false;
		this.lTName = "";
		this.rTName = "";
	}
	
	CartesianTempCollection(ArrayList<CartesianTemp> CartesianTempList, boolean isSingleTable, String lTName, String rTName){
		this.CartesianTempList = CartesianTempList;
		this.isSingleTable = isSingleTable;
		this.lTName = lTName;
		this.rTName = rTName;
	}
	
	public ArrayList<CartesianTemp> getCartesianTempList(){
		return CartesianTempList;
	}
	
	public boolean isSingleTable(){
		return isSingleTable;
	}
	
	public String getRightTableName() {
		return rTName;
	}
	
	public String getleftTableName() {
		return lTName;
	}
	
	public void show() {
		String count = "------";
		CartesianTempList.forEach(temp -> 
		{
			System.out.println(count);
			temp.show();
		});
	}
}
