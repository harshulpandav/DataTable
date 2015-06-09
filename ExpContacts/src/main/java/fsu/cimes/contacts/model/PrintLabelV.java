/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package fsu.cimes.contacts.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *
 * @author hpandav
 */
@Entity
@Table(name = "PrintLabel_V", catalog = "ExNetContacts", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrintLabelV.findAll", query = "SELECT p FROM PrintLabelV p"),
    @NamedQuery(name = "PrintLabelV.findByMailingID", query = "SELECT p FROM PrintLabelV p WHERE p.mailingID = :mailingID"),
    @NamedQuery(name = "PrintLabelV.findBySalutation", query = "SELECT p FROM PrintLabelV p WHERE p.salutation = :salutation"),
    @NamedQuery(name = "PrintLabelV.findByFirstname", query = "SELECT p FROM PrintLabelV p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "PrintLabelV.findByLastname", query = "SELECT p FROM PrintLabelV p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "PrintLabelV.findByOrganization", query = "SELECT p FROM PrintLabelV p WHERE p.organization = :organization"),
    @NamedQuery(name = "PrintLabelV.findByAddress1", query = "SELECT p FROM PrintLabelV p WHERE p.address1 = :address1"),
    @NamedQuery(name = "PrintLabelV.findByAddress2", query = "SELECT p FROM PrintLabelV p WHERE p.address2 = :address2"),
    @NamedQuery(name = "PrintLabelV.findByAddress3", query = "SELECT p FROM PrintLabelV p WHERE p.address3 = :address3"),
    @NamedQuery(name = "PrintLabelV.findByAddress4", query = "SELECT p FROM PrintLabelV p WHERE p.address4 = :address4"),
    @NamedQuery(name = "PrintLabelV.findByCity", query = "SELECT p FROM PrintLabelV p WHERE p.city = :city"),
    @NamedQuery(name = "PrintLabelV.findByState", query = "SELECT p FROM PrintLabelV p WHERE p.state = :state"),
    @NamedQuery(name = "PrintLabelV.findByZip", query = "SELECT p FROM PrintLabelV p WHERE p.zip = :zip")})
public class PrintLabelV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "MailingID")
    @Id
    private Integer mailingID;
    @Column(name = "Salutation")
    private String salutation;
    @Column(name = "Firstname")
    private String firstname;
    @Column(name = "Lastname")
    private String lastname;
    @Column(name = "Organization")
    private String organization;
    @Column(name = "Address1")
    private String address1;
    @Column(name = "Address2")
    private String address2;
    @Column(name = "Address3")
    private String address3;
    @Column(name = "Address4")
    private String address4;
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Zip")
    private Double zip;

    public PrintLabelV() {
    }

    public Integer getMailingID() {
        return mailingID;
    }

    public void setMailingID(Integer mailingID) {
        this.mailingID = mailingID;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getZip() {
        return zip;
    }

    public void setZip(Double zip) {
        this.zip = zip;
    }
    
}
