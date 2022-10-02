package com.example.catalog.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
    public static Map<String, CatalogItem> catalogItemMap = new HashMap<>();

    public static void addItem(CatalogItem item){
        catalogItemMap.put(item.getId(), item);
    }

    public static CatalogItem getItem(String id){
        return catalogItemMap.get(id);
    }

    public static List<CatalogItem> getItems(){
        return new ArrayList<CatalogItem>(catalogItemMap.values());
    }
}
