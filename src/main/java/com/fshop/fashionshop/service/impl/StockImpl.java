package com.fshop.fashionshop.service.impl;

import com.fshop.fashionshop.service.Stock;

import java.util.LinkedList;
import java.util.List;

public class StockImpl implements Stock {
    @Override
    public List<com.fshop.fashionshop.model.commons.Stock> getAll() {
        List<com.fshop.fashionshop.model.commons.Stock> objects = new LinkedList<>();
        objects.add(new com.fshop.fashionshop.model.commons.Stock());
        objects.add(new com.fshop.fashionshop.model.commons.Stock());
        objects.add(new com.fshop.fashionshop.model.commons.Stock());

        return objects;
    }
}
