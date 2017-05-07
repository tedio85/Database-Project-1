package stage1;

public class ObjCompare{

	public static int compare(Object arg0, Object arg1) {
		if(arg0 instanceof Integer)
			return Integer.parseInt(arg0.toString()) - Integer.parseInt(arg1.toString());
		else
			return arg0.toString().compareTo(arg1.toString());
	}	
}
