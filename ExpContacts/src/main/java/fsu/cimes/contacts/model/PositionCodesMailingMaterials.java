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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "PositionCodesMailingMaterials.findAll", query = "SELECT p FROM PositionCodesMailingMaterials p"),
    @NamedQuery(name = "PositionCodesMailingMaterials.findByPositionCode", query = "SELECT p FROM PositionCodesMailingMaterials p WHERE p.positionCode = :positionCode"),
    @NamedQuery(name = "PositionCodesMailingMaterials.findByMaterialName", query = "SELECT p FROM PositionCodesMailingMaterials p WHERE p.materialName = :materialName"),
    @NamedQuery(name = "PositionCodesMailingMaterials.findByDateCompleted", query = "SELECT p FROM PositionCodesMailingMaterials p WHERE p.dateCompleted = :dateCompleted"),
    @NamedQuery(name = "PositionCodesMailingMaterials.findByMailingID", query = "SELECT p FROM PositionCodesMailingMaterials p WHERE p.mailingID = :mailingID"),
    @NamedQuery(name = "PositionCodesMailingMaterials.findById", query = "SELECT p FROM PositionCodesMailingMaterials p WHERE p.id = :id")})
public class PositionCodesMailingMaterials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 255)
    private String positionCode;
    @Column(length = 255)
    private String materialName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCompleted;
    private Integer mailingID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    public PositionCodesMailingMaterials() {
    }

    public PositionCodesMailingMaterials(Integer id) {
        this.id = id;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Integer getMailingID() {
        return mailingID;
    }

    public void setMailingID(Integer mailingID) {
        this.mailingID = mailingID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof PositionCodesMailingMaterials)) {
            return false;
        }
        PositionCodesMailingMaterials other = (PositionCodesMailingMaterials) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dataobjects.PositionCodesMailingMaterials[ id=" + id + " ]";
    }
    
}
