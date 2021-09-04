package com.sales.management.Repository;

import com.sales.management.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {





    Page<User> searchAllByUserNameLike(String s, Pageable paging);

    Optional<User> findByUserId(int userId);



}
