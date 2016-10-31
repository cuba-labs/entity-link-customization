package com.company.demo.web.order;

import com.company.demo.entity.Order;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.EntityLinkField;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class OrderEdit extends AbstractEditor<Order> {
    @Named("fieldGroup.customer")
    private EntityLinkField customerField;
    @Inject
    private FieldGroup fieldGroup;
    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        customerField.setScreenOpenType(WindowManager.OpenType.NEW_TAB);

        fieldGroup.addCustomField("customerLink", (datasource, propertyId) -> {
            EntityLinkField linkField = componentsFactory.createComponent(EntityLinkField.class);
            linkField.setDatasource(datasource, "customer");
            linkField.setScreenOpenType(WindowManager.OpenType.NEW_TAB);
            linkField.setCaption(messages.getTools().getPropertyCaption(datasource.getMetaClass(), "customer"));
            return linkField;
        });
    }
}