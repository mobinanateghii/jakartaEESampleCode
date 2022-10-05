package com.example.catalog.JSF;

import com.example.catalog.servlet.CatalogItem;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SessionScoped - Serializable => use for particular user whit specific request
 */

@RequestScoped
@Named
public class CatalogItemDeleteBeanPro {
    private String itemId;
    private CatalogItem item;

    @Inject
    private CatalogItemFormBeanPro catalogItemFormBeanPro;


    public void fetchItem() {
        List<CatalogItem> items = catalogItemFormBeanPro.getItems().stream().filter(i -> {
            return i.getId().equals(Long.valueOf(itemId));
        }).collect(Collectors.toList());

        if (items.isEmpty()) {
            item = null;
        } else {
            item = items.get(0);
        }
    }

    public String removeItem() {
        this.catalogItemFormBeanPro.getItems().removeIf(i -> {
                    return i.getId().equals(Long.valueOf(itemId));
                });
        return "categoryFormProListJSF?face-redirect=true";
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public CatalogItem getItem() {
        return item;
    }

    public void setItem(CatalogItem item) {
        this.item = item;
    }

}
