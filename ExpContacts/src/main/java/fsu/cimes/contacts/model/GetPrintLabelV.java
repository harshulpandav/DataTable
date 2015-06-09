package fsu.cimes.contacts.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mchinmankar
 */
@Entity
@Table(name = "Get_PrintLabel_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GetPrintLabelV.findAll", query = "SELECT g FROM GetPrintLabelV g"),
    @NamedQuery(name = "GetPrintLabelV.findByRowNumber", query = "SELECT g FROM GetPrintLabelV g WHERE g.rowNumber = :rowNumber"),
    @NamedQuery(name = "GetPrintLabelV.findByMailingID", query = "SELECT g FROM GetPrintLabelV g WHERE g.mailingID = :mailingID"),
    @NamedQuery(name = "GetPrintLabelV.findBySalutation", query = "SELECT g FROM GetPrintLabelV g WHERE g.salutation = :salutation"),
    @NamedQuery(name = "GetPrintLabelV.findByFirstname", query = "SELECT g FROM GetPrintLabelV g WHERE g.firstname = :firstname"),
    @NamedQuery(name = "GetPrintLabelV.findByLastname", query = "SELECT g FROM GetPrintLabelV g WHERE g.lastname = :lastname"),
    @NamedQuery(name = "GetPrintLabelV.findByOrganization", query = "SELECT g FROM GetPrintLabelV g WHERE g.organization = :organization"),
    @NamedQuery(name = "GetPrintLabelV.findByAddress1", query = "SELECT g FROM GetPrintLabelV g WHERE g.address1 = :address1"),
    @NamedQuery(name = "GetPrintLabelV.findByAddress2", query = "SELECT g FROM GetPrintLabelV g WHERE g.address2 = :address2"),
    @NamedQuery(name = "GetPrintLabelV.findByAddress3", query = "SELECT g FROM GetPrintLabelV g WHERE g.address3 = :address3"),
    @NamedQuery(name = "GetPrintLabelV.findByAddress4", query = "SELECT g FROM GetPrintLabelV g WHERE g.address4 = :address4"),
    @NamedQuery(name = "GetPrintLabelV.findByCity", query = "SELECT g FROM GetPrintLabelV g WHERE g.city = :city"),
    @NamedQuery(name = "GetPrintLabelV.findByState", query = "SELECT g FROM GetPrintLabelV g WHERE g.state = :state"),
    @NamedQuery(name = "GetPrintLabelV.findByZip", query = "SELECT g FROM GetPrintLabelV g WHERE g.zip = :zip")})
public class GetPrintLabelV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "RowNumber")
    @Id
    private BigInteger rowNumber;
    @Column(name = "MailingID")
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

    public GetPrintLabelV() {
    }

    public BigInteger getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(BigInteger rowNumber) {
        this.rowNumber = rowNumber;
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
