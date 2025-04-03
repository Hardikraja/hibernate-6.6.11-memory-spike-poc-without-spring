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

public class Order {
    private Long id;
    private AppUser user;
    private Set<OrderItem> orderItems;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AppUser getUser() { return user; }
    public void setUser(AppUser user) { this.user = user; }

    public Set<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(Set<OrderItem> orderItems) { this.orderItems = orderItems; }
}

