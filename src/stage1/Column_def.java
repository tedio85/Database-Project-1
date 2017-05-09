package stage1;

import java.io.Serializable;

public class Column_def implements Serializable{

	private static final long serialVersionUID = -3645791456454756802L;
	public final String column_name;
	public final String type_name;
	public final boolean isPrimaryKey;
	
	Column_def(String column_name, String type_name, boolean isPrimaryKey) {
		this.column_name = column_name;
		this.type_name = type_name;
		this.isPrimaryKey = isPrimaryKey;
	}
	
	public void show() {
		System.out.println();
		System.out.println("column_name: "+column_name);
		System.out.println("type_name: "+type_name);
		System.out.println("isPrimaryKey: "+isPrimaryKey);
		System.out.println();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((column_name == null) ? 0 : column_name.hashCode());
		result = prime * result + (isPrimaryKey ? 1231 : 1237);
		result = prime * result + ((type_name == null) ? 0 : type_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Column_def other = (Column_def) obj;
		if (column_name == null) {
			if (other.column_name != null)
				return false;
		} else if (!column_name.equals(other.column_name))
			return false;
		if (isPrimaryKey != other.isPrimaryKey)
			return false;
		if (type_name == null) {
			if (other.type_name != null)
				return false;
		} else if (!type_name.equals(other.type_name))
			return false;
		return true;
	}
	
	
}
