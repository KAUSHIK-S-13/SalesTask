package com.sales.management.Controller;

import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.DTO.OrderDTO;
import com.sales.management.DTO.SparepartstypeDTO;
import com.sales.management.DTO.UserDTO;
import com.sales.management.Model.Order;
import com.sales.management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private UserService userService;

    @PostMapping("/addorder")
    public BaseResponse addorder(@RequestBody OrderDTO orderDTO) {
        return userService.addorder(orderDTO);
    }
    @PutMapping("/updateorder")
    public BaseResponse updateorder(@RequestBody OrderDTO orderDTO) {
        return userService.updateorder(orderDTO);
    }
    @GetMapping("/getAllorder")
    public List<Order> list(){
        return userService.getAllorder();
    }

    @PutMapping("/deleteorder")
    public BaseResponse deleteorder(@RequestBody  OrderDTO orderDTO) {
        return userService.deleteorder(orderDTO);
    }

}
