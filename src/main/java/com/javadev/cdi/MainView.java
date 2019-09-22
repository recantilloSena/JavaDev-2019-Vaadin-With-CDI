package com.javadev.cdi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import javax.inject.Inject;

/**
 * The main view contains a simple label element and a template element.
 */
@Route("")
public class MainView extends VerticalLayout {

    @Inject
    private MessageBean messageBean;

    public MainView() {
        Button button = new Button("Hola Mundo");
               
        add(button);
        
        button.addClickListener((t) -> {
            Notification.show("Este es un Bean : " + messageBean.getMessage());
        });
    }

}
