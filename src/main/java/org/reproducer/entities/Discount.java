package org.reproducer.entities;/*
 *----------------------------------------------------------------------------
 *                 🌟 HibernateWithoutSpring 🌟
 *----------------------------------------------------------------------------
 *  📁 Package: org.reproducer.entities
 *  👤 Author: hardik
 *  📅 Date: Wednesday, 02 April 2025
 *  ⏰ Time: 17:22
 *----------------------------------------------------------------------------
 *  Description:
 *  - Brief description of the file's purpose and functionality.
 *  - Additional details if necessary.
 *----------------------------------------------------------------------------
 */



public class Discount {
    private Long id;
    private String code;
    private Product product; // Fix: Add this field

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
