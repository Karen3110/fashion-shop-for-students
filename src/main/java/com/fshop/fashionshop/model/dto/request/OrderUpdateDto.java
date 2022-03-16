package com.fshop.fashionshop.model.dto.request;

import com.fshop.fashionshop.model.commons.enums.OrderStatus;
import lombok.Data;
import lombok.ToString;
import lombok.Value;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@ToString
public class OrderUpdateDto {

    private Integer count;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
