package com.example.FinalProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "contactDetails")
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contactNo")
    private Long contactNo;

    @Column(name = "whatsUpNo")
    private Long whatsUpNo;

    @Column(name = "linkedIn", unique = true)
    private String linkedIn;

    @Column(name = "emergencyContact")
    private Long emergencyContact;

    @Column(name = "nativeAddress")
    private String nativeAddress;

    @Column(name = "permanentAddress")
    private String permanentAddress;

    @OneToOne(mappedBy = "contactDetails")
    @JsonBackReference
    private Employee employee;

    public ContactDetails() {
    }

    public ContactDetails(Long id, Long contactNo, Long whatsUpNo, String linkedIn, Long emergencyContact, String nativeAddress, String permanentAddress) {
        this.id = id;
        this.contactNo = contactNo;
        this.whatsUpNo = whatsUpNo;
        this.linkedIn = linkedIn;
        this.emergencyContact = emergencyContact;
        this.nativeAddress = nativeAddress;
        this.permanentAddress = permanentAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public Long getWhatsUpNo() {
        return whatsUpNo;
    }

    public void setWhatsUpNo(Long whatsUpNo) {
        this.whatsUpNo = whatsUpNo;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public Long getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Long emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getNativeAddress() {
        return nativeAddress;
    }

    public void setNativeAddress(String nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
