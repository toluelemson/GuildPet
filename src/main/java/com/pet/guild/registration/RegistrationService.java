package com.pet.guild.registration;
import com.pet.guild.guilduser.GuildUser;
import com.pet.guild.guilduser.GuildUserRole;
import com.pet.guild.guilduser.GuildUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private GuildUserService guildUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        return guildUserService.signUpUser(
                new GuildUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        GuildUserRole.USER

                )
        );
    }
}
