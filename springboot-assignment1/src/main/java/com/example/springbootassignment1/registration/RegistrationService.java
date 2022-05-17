package com.example.springbootassignment1.registration;

import com.example.springbootassignment1.appuser.AppUser;
import com.example.springbootassignment1.appuser.AppUserRole;
import com.example.springbootassignment1.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("E-mail isn't valid!");
        }
        return appUserService.signUpUser(new AppUser(
                request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPassword(),
                AppUserRole.USER
        ));
    }
}
