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
    @NamedQuery(name = "MaterialsAvailable.findAll", query = "SELECT m FROM MaterialsAvailable m"),
    @NamedQuery(name = "MaterialsAvailable.findById", query = "SELECT m FROM MaterialsAvailable m WHERE m.id = :id"),
    @NamedQuery(name = "MaterialsAvailable.findByMaterialName", query = "SELECT m FROM MaterialsAvailable m WHERE m.materialName = :materialName"),
    @NamedQuery(name = "MaterialsAvailable.findByFormat", query = "SELECT m FROM MaterialsAvailable m WHERE m.format = :format"),
    @NamedQuery(name = "MaterialsAvailable.findByDefaulDeliveryMethod", query = "SELECT m FROM MaterialsAvailable m WHERE m.defaulDeliveryMethod = :defaulDeliveryMethod"),
    @NamedQuery(name = "MaterialsAvailable.findByProject", query = "SELECT m FROM MaterialsAvailable m WHERE m.project = :project"),
    @NamedQuery(name = "MaterialsAvailable.findByElectronic", query = "SELECT m FROM MaterialsAvailable m WHERE m.electronic = :electronic"),
    @NamedQuery(name = "MaterialsAvailable.findByActive", query = "SELECT m FROM MaterialsAvailable m WHERE m.active = :active")})
public class MaterialsAvailable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean electronic;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean active;

    public MaterialsAvailable() {
    }

    public MaterialsAvailable(Integer id) {
        this.id = id;
    }

    public MaterialsAvailable(Integer id, boolean electronic, boolean active) {
        this.id = id;
        this.electronic = electronic;
        this.active = active;
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

    public boolean getElectronic() {
        return electronic;
    }

    public void setElectronic(boolean electronic) {
        this.electronic = electronic;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
        if (!(object instanceof MaterialsAvailable)) {
            return false;
        }
        MaterialsAvailable other = (MaterialsAvailable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[\""+this.id+"\",\""+
        		this.materialName+"\",\""+
        		this.format+"\",\""+
        		this.defaulDeliveryMethod+"\",\""+
        		this.project+"\",\""+
        		this.electronic+"\",\""+
        		this.active+"\"]";
    }
    
}
