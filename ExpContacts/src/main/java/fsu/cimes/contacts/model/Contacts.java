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
@Table(catalog = "ExNetContacts", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c"),
    @NamedQuery(name = "Contacts.findById", query = "SELECT c FROM Contacts c WHERE c.id = :id"),
//    @NamedQuery(name = "Contacts.findByPerPosition", query = "SELECT c FROM Contacts c WHERE c.perPosition = :perPosition"),
    @NamedQuery(name = "Contacts.findByField2", query = "SELECT c FROM Contacts c WHERE c.field2 = :field2"),
    @NamedQuery(name = "Contacts.findByPatronID", query = "SELECT c FROM Contacts c WHERE c.patronID = :patronID"),
    @NamedQuery(name = "Contacts.findByAutoID", query = "SELECT c FROM Contacts c WHERE c.autoID = :autoID"),
    @NamedQuery(name = "Contacts.findByLastname", query = "SELECT c FROM Contacts c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Contacts.findByFirstname", query = "SELECT c FROM Contacts c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Contacts.findBySalutation", query = "SELECT c FROM Contacts c WHERE c.salutation = :salutation"),
    @NamedQuery(name = "Contacts.findByTitle", query = "SELECT c FROM Contacts c WHERE c.title = :title"),
    @NamedQuery(name = "Contacts.findByOrganization", query = "SELECT c FROM Contacts c WHERE c.organization = :organization"),
    @NamedQuery(name = "Contacts.findByCity", query = "SELECT c FROM Contacts c WHERE c.city = :city"),
    @NamedQuery(name = "Contacts.findByState", query = "SELECT c FROM Contacts c WHERE c.state = :state"),
    @NamedQuery(name = "Contacts.findByZip", query = "SELECT c FROM Contacts c WHERE c.zip = :zip"),
    @NamedQuery(name = "Contacts.findByPhone", query = "SELECT c FROM Contacts c WHERE c.phone = :phone"),
    @NamedQuery(name = "Contacts.findByFax", query = "SELECT c FROM Contacts c WHERE c.fax = :fax"),
    @NamedQuery(name = "Contacts.findByEmail", query = "SELECT c FROM Contacts c WHERE c.email = :email"),
    @NamedQuery(name = "Contacts.findByCounty", query = "SELECT c FROM Contacts c WHERE c.county = :county"),
    @NamedQuery(name = "Contacts.findByPositionCode", query = "SELECT c FROM Contacts c WHERE c.positionCode = :positionCode"),
    @NamedQuery(name = "Contacts.findByPositionCodeLike", query = "SELECT c FROM Contacts c WHERE c.positionCode like :positionCode"),

//    @NamedQuery(name = "Contacts.findByUpdate", query = "SELECT c FROM Contacts c WHERE c.update = :update"),
    @NamedQuery(name = "Contacts.findByDateEntered", query = "SELECT c FROM Contacts c WHERE c.dateEntered = :dateEntered"),
    @NamedQuery(name = "Contacts.findByPlus", query = "SELECT c FROM Contacts c WHERE c.plus = :plus"),
    @NamedQuery(name = "Contacts.findByCountyID", query = "SELECT c FROM Contacts c WHERE c.countyID = :countyID"),
    @NamedQuery(name = "Contacts.findByAddress1", query = "SELECT c FROM Contacts c WHERE c.address1 = :address1"),
    @NamedQuery(name = "Contacts.findByAddress2", query = "SELECT c FROM Contacts c WHERE c.address2 = :address2"),
    @NamedQuery(name = "Contacts.findByAddress3", query = "SELECT c FROM Contacts c WHERE c.address3 = :address3"),
    @NamedQuery(name = "Contacts.findByAddress4", query = "SELECT c FROM Contacts c WHERE c.address4 = :address4"),
    @NamedQuery(name = "Contacts.findByField26", query = "SELECT c FROM Contacts c WHERE c.field26 = :field26"),
    @NamedQuery(name = "Contacts.findByPhone2", query = "SELECT c FROM Contacts c WHERE c.phone2 = :phone2"),
    @NamedQuery(name = "Contacts.findByWWWAddress", query = "SELECT c FROM Contacts c WHERE c.wWWAddress = :wWWAddress"),
    @NamedQuery(name = "Contacts.findByStatus", query = "SELECT c FROM Contacts c WHERE c.status = :status"),
    @NamedQuery(name = "Contacts.findByDateCreated", query = "SELECT c FROM Contacts c WHERE c.dateCreated = :dateCreated"),
    @NamedQuery(name = "Contacts.findByDateModified", query = "SELECT c FROM Contacts c WHERE c.dateModified = :dateModified")})
public class Contacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Column(name = " Per Position", precision = 53, scale = 0)
//    private Double perPosition;
    @Column(precision = 53, scale = 0)
    private Double field2;
    @Column(length = 255)
    private String patronID;
    @Column(precision = 53, scale = 0)
    private Double autoID;
    @Column(length = 255)
    private String lastname;
    @Column(length = 255)
    private String firstname;
    @Column(length = 255)
    private String salutation;
    @Column(length = 255)
    private String title;
    @Column(length = 255)
    private String organization;
    @Column(length = 255)
    private String city;
    @Column(length = 255)
    private String state;
    @Column(precision = 53, scale = 0)
    private Double zip;
    @Column(length = 255)
    private String phone;
    @Column(length = 255)
    private String fax;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String county;
    @Column(length = 255)
    private String positionCode;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date update;
    @Column(length = 255)
    private String dateEntered;
    @Column(precision = 53, scale = 0)
    private Double plus;
    @Column(precision = 53, scale = 0)
    private Double countyID;
    @Column(length = 255)
    private String address1;
    @Column(length = 255)
    private String address2;
    @Column(length = 255)
    private String address3;
    @Column(length = 255)
    private String address4;
    @Column(length = 255)
    private String field26;
    @Column(length = 255)
    private String phone2;
    @Column(length = 255)
    private String wWWAddress;
    @Column(length = 255)
    private String status;
    @Column(name = "Date_Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "Date_Modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    public Contacts() {
    }

    public Contacts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Double getPerPosition() {
//        return perPosition;
//    }
//
//    public void setPerPosition(Double perPosition) {
//        this.perPosition = perPosition;
//    }

    public Double getField2() {
        return field2;
    }

    public void setField2(Double field2) {
        this.field2 = field2;
    }

    public String getPatronID() {
        return patronID;
    }

    public void setPatronID(String patronID) {
        this.patronID = patronID;
    }

    public Double getAutoID() {
        return autoID;
    }

    public void setAutoID(Double autoID) {
        this.autoID = autoID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

//    public Date getUpdate() {
//        return update;
//    }
//
//    public void setUpdate(Date update) {
//        this.update = update;
//    }

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Double getPlus() {
        return plus;
    }

    public void setPlus(Double plus) {
        this.plus = plus;
    }

    public Double getCountyID() {
        return countyID;
    }

    public void setCountyID(Double countyID) {
        this.countyID = countyID;
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

    public String getField26() {
        return field26;
    }

    public void setField26(String field26) {
        this.field26 = field26;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getWWWAddress() {
        return wWWAddress;
    }

    public void setWWWAddress(String wWWAddress) {
        this.wWWAddress = wWWAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dataobjects.Contacts[ id=" + id + " ]";
    }
    
}
