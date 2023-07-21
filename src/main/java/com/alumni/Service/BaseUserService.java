package com.alumni.Service;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.dtos.request.BaseUseRequestrDTO;
import com.alumni.entity.BaseUser;
import com.alumni.entity.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseUserService {

    public BaseUser save(BaseUser user);

    public BaseUser save(BaseUser user, List<Role> roles);

    public BaseUser update(Long id, BaseUseRequestrDTO user);

    BaseUser save(String email, String password, List<Role> roles);

    BaseUser getUserByEmailAndPassword(String name, String password) throws NotFoundException;

    BaseUser getByEmail(String email);

    void changePassword(BaseUser user, String password);

    UserDetailsService userDetailsService();


    public Boolean isAdmin(BaseUser user);
    public Boolean isStudent(BaseUser user);
    public Boolean isFaculty(BaseUser user);

    }
