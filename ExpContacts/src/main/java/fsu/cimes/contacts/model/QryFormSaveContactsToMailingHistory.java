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
    @NamedQuery(name = "QryFormSaveContactsToMailingHistory.findAll", query = "SELECT q FROM QryFormSaveContactsToMailingHistory q"),
    @NamedQuery(name = "QryFormSaveContactsToMailingHistory.findByPatronID", query = "SELECT q FROM QryFormSaveContactsToMailingHistory q WHERE q.patronID = :patronID"),
    @NamedQuery(name = "QryFormSaveContactsToMailingHistory.findById", query = "SELECT q FROM QryFormSaveContactsToMailingHistory q WHERE q.id = :id")})
public class QryFormSaveContactsToMailingHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 255)
    private String patronID;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    public QryFormSaveContactsToMailingHistory() {
    }

    public QryFormSaveContactsToMailingHistory(Integer id) {
        this.id = id;
    }

    public String getPatronID() {
        return patronID;
    }

    public void setPatronID(String patronID) {
        this.patronID = patronID;
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
        if (!(object instanceof QryFormSaveContactsToMailingHistory)) {
            return false;
        }
        QryFormSaveContactsToMailingHistory other = (QryFormSaveContactsToMailingHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dataobjects.QryFormSaveContactsToMailingHistory[ id=" + id + " ]";
    }
    
}
