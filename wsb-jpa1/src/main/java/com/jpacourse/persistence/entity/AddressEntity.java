package com.jpacourse.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Cascades are set to give all available operations
	 * Orphan removal is set to true, so the database will delete specific medical treatment, or treatments after patient will be deleted
	 * Fetch type is set to LAzy, so the data will be on demand.
	 */

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID", nullable = false)
	private List<DoctorEntity> doctors;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID", nullable = false)
	private List<PatientEntity> patientEntities;

	private String city;

	private String addressLine1;

	private String addressLine2;

	private String postalCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public List<DoctorEntity> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<DoctorEntity> doctors) {
		this.doctors = doctors;
	}

	public List<PatientEntity> getPatientEntities() {
		return patientEntities;
	}

	public void setPatientEntities(List<PatientEntity> patientEntities) {
		this.patientEntities = patientEntities;
	}
}
