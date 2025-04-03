package org.reproducer.entities;/*
 *----------------------------------------------------------------------------
 *                 🌟 HibernateWithoutSpring 🌟
 *----------------------------------------------------------------------------
 *  📁 Package: org.reproducer.entities
 *  👤 Author: hardik
 *  📅 Date: Wednesday, 02 April 2025
 *  ⏰ Time: 17:21
 *----------------------------------------------------------------------------
 *  Description:
 *  - Brief description of the file's purpose and functionality.
 *  - Additional details if necessary.
 *----------------------------------------------------------------------------
 */

import java.util.Set;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Category category;
    private Set<Discount> discounts;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Set<Discount> getDiscounts() { return discounts; }
    public void setDiscounts(Set<Discount> discounts) { this.discounts = discounts; }
}
