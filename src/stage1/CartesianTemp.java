package stage1;

public class CartesianTemp {
	Object p_key1;
	Object p_key2;
	
	CartesianTemp(Object p_key1, Object p_key2) {
		this.p_key1 = p_key1;
		this.p_key2 = p_key2;
	}
	
	public void show(){
		System.out.println("p_key1: "+p_key1);
		System.out.println("p_key2: "+p_key2);
	}
	
	@Override
    public boolean equals(Object that) {
        if(that instanceof CartesianTemp) {
            CartesianTemp ct = (CartesianTemp) that;
            return this.p_key1 == ct.p_key1 && this.p_key2 == ct.p_key2;
        }
        return false;
    }
	
	 @Override
	    public int hashCode() {
	        return p_key1.hashCode() + p_key2.hashCode();
	    }
}
