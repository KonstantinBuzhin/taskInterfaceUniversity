package model;

public class University {

	private long idNote;
	private long idLector;
	private long idDepartment;
	
	public long getIdNote() {
		return idNote;
	}
	public void setIdNote(long idNote) {
		this.idNote = idNote;
	}
	public long getIdLector() {
		return idLector;
	}
	public void setIdLector(long idLector) {
		this.idLector = idLector;
	}
	public long getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(long idDepartment) {
		this.idDepartment = idDepartment;
	}
	public University(long idNote, long idLector, long idDepartment) {
		this.idNote = idNote;
		this.idLector = idLector;
		this.idDepartment = idDepartment;
	}
	@Override
	public String toString() {
		return "University [idNote=" + idNote + ", idLector=" + idLector + ", idDepartment=" + idDepartment + "]";
	}
	public University() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idDepartment ^ (idDepartment >>> 32));
		result = prime * result + (int) (idLector ^ (idLector >>> 32));
		result = prime * result + (int) (idNote ^ (idNote >>> 32));
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
		University other = (University) obj;
		if (idDepartment != other.idDepartment)
			return false;
		if (idLector != other.idLector)
			return false;
		if (idNote != other.idNote)
			return false;
		return true;
	}
	
	
}
