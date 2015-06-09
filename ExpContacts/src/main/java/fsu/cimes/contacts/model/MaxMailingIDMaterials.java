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
    @NamedQuery(name = "MaxMailingIDMaterials.findAll", query = "SELECT m FROM MaxMailingIDMaterials m"),
    @NamedQuery(name = "MaxMailingIDMaterials.findById", query = "SELECT m FROM MaxMailingIDMaterials m WHERE m.id = :id"),
    @NamedQuery(name = "MaxMailingIDMaterials.findByMaterialName", query = "SELECT m FROM MaxMailingIDMaterials m WHERE m.materialName = :materialName"),
    @NamedQuery(name = "MaxMailingIDMaterials.findByFormat", query = "SELECT m FROM MaxMailingIDMaterials m WHERE m.format = :format"),
    @NamedQuery(name = "MaxMailingIDMaterials.findByDefaulDeliveryMethod", query = "SELECT m FROM MaxMailingIDMaterials m WHERE m.defaulDeliveryMethod = :defaulDeliveryMethod"),
    @NamedQuery(name = "MaxMailingIDMaterials.findByProject", query = "SELECT m FROM MaxMailingIDMaterials m WHERE m.project = :project"),
    @NamedQuery(name = "MaxMailingIDMaterials.findByDateCompleted", query = "SELECT m FROM MaxMailingIDMaterials m WHERE m.dateCompleted = :dateCompleted"),
    @NamedQuery(name = "MaxMailingIDMaterials.findByNumberSent", query = "SELECT m FROM MaxMailingIDMaterials m WHERE m.numberSent = :numberSent")})
public class MaxMailingIDMaterials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 255)
    private String materialName;
    @Column(length = 255)
    private String format;
    @Column(length = 255)
    private String defaulDeliveryMethod;
    @Column(length = 255)
    private String project;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCompleted;
    @Column(name = "Number_Sent")
    private Integer numberSent;

    public MaxMailingIDMaterials() {
    }

    public MaxMailingIDMaterials(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDefaulDeliveryMethod() {
        return defaulDeliveryMethod;
    }

    public void setDefaulDeliveryMethod(String defaulDeliveryMethod) {
        this.defaulDeliveryMethod = defaulDeliveryMethod;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Integer getNumberSent() {
        return numberSent;
    }

    public void setNumberSent(Integer numberSent) {
        this.numberSent = numberSent;
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
        if (!(object instanceof MaxMailingIDMaterials)) {
            return false;
        }
        MaxMailingIDMaterials other = (MaxMailingIDMaterials) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dataobjects.MaxMailingIDMaterials[ id=" + id + " ]";
    }
    
}
