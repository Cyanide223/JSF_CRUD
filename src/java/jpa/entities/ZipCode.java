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
@Table(name = "zip_code")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZipCode.findAll", query = "SELECT z FROM ZipCode z"),
    @NamedQuery(name = "ZipCode.findByZipCode", query = "SELECT z FROM ZipCode z WHERE z.zipCode = :zipCode"),
    @NamedQuery(name = "ZipCode.findByCity", query = "SELECT z FROM ZipCode z WHERE z.city = :city"),
    @NamedQuery(name = "ZipCode.findByState", query = "SELECT z FROM ZipCode z WHERE z.state = :state")})
public class ZipCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zip_code")
    private Integer zipCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "state")
    private String state;
    @OneToMany(mappedBy = "zipCode")
    private Collection<MyContacts> myContactsCollection;

    public ZipCode() {
    }

    public ZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public ZipCode(Integer zipCode, String city, String state) {
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        hash += (zipCode != null ? zipCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZipCode)) {
            return false;
        }
        ZipCode other = (ZipCode) object;
        if ((this.zipCode == null && other.zipCode != null) || (this.zipCode != null && !this.zipCode.equals(other.zipCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ZipCode[ zipCode=" + zipCode + " ]";
    }

}
