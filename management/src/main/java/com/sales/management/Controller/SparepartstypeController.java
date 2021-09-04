package com.sales.management.Controller;

import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.DTO.SparepartstypeDTO;
import com.sales.management.DTO.UserDTO;
import com.sales.management.Model.Sparepartstype;
import com.sales.management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sparepartstype")
@RestController
public class SparepartstypeController {

    @Autowired
    private UserService userService;

    @PostMapping("/addsparepartstype")
    public BaseResponse addsparepartstype(@RequestBody SparepartstypeDTO sparepartstypeDTO) {
        return userService.addsparepartstype(sparepartstypeDTO);
    }

    @PutMapping("/updatesparepartstype")
    public BaseResponse updatesparepartstype(@RequestBody SparepartstypeDTO sparepartstypeDTO) {
        return userService.updatesparepartstype(sparepartstypeDTO);
    }

    @GetMapping("/getAllsparepartstype")
    public List<Sparepartstype> list(){
        return userService.listAll();
    }

    @PutMapping("/deletesparepartstype")
    public BaseResponse deletesparepartstype(@RequestBody SparepartstypeDTO sparepartstypeDTO) {
        return userService.deletesparepartstype(sparepartstypeDTO);
    }
}
