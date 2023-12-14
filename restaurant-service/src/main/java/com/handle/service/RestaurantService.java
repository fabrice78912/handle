package com.handle.service;

import com.handle.dao.RestaurantOrderDAO;
import lombok.extern.slf4j.Slf4j;
import org.example.common.dto.GlobalErrorCode;
import org.example.common.dto.OrderResponseDTO;
import org.example.common.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class RestaurantService {

    @Autowired
    private RestaurantOrderDAO orderDAO;

    public RestaurantService(RestaurantOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public String greeting() {
        return "Welcome to Swiggy Restaurant service";
    }

    public OrderResponseDTO getOrder(String orderId) {
        log.info("appel methoe getorder by id");
        OrderResponseDTO orderResponseDTO = orderDAO.getOrder(orderId);
        if (orderResponseDTO != null) {
            return orderResponseDTO;
        } else {
            throw new OrderNotFoundException("Order not available with id :" + orderId);
        }
    }
}
