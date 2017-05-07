package stage1;

import java.util.Comparator;

public final class ObjectComparator implements Comparator<Object> {

	@Override
	public int compare(Object arg0, Object arg1) {
		if(arg0.toString().matches("[0-9]*"))
			return Integer.parseInt(arg0.toString()) - Integer.parseInt(arg1.toString());
		else
			return arg0.toString().compareTo(arg1.toString());
	}
	
}
