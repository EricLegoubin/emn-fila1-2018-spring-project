package org.imta.fila1.spring.informationgare.modele.maj;

import java.sql.Timestamp;

public class MajObject {
	int courseId;
	Timestamp calculatedDate;
	boolean isCancelled;

	public MajObject() {
	}

	public MajObject(int courseId, Timestamp calculatedDate, boolean isCancelled) {
		super();
		this.courseId = courseId;
		this.calculatedDate = calculatedDate;
		this.isCancelled = isCancelled;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Timestamp getCalculatedDate() {
		return calculatedDate;
	}

	public void setCalculatedDate(Timestamp calculateDate) {
		this.calculatedDate = calculateDate;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public boolean getIsCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

}
