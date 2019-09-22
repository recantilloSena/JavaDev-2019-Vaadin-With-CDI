/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javadev.cdi;

import com.javadev.cdi.dao.CustomerFacade;
import com.javadev.cdi.modelo.Customer;
import com.javadev.cdi.modelo.DiscountCode;
import com.javadev.cdi.modelo.MicroMarket;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

/**
 *
 * @author RICARDO
 */
public class CustomerForm extends FormLayout{
    
    
    private final TextField name = new TextField("Nombre");
    private final TextField addressline1= new TextField("Dirección");
    private final TextField addressline2= new TextField("Dirección Alternativa");
   
    
    
    private Customer customer;
    private CustomerFacade customerService;
    
    

    public CustomerForm() {
        Binder<Customer> binder = new BeanValidationBinder<>(Customer.class);
        //binder.bindInstanceFields(customer); // Para todo el POJO

        binder.forField(name)
              .bind(
                   Customer::getName,
                   Customer::setName);
        binder.forField(addressline1)
              .bind(
                   Customer::getAddressline1,
                   Customer::setAddressline1);
        binder.forField(addressline2)
              .bind(
                   Customer::getAddressline1,
                   Customer::setAddressline2);
      
        
        
        
        
        Button save = new Button("Actulizar Datos");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.addClickListener(event -> {
           if (binder.validate().isOk()) {
             //customerService.edit(customer);
            }
           else
           {
               Notification.show("Algo no está Bien..!");
           }
       });
        
        add(name,addressline1,addressline2,save);
        
        
    }
    
     public void setCustomers(Customer customer) {
         this.customer = customer;
         
         name.setValue(customer.getName());
         addressline1.setValue(customer.getAddressline1());
         addressline2.setValue(customer.getAddressline2());
         
         
         
     }
    
    
    
}
