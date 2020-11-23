package model;

public class Department {

	private long idDepartment;
	private String headDepartmentName;
	private String headDepartmentSurname;
	private String departmentName;

	public long getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(long idDepartment) {
		this.idDepartment = idDepartment;
	}

	public Department(long idDepartment, String headDepartmentName, String headDepartmentSurname, String departmentName) {
		this.idDepartment = idDepartment;
		this.headDepartmentName = headDepartmentName;
		this.headDepartmentSurname = headDepartmentSurname;
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [idDepartment=" + idDepartment + ", headDepartmentName=" + headDepartmentName
				+ ", headDepartmentSurname=" + headDepartmentSurname + ", departmentName=" + departmentName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((headDepartmentName == null) ? 0 : headDepartmentName.hashCode());
		result = prime * result + ((headDepartmentSurname == null) ? 0 : headDepartmentSurname.hashCode());
		result = prime * result + (int) (idDepartment ^ (idDepartment >>> 32));
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
		Department other = (Department) obj;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (headDepartmentName == null) {
			if (other.headDepartmentName != null)
				return false;
		} else if (!headDepartmentName.equals(other.headDepartmentName))
			return false;
		if (headDepartmentSurname == null) {
			if (other.headDepartmentSurname != null)
				return false;
		} else if (!headDepartmentSurname.equals(other.headDepartmentSurname))
			return false;
		if (idDepartment != other.idDepartment)
			return false;
		return true;
	}

	public String getHeadDepartmentName() {
		return headDepartmentName;
	}

	public void setHeadDepartmentName(String headDepartmentName) {
		this.headDepartmentName = headDepartmentName;
	}

	public String getHeadDepartmentSurname() {
		return headDepartmentSurname;
	}

	public void setHeadDepartmentSurname(String headDepartmentSurname) {
		this.headDepartmentSurname = headDepartmentSurname;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department() {
	}

}
