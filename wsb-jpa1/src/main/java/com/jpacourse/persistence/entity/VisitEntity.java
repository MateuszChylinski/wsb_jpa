package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	/**
	 * Relation ManyToOne, because one doctor can have many visits
	 * Fetch type is set to lazy, so the data will be prepared on demand.
	 */

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID", nullable = false)
	private DoctorEntity doctorEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID", nullable = false)
	private PatientEntity patientEntity;

	/**
	 * Cascades are set to give all available operations
	 * Orphan removal is set to true, so the database will delete specific medical treatment, or treatments after patient will be deleted
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "MEDICAL_TREATMENT_ID")
	private List<MedicalTreatmentEntity> medicalTreatmentEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctorEntity() {
		return doctorEntity;
	}

	public void setDoctorEntity(DoctorEntity doctorEntity) {
		this.doctorEntity = doctorEntity;
	}

	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}

	public List<MedicalTreatmentEntity> getMedicalTreatmentEntities() {
		return medicalTreatmentEntities;
	}

	public void setMedicalTreatmentEntities(List<MedicalTreatmentEntity> medicalTreatmentEntities) {
		this.medicalTreatmentEntities = medicalTreatmentEntities;
	}
}

