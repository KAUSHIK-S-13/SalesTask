package com.sales.management.Service;


import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.DTO.OrderDTO;
import com.sales.management.DTO.SparepartsDTO;
import com.sales.management.DTO.SparepartstypeDTO;
import com.sales.management.DTO.UserDTO;
import com.sales.management.Model.Order;
import com.sales.management.Model.Spareparts;
import com.sales.management.Model.Sparepartstype;
import com.sales.management.Model.User;
import com.sales.management.Repository.OrderRepository;
import com.sales.management.Repository.SparepartsRepository;
import com.sales.management.Repository.SparepartstypeRepository;
import com.sales.management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Service
@Transactional

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SparepartsRepository sparepartsRepository;

    @Autowired
    private SparepartstypeRepository sparepartstypeRepository;

    @Autowired
    private OrderRepository orderRepository;

    public BaseResponse adduserdetail(UserDTO userDTO) {
        User user = new User();
        BaseResponse baseResponse = new BaseResponse();
        user.setUserName(userDTO.getUserName());
        user.setPassWord(userDTO.getPassWord());
        user.setIsActive(userDTO.getIsActive());
        user.setIsDelete(userDTO.getIsDelete());
        user.setCreateDateTime(new Timestamp(new java.util.Date().getTime()));
        user.setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        userRepository.save(user);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(user);
        return baseResponse;
    }

    public APIResponse<User> getUserWithPagination(int offset, int pageSize, String userName) {
        Pageable paging=PageRequest.of(offset, pageSize);
        Page<User> Users = userRepository.searchAllByUserNameLike("%" + userName + "%", paging);
        APIResponse apiResponse=new APIResponse();
        apiResponse.setResponse(Users);
        apiResponse.setRecordCount(Users.getTotalPages());
        return apiResponse;
      }



    public BaseResponse updateuser(UserDTO userDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<User> existUser = userRepository.findById(userDTO.getUserId());
        existUser.get().setUserName(userDTO.getUserName());
        existUser.get().setPassWord(userDTO.getPassWord());
        existUser.get().setIsActive(userDTO.getIsActive());
        existUser.get().setIsDelete(userDTO.getIsDelete());
        existUser.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        userRepository.save(existUser.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(existUser);
        return baseResponse;
    }

    public BaseResponse<User> findByUserId(int id) {
        Optional<User> users=userRepository.findById(id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(users);
        return baseResponse;
    }

    public BaseResponse deletesoft(UserDTO userDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<User> existUser = userRepository.findById(userDTO.getUserId());
        existUser.get().setIsDelete(1);
        existUser.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        userRepository.save(existUser.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(existUser);
        return baseResponse;
    }

    public BaseResponse addspareparts(SparepartsDTO sparepartsDTO) {
        Spareparts spareparts = new Spareparts();
        BaseResponse baseResponse = new BaseResponse();
        spareparts.setSparepartsName(sparepartsDTO.getSparepartsName());
        spareparts.setIsActive(sparepartsDTO.getIsActive());
        spareparts.setIsDelete(sparepartsDTO.getIsDelete());
        spareparts.setCreateDateTime(new Timestamp(new java.util.Date().getTime()));
        spareparts.setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        Optional<Sparepartstype> obj=sparepartstypeRepository.findBySparepartstypeId(sparepartsDTO.getSparepartstypeId());
        spareparts.setSparepartstypeId(obj.get());
        sparepartsRepository.save(spareparts);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(spareparts);
        return baseResponse;
    }

    public APIResponse<Spareparts> getSparepartsWithPagination(int offset, int pageSize, String sparepartsName) {
        Pageable paging=PageRequest.of(offset, pageSize);
        Page<Spareparts> Sparepartss = sparepartsRepository.searchAllBySparepartsNameLike("%" + sparepartsName + "%", paging);
        APIResponse apiResponse=new APIResponse();
        apiResponse.setResponse(Sparepartss);
        apiResponse.setRecordCount(Sparepartss.getTotalPages());
        return apiResponse;
    }

    public BaseResponse updatespareparts(SparepartsDTO sparepartsDTO) {
        Optional<Spareparts> existSpareparts= sparepartsRepository.findById(sparepartsDTO.getSparepartsId());
        BaseResponse baseResponse = new BaseResponse();
        existSpareparts.get().setSparepartsName(sparepartsDTO.getSparepartsName());
        existSpareparts.get().setIsActive(sparepartsDTO.getIsActive());
        existSpareparts.get().setIsDelete(sparepartsDTO.getIsDelete());
        existSpareparts.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        Optional<Sparepartstype> obj=sparepartstypeRepository.findBySparepartstypeId(sparepartsDTO.getSparepartstypeId());
        existSpareparts.get().setSparepartstypeId(obj.get());
        sparepartsRepository.save(existSpareparts.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(existSpareparts);
        return baseResponse;
    }

    public BaseResponse<Spareparts> findsparepartsById(int id) {
        Optional<Spareparts> Sparepartss=sparepartsRepository.findById(id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(Sparepartss);
        return baseResponse;
    }

    public BaseResponse deletespareparts(SparepartsDTO sparepartsDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Spareparts> existpareparts = sparepartsRepository.findById(sparepartsDTO.getSparepartsId());
        existpareparts.get().setIsDelete(1);
        existpareparts.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sparepartsRepository.save(existpareparts.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(existpareparts);
        return baseResponse;
    }

     public BaseResponse addsparepartstype(SparepartstypeDTO sparepartstypeDTO) {
        Sparepartstype sparepartstype = new Sparepartstype();
        BaseResponse baseResponse = new BaseResponse();
        sparepartstype.setSparepartstypeName(sparepartstypeDTO.getSparepartstypeName());
        sparepartstype.setIsActive(sparepartstypeDTO.getIsActive());
        sparepartstype.setIsDelete(sparepartstypeDTO.getIsDelete());
        sparepartstype.setCreateDateTime(new Timestamp(new java.util.Date().getTime()));
        sparepartstype.setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sparepartstypeRepository.save(sparepartstype);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(sparepartstype);
        return baseResponse;
    }

    public BaseResponse updatesparepartstype(SparepartstypeDTO sparepartstypeDTO) {
        Optional<Sparepartstype> existSparepartstype= sparepartstypeRepository.findById(sparepartstypeDTO.getSparepartstypeId());
        BaseResponse baseResponse = new BaseResponse();
        existSparepartstype.get().setSparepartstypeName(sparepartstypeDTO.getSparepartstypeName());
        existSparepartstype.get().setIsActive(sparepartstypeDTO.getIsActive());
        existSparepartstype.get().setIsDelete(sparepartstypeDTO.getIsDelete());
        existSparepartstype.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sparepartstypeRepository.save(existSparepartstype.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(existSparepartstype);
        return baseResponse;
    }

    public List<Sparepartstype> listAll() {
        return sparepartstypeRepository.findAll();
    }

    public BaseResponse deletesparepartstype(SparepartstypeDTO sparepartstypeDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Sparepartstype> existSparepartstype = sparepartstypeRepository.findById(sparepartstypeDTO.getSparepartstypeId());
        existSparepartstype.get().setIsDelete(1);
        existSparepartstype.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sparepartstypeRepository.save(existSparepartstype.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(existSparepartstype);
        return baseResponse;
    }

    public BaseResponse addorder(OrderDTO orderDTO) {
        Order order=new Order();
        order.setOrderQuantity(orderDTO.getOrderQuantity());
        order.setOrderDestination(orderDTO.getOrderDestination());
        Order finalOrder = order;
        orderDTO.getSparepartsId().stream().forEachOrdered(sparepartsDTO -> {
            Optional<Spareparts> sparepartss=sparepartsRepository.findBySparepartsId(sparepartsDTO.getSparepartsId());
            finalOrder.setSparepartss(sparepartss.get());
        });
        Order finalOrder1 = order;
        orderDTO.getUserId().stream().forEachOrdered(userDTO -> {
            Optional<User> Users=userRepository.findByUserId(userDTO.getUserId());
            finalOrder1.setUsers(Users.get());
        });
        order.setIsActive(orderDTO.getIsActive());
        order.setIsDelete(orderDTO.getIsDelete());
        order.setCreateDateTime(new Timestamp(new java.util.Date().getTime()));
        order.setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order=orderRepository.save(order);
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(order);
        return baseResponse;
    };


    public BaseResponse updateorder(OrderDTO orderDTO) {
        Optional<Order> existOrder= orderRepository.findById(orderDTO.getOrderId());
        existOrder.get().setOrderQuantity(orderDTO.getOrderQuantity());
        existOrder.get().setOrderDestination(orderDTO.getOrderDestination());
        orderDTO.getSparepartsId().stream().forEachOrdered(sparepartsDTO -> {
            Optional<Spareparts> sparepartss=sparepartsRepository.findBySparepartsId(sparepartsDTO.getSparepartsId());
            existOrder.get().setSparepartss(sparepartss.get());
        });
        orderDTO.getUserId().stream().forEachOrdered(userDTO -> {
            Optional<User> Users=userRepository.findByUserId(userDTO.getUserId());
            existOrder.get().setUsers(Users.get());
        });
        existOrder.get().setIsActive(orderDTO.getIsActive());
        existOrder.get().setIsDelete(orderDTO.getIsDelete());
        existOrder.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        orderRepository.save(existOrder.get());
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(existOrder);
        return baseResponse;
    };

    public List<Order> getAllorder() {
        return orderRepository.findAll();
    }

    public BaseResponse deleteorder(OrderDTO orderDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Order> existOrder= orderRepository.findById(orderDTO.getOrderId());
        existOrder.get().setIsDelete(1);
        existOrder.get().setUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        orderRepository.save(existOrder.get());
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(existOrder);
        return baseResponse;
    }







}
