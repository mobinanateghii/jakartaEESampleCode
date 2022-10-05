package com.example.catalog.JSF;

import com.example.catalog.servlet.CatalogItem;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SessionScoped - Serializable => use for particular user whit specific request
 */

@SessionScoped
@Named
public class CatalogItemFormBeanPro implements Serializable {
    private CatalogItem item = new CatalogItem();
    private List<CatalogItem> items = new ArrayList<>();

    public String addItem(){
        item.setId((long) (items.size() + 1));
        this.items.add(new CatalogItem(item.getName(), item.getDescription(), item.getId()));

        return "categoryFormProListJSF?face-redirect=true";
    }

    public CatalogItem getItem() {
        return item;
    }

    public void setItem(CatalogItem item) {
        this.item = item;
    }

    public List<CatalogItem> getItems() {
        return items;
    }

    public void setItems(List<CatalogItem> items) {
        this.items = items;
    }
}
