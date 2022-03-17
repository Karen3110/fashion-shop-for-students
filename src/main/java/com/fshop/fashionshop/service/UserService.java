package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.User;
import com.fshop.fashionshop.model.dto.requestDto.OrderUpdateReqDto;

import java.util.List;

public interface UserService {
    User create(User user);

    User getById(String id);

    List<User> getAll();

    void delete(String id);
}
