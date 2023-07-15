package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.BaseUserService;
import com.alumni.entity.BaseUser;
import com.alumni.entity.Role;
import com.alumni.repository.BaseUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BaseUserServiceImpl implements BaseUserService {

    private final BaseUserRepository repository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public BaseUser save(BaseUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));



        return repository.save(user);
    }

    @Override
    public BaseUser save(String email, String password, List<Role> roles) {

        BaseUser baseUser = new BaseUser();
        baseUser.setEmail(email);
        baseUser.setPassword(bCryptPasswordEncoder.encode(password));
        baseUser.setActiveAfter(LocalDateTime.now());
        baseUser.setActive(true);
        baseUser.setFailedLoginAttempts(0);
        baseUser.setRoles(roles);

        return repository.save(baseUser);
    }

    @Override
    public void changePassword(BaseUser user, String password) {
        user.setPassword(bCryptPasswordEncoder.encode(password));
        repository.save(user);
    }

    public BaseUser getUserByEmailAndPassword(String email, String password) throws NotFoundException {
        BaseUser user = repository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new NotFoundException("Invalid id and password");
        }
        return user;
    }

    @Override
    public BaseUser getByEmail(String email) throws NotFoundException {
        Optional<BaseUser> user = repository.findByEmail(email);
        if (user.isEmpty()) {
            throw new NotFoundException("Invalid id and password");
        }
        return user.get();
    }


    @Override
    public UserDetailsService userDetailsService() {
        return email -> {
            Optional<BaseUser> user = repository.findByEmail(email);
            if (user.isEmpty()) {
                throw new NotFoundException("Invalid id and password");
            }
            return user.get();
        };
    }
}
