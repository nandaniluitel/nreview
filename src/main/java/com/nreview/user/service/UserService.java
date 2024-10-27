package com.nreview.user.service;

import com.nreview.user.InvalidDetailsException;
import com.nreview.user.domain.User;
import com.nreview.user.dto.UserDto;
import com.nreview.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private boolean isValidAge(Integer age) {
        if (age == null) {
            return false;
        }
        return age >= 18 && age <= 60;
    }

    private boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        return name.length() <= 60;
    }

    public void saveToDb(UserDto userDto) {
        if (!isValidAge(userDto.getAge())) {
            throw new InvalidDetailsException("Age must be between 18 and 16");
        } else if (!isValidName(userDto.getName())) {
            throw new InvalidDetailsException("Name cannot be this long");
        } else{
            User user= new User();
            user.setAge(userDto.getAge());
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setGender(userDto.getGender());
            userRepository.save(user);
        }
    }
}
