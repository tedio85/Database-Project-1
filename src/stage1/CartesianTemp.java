package stage1;

public class CartesianTemp {
	Object p_key1;
	Object p_key2;
	
	CartesianTemp(Object p_key1, Object p_key2) {
		this.p_key1 = p_key1;
		this.p_key2 = p_key2;
	}
	
	public void show(){
		System.out.println("("+p_key1+", "+p_key2+")");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p_key1 == null) ? 0 : p_key1.hashCode());
		result = prime * result + ((p_key2 == null) ? 0 : p_key2.hashCode());
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
		CartesianTemp other = (CartesianTemp) obj;
		if(this.p_key1 == null && other.p_key1 != null)
			return false;
		else if(this.p_key1 != null && other.p_key1 == null)
			return false;
		else if(this.p_key1 == null && other.p_key1 == null)
			return false;
		else if(this.p_key2 == null && other.p_key2 != null)
			return false;
		else if(this.p_key2 != null && other.p_key2 == null)
			return false;
		else if(this.p_key2 == null && other.p_key2 == null)
			return false;
		else {
			return this.p_key1.toString().equals(other.p_key1.toString()) &&
				   this.p_key2.toString().equals(other.p_key2.toString());
		}
	}
	
	
}
