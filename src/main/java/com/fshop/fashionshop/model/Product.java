package com.fshop.fashionshop.model;

import com.fshop.fashionshop.model.commons.Description;
import com.fshop.fashionshop.model.commons.Image;
import com.fshop.fashionshop.model.commons.Stock;
import com.fshop.fashionshop.model.commons.enums.Currency;
import com.fshop.fashionshop.model.commons.enums.OrderStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Float price;

    @OneToOne(cascade = CascadeType.ALL)
    private Description description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToOne(cascade = CascadeType.ALL)
    private Stock stock;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> img;


    public void updateStock(OrderStatus oldStatus, OrderStatus newStatus, int count) {

        switch (oldStatus) {
            case UNPAID:
                if (newStatus == OrderStatus.PAID) {
                    Stock stock = this.getStock();
                    stock.setCount(stock.getCount() - count);
                }
                break;
            case PAID:
            case PENDING:
            case SENT:
            case DONE:

                break;
        }

        if (stock.getCount() == 0) {
            stock.setIsAvailable(false);
        }
    }

}
