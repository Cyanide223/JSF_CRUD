/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author HP-PC
 */
@Entity
@Table(name = "profession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profession.findAll", query = "SELECT p FROM Profession p"),
    @NamedQuery(name = "Profession.findByProfId", query = "SELECT p FROM Profession p WHERE p.profId = :profId"),
    @NamedQuery(name = "Profession.findByProfession", query = "SELECT p FROM Profession p WHERE p.profession = :profession")})
public class Profession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prof_id")
    private Integer profId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "profession")
    private String profession;
    @OneToMany(mappedBy = "profId")
    private Collection<MyContacts> myContactsCollection;

    public Profession() {
    }

    public Profession(Integer profId) {
        this.profId = profId;
    }

    public Profession(Integer profId, String profession) {
        this.profId = profId;
        this.profession = profession;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @XmlTransient
    public Collection<MyContacts> getMyContactsCollection() {
        return myContactsCollection;
    }

    public void setMyContactsCollection(Collection<MyContacts> myContactsCollection) {
        this.myContactsCollection = myContactsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profId != null ? profId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profession)) {
            return false;
        }
        Profession other = (Profession) object;
        if ((this.profId == null && other.profId != null) || (this.profId != null && !this.profId.equals(other.profId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Profession[ profId=" + profId + " ]";
    }

}
