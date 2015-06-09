/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsu.cimes.contacts.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hpandav
 */
@Entity
@Table(catalog = "ExNetContacts", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MailingHistoryContacts.findAll", query = "SELECT m FROM MailingHistoryContacts m"),
    @NamedQuery(name = "MailingHistoryContacts.findById", query = "SELECT m FROM MailingHistoryContacts m WHERE m.id = :id"),
    @NamedQuery(name = "MailingHistoryContacts.findByMailingID", query = "SELECT m FROM MailingHistoryContacts m WHERE m.mailingID = :mailingID"),
    @NamedQuery(name = "MailingHistoryContacts.findByPatronContactID", query = "SELECT m FROM MailingHistoryContacts m WHERE m.patronContactID = :patronContactID"),
    @NamedQuery(name = "MailingHistoryContacts.findByMaterialID", query = "SELECT m FROM MailingHistoryContacts m WHERE m.materialID = :materialID"),
    @NamedQuery(name = "MailingHistoryContacts.findByDeliveryMeth", query = "SELECT m FROM MailingHistoryContacts m WHERE m.deliveryMeth = :deliveryMeth")})
public class MailingHistoryContacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer mailingID;
    private Integer patronContactID;
    private Integer materialID;
    @Column(length = 255)
    private String deliveryMeth;

    public MailingHistoryContacts() {
    }

    public MailingHistoryContacts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMailingID() {
        return mailingID;
    }

    public void setMailingID(Integer mailingID) {
        this.mailingID = mailingID;
    }

    public Integer getPatronContactID() {
        return patronContactID;
    }

    public void setPatronContactID(Integer patronContactID) {
        this.patronContactID = patronContactID;
    }

    public Integer getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Integer materialID) {
        this.materialID = materialID;
    }

    public String getDeliveryMeth() {
        return deliveryMeth;
    }

    public void setDeliveryMeth(String deliveryMeth) {
        this.deliveryMeth = deliveryMeth;
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
        if (!(object instanceof MailingHistoryContacts)) {
            return false;
        }
        MailingHistoryContacts other = (MailingHistoryContacts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dataobjects.MailingHistoryContacts[ id=" + id + " ]";
    }
    
}
