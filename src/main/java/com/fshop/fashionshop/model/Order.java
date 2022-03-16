//package com.fshop.fashionshop.model;
//
//import com.fshop.fashionshop.model.commons.enums.OrderStatus;
//import lombok.Data;
//import lombok.ToString;
//
//import javax.persistence.*;
//
//@Data
//@ToString
//@Entity
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private Long date;
//
//    @OneToOne
//    private Product product;
//
//    @Enumerated(EnumType.STRING)
//    private OrderStatus orderStatus;
//}
