package com.example.socialmedia.service;
import com.example.socialmedia.dal.DataAccessLayer;
import com.example.socialmedia.dto.SignupRequest;
import com.example.socialmedia.models.User;
import com.example.socialmedia.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public UserDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }
    public String newUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUserName(signupRequest.getUserName());
        user.setPassword(signupRequest.getPassword());
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setAddress(signupRequest.getAddress());
        user.setEmail(signupRequest.getEmail());
        return dataAccessLayer.newUserToDatabase(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dataAccessLayer.getUserFromDatabaseByUsername(username);
        if (user == null) return null;
        return UserDetailsImpl.build(user);
    }
    public User loadUserEntityByUsername(String username) throws UsernameNotFoundException {
        return dataAccessLayer.getUserFromDatabaseByUsername(username);
    }
}
