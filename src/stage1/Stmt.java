package stage1;

public class Stmt {
	public StmtType stmtType;
	private String stmtContent;
	
	public void setStmtContent(String s) {
		stmtContent = s;
	}
	
	public String getStmtContent() {
		return stmtContent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stmtContent == null) ? 0 : stmtContent.hashCode());
		result = prime * result + ((stmtType == null) ? 0 : stmtType.hashCode());
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
		Stmt other = (Stmt) obj;
		if (stmtContent == null) {
			if (other.stmtContent != null)
				return false;
		} else if (!stmtContent.equals(other.stmtContent))
			return false;
		if (stmtType != other.stmtType)
			return false;
		return true;
	}
	
	
}
