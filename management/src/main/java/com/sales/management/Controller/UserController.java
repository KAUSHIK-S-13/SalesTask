package com.sales.management.Controller;


import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.DTO.UserDTO;
import com.sales.management.Model.User;
import com.sales.management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public BaseResponse adduserdetail(@Valid @RequestBody UserDTO userDTO) {
        return userService.adduserdetail(userDTO);
    }


    @GetMapping("/pagination/{offset}/{pageSize}/{userName}")
     private APIResponse<User> getUserWithPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String userName) {
     return userService.getUserWithPagination(offset, pageSize, userName);
    }



    @PutMapping("/updateuser")
    public BaseResponse updateuser(@RequestBody UserDTO userDTO) {
        return userService.updateuser(userDTO);
    }

    @GetMapping("/userbyid/{id}")
    public BaseResponse<User> findByUserId(@PathVariable int id) {
        return userService.findByUserId(id);
    }

    @PutMapping("/deletesoft")
    public BaseResponse deletesoft(@RequestBody UserDTO userDTO) {
        return userService.deletesoft(userDTO);
    }




}
