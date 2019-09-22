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
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import javax.inject.Inject;

/**
 *
 * @author RICARDO
 */

@Route("step2")
@PageTitle("CDI Inject")
public class ViewTwo extends VerticalLayout{

    @Inject
    private CustomerFacade customerService;
    
    private final Grid<Customer> grid;
    
    public ViewTwo() {
        this.grid = new Grid<>(Customer.class);
        
        setupGrid();
        
        Button button = new Button("Cargar Datos");
               
        add(button,grid);
        
        button.addClickListener((t) -> {
            grid.setItems(customerService.findAll());
        });
        
        
    }

    private void setupGrid() {
        grid.removeAllColumns(); //Quitar todas las Columnas de la Vista
        
        //Diferentes variantes de addColum
        grid.addColumn(Customer::getName).setHeader("Nombre de Cliente");
        grid.addColumns("addressline1","addressline2");
        grid.addColumn("discountCode.rate").setHeader("Rango de Descuento");
        
    }
    
    
    
}
