package org.reproducer.entities;/*
 *----------------------------------------------------------------------------
 *                 🌟 HibernateWithoutSpring 🌟
 *----------------------------------------------------------------------------
 *  📁 Package: org.reproducer.entities
 *  👤 Author: hardik
 *  📅 Date: Wednesday, 02 April 2025
 *  ⏰ Time: 17:20
 *----------------------------------------------------------------------------
 *  Description:
 *  - Brief description of the file's purpose and functionality.
 *  - Additional details if necessary.
 *----------------------------------------------------------------------------
 */

import java.util.Set;

public class AppUser {
    private Long id;
    private String name;
    private Set<Address> addresses;
    private Set<Order> orders;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Address> getAddresses() { return addresses; }
    public void setAddresses(Set<Address> addresses) { this.addresses = addresses; }

    public Set<Order> getOrders() { return orders; }
    public void setOrders(Set<Order> orders) { this.orders = orders; }
}
