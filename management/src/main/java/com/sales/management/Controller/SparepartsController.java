package com.sales.management.Controller;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.DTO.SparepartsDTO;
import com.sales.management.Model.Spareparts;
import com.sales.management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/spareparts")
@RestController
public class SparepartsController {

    @Autowired
    private UserService userService;

    @PostMapping("/addspareparts")
    public BaseResponse addspareparts(@RequestBody SparepartsDTO sparepartsDTO) {
        return userService.addspareparts(sparepartsDTO);
    }

   @GetMapping("/pagination/{offset}/{pageSize}/{sparepartsName}")
   private APIResponse<Spareparts> getSparepartsWithPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String sparepartsName) {
       return userService.getSparepartsWithPagination(offset, pageSize, sparepartsName);
   }


    @PutMapping("/updatespareparts")
    public BaseResponse updatespareparts(@RequestBody SparepartsDTO sparepartsDTO) {
        return userService.updatespareparts(sparepartsDTO);
    }

    @GetMapping("/sparepartsbyid/{id}")
    public BaseResponse<Spareparts> findsparepartsById(@PathVariable int id) {
        return userService.findsparepartsById(id);
    }

    @PutMapping("/deletespareparts")
    public BaseResponse deletespareparts(@RequestBody SparepartsDTO sparepartsDTO) {
        return userService.deletespareparts(sparepartsDTO);
    }

}
