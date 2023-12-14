package com.handle.client;


import lombok.extern.slf4j.Slf4j;
import org.example.common.dto.OrderResponseDTO;
import org.example.common.exception.SwiggyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RestaurantServiceClient {
    @Autowired
    private RestTemplate template;

    @Value("${url.restaurant-service}")
    private String restaurantServiceUrl;

    public OrderResponseDTO fetchOrderStatus(String orderId) {
        OrderResponseDTO orderResponseDTO=null;
        try {
            orderResponseDTO= template.getForObject(restaurantServiceUrl + orderId, OrderResponseDTO.class);

        } catch (HttpServerErrorException errorException) {
            log.error("RestaurantServiceClient::fetchOrderStatus caught the HttpServer server error {}", errorException.getResponseBodyAsString());
            throw new SwiggyServiceException(errorException.getResponseBodyAsString());
        } catch (Exception ex) {
            log.error("RestaurantServiceClient::fetchOrderStatus caught the generic error {}", ex.getMessage());

        }
        return orderResponseDTO;
    }
}
