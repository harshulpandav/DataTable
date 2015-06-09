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
    @NamedQuery(name = "MailingHistoryPositionCodes.findAll", query = "SELECT m FROM MailingHistoryPositionCodes m"),
    @NamedQuery(name = "MailingHistoryPositionCodes.findById", query = "SELECT m FROM MailingHistoryPositionCodes m WHERE m.id = :id"),
    @NamedQuery(name = "MailingHistoryPositionCodes.findByMailingID", query = "SELECT m FROM MailingHistoryPositionCodes m WHERE m.mailingID = :mailingID"),
    @NamedQuery(name = "MailingHistoryPositionCodes.findByPositionCode", query = "SELECT m FROM MailingHistoryPositionCodes m WHERE m.positionCode = :positionCode")})
public class MailingHistoryPositionCodes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer mailingID;
    @Column(length = 255)
    private String positionCode;

    public MailingHistoryPositionCodes() {
    }

    public MailingHistoryPositionCodes(Integer id) {
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

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
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
        if (!(object instanceof MailingHistoryPositionCodes)) {
            return false;
        }
        MailingHistoryPositionCodes other = (MailingHistoryPositionCodes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dataobjects.MailingHistoryPositionCodes[ id=" + id + " ]";
    }
    
}
