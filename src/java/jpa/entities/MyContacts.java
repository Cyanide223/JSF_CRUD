/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HP-PC
 */
@Entity
@Table(name = "my_contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MyContacts.findAll", query = "SELECT m FROM MyContacts m"),
    @NamedQuery(name = "MyContacts.findByContactId", query = "SELECT m FROM MyContacts m WHERE m.contactId = :contactId"),
    @NamedQuery(name = "MyContacts.findByLastName", query = "SELECT m FROM MyContacts m WHERE m.lastName = :lastName"),
    @NamedQuery(name = "MyContacts.findByFirstName", query = "SELECT m FROM MyContacts m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "MyContacts.findByPhone", query = "SELECT m FROM MyContacts m WHERE m.phone = :phone"),
    @NamedQuery(name = "MyContacts.findByEmail", query = "SELECT m FROM MyContacts m WHERE m.email = :email"),
    @NamedQuery(name = "MyContacts.findByGender", query = "SELECT m FROM MyContacts m WHERE m.gender = :gender"),
    @NamedQuery(name = "MyContacts.findByBirthday", query = "SELECT m FROM MyContacts m WHERE m.birthday = :birthday")})
public class MyContacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_id")
    private Integer contactId;
    @Size(max = 30)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 20)
    @Column(name = "first_name")
    private String firstName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 10)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private Character gender;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @JoinColumn(name = "prof_id", referencedColumnName = "prof_id")
    @ManyToOne
    private Profession profId;
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne
    private Status statusId;
    @JoinColumn(name = "zip_code", referencedColumnName = "zip_code")
    @ManyToOne
    private ZipCode zipCode;

    public MyContacts() {
    }

    public MyContacts(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Profession getProfId() {
        return profId;
    }

    public void setProfId(Profession profId) {
        this.profId = profId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyContacts)) {
            return false;
        }
        MyContacts other = (MyContacts) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MyContacts[ contactId=" + contactId + " ]";
    }

}
