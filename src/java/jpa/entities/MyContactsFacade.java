/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author HP-PC
 */
@Stateless
public class MyContactsFacade extends AbstractFacade<MyContacts> {

    @PersistenceContext(unitName = "JSF_CRUDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyContactsFacade() {
        super(MyContacts.class);
    }

}
