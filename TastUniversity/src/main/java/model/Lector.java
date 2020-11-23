package model;

public class Lector {

	private long idLector;
	private String degree;
	private int salary;
	private String lectorName;
	private String lectorSurname;
	
	

	public Lector(long idLector, String degree, int salary, String lectorName, String lectorSurname) {
		this.idLector = idLector;
		this.degree = degree;
		this.salary = salary;
		this.lectorName = lectorName;
		this.lectorSurname = lectorSurname;
	}

	public String getLectorName() {
		return lectorName;
	}

	public void setLectorName(String lectorName) {
		this.lectorName = lectorName;
	}

	public String getLectorSurname() {
		return lectorSurname;
	}

	public void setLectorSurname(String lectorSurname) {
		this.lectorSurname = lectorSurname;
	}

	public long getIdLector() {
		return idLector;
	}

	public void setIdLector(long idLector) {
		this.idLector = idLector;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + (int) (idLector ^ (idLector >>> 32));
		result = prime * result + ((lectorName == null) ? 0 : lectorName.hashCode());
		result = prime * result + ((lectorSurname == null) ? 0 : lectorSurname.hashCode());
		result = prime * result + salary;
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
		Lector other = (Lector) obj;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (idLector != other.idLector)
			return false;
		if (lectorName == null) {
			if (other.lectorName != null)
				return false;
		} else if (!lectorName.equals(other.lectorName))
			return false;
		if (lectorSurname == null) {
			if (other.lectorSurname != null)
				return false;
		} else if (!lectorSurname.equals(other.lectorSurname))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	


	@Override
	public String toString() {
		return "Lector [idLector=" + idLector + ", degree=" + degree + ", salary=" + salary + ", lectorName="
				+ lectorName + ", lectorSurname=" + lectorSurname + "]";
	}

	public Lector() {
	}

}
