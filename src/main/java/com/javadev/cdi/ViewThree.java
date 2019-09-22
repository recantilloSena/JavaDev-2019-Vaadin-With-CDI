/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javadev.cdi;

import com.javadev.cdi.dao.CustomerFacade;
import com.javadev.cdi.modelo.Customer;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import javax.inject.Inject;

/**
 *
 * @author RICARDO
 */

@Route("step3")
@PageTitle("CDI Inject - Lumo - Binding")
//@Theme(value = Lumo.class, variant = Lumo.DARK)
public class ViewThree extends VerticalLayout{

    @Inject
    private CustomerFacade customerService;
    
    private final Grid<Customer> grid;
    
    private final CustomerForm form;
    
    private Customer customer;
    
    
    
    public ViewThree() {
        this.form = new CustomerForm();
        this.grid = new Grid<>(Customer.class);
        HorizontalLayout hl = new HorizontalLayout();
        
        setupGrid();
        
        Button button = new Button("Cargar Datos");
         
        add(button,hl);
        hl.add(grid, form);
        hl.setWidthFull();
        
        button.addClickListener((t) -> {
            grid.setItems(customerService.findAll());
        });
        
        grid.addItemClickListener((t) -> {
            
           this.form.setCustomers(t.getItem()); //El item Seleccionado al Formulario
            
        });
        
        
        
        
    }

    private void setupGrid() {
        grid.removeAllColumns(); //Quitar todas las Columnas de la Vista
        
        //Diferentes variantes de addColum
        grid.addColumn(Customer::getName).setHeader("Nombre de Cliente");
        grid.addColumns("addressline1","addressline2");
        grid.addColumn("discountCode.rate").setHeader("Rango de Descuento");
        grid.setHeightByRows(true);
        grid.setWidth("600px");
        
    }

    private void setCustomers() {
        
    }
    
    
    
}
