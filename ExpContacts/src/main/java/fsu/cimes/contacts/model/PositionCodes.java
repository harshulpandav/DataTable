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
    @NamedQuery(name = "PositionCodes.findAll", query = "SELECT p FROM PositionCodes p"),
    @NamedQuery(name = "PositionCodes.findById", query = "SELECT p FROM PositionCodes p WHERE p.id = :id"),
    @NamedQuery(name = "PositionCodes.findByPositionID", query = "SELECT p FROM PositionCodes p WHERE p.positionID = :positionID"),
    @NamedQuery(name = "PositionCodes.findByPositionCode", query = "SELECT p FROM PositionCodes p WHERE p.positionCode = :positionCode")})
public class PositionCodes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Position_ID", precision = 53, scale = 0)
    private Double positionID;
    @Column(length = 255)
    private String positionCode;

    public PositionCodes() {
    }

    public PositionCodes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPositionID() {
        return positionID;
    }

    public void setPositionID(Double positionID) {
        this.positionID = positionID;
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
        if (!(object instanceof PositionCodes)) {
            return false;
        }
        PositionCodes other = (PositionCodes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dataobjects.PositionCodes[ id=" + id + " ]";
    }
    
}
