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
@Table(name = "PositionCodeCount_V", catalog = "ExNetContacts", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PositionCodeCountV.findAll", query = "SELECT p FROM PositionCodeCountV p"),
    @NamedQuery(name = "PositionCodeCountV.findById", query = "SELECT p FROM PositionCodeCountV p WHERE p.id = :id"),
    @NamedQuery(name = "PositionCodeCountV.findByPositionCode", query = "SELECT p FROM PositionCodeCountV p WHERE p.positionCode = :positionCode"),
    @NamedQuery(name = "PositionCodeCountV.findByPCount", query = "SELECT p FROM PositionCodeCountV p WHERE p.pCount = :pCount")})
public class PositionCodeCountV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false)
    @Id
    private int id;
    @Column(length = 255)
    private String positionCode;
    private Integer pCount;

    public PositionCodeCountV() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public Integer getPCount() {
        return pCount;
    }

    public void setPCount(Integer pCount) {
        this.pCount = pCount;
    }
    
}
