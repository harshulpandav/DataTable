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
@Table(name="GroupSelections", catalog = "ExNetContacts", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupSelections.findAll", query = "SELECT g FROM GroupSelections g"),
    @NamedQuery(name = "GroupSelections.findById", query = "SELECT g FROM GroupSelections g WHERE g.id = :id"),
    @NamedQuery(name = "GroupSelections.findByGroupsForMailing", query = "SELECT g FROM GroupSelections g WHERE g.groupsForMailing = :groupsForMailing")})
public class GroupSelections implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 255)
    private String groupsForMailing;

    public GroupSelections() {
    }

    public GroupSelections(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupsForMailing() {
        return groupsForMailing;
    }

    public void setGroupsForMailing(String groupsForMailing) {
        this.groupsForMailing = groupsForMailing;
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
        if (!(object instanceof GroupSelections)) {
            return false;
        }
        GroupSelections other = (GroupSelections) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dataobjects.GroupSelections[ id=" + id + " ]";
    }
    
}
