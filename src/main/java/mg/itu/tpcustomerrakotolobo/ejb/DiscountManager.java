/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomerrakotolobo.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.itu.tpcustomerrakotolobo.entities.Discount;

/**
 *
 * @author Administrator
 * 
 * class dedicated to data management
 * (select, insert, update)
 */
@Stateless
public class DiscountManager {
    @PersistenceContext(unitName = "customerPU") 
    private EntityManager em;
    
    /** 
     * public List<Discount> getAllDiscounts()
     * select all the discounts 
     */
    public List<Discount> getAllDiscounts(){
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();  
    }
    
    /** 
     * public void persist(Discount discount)
     * insert a new discount 
     */
    public void persist(Discount discount) {
        em.persist(discount);
    }
    
    /** 
     * public Customer findById(int idCustomer)
     * find a customer by his id
     */
    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
}
