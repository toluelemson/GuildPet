package com.pet.guild.registration;
import com.pet.guild.guilduser.GuildUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final GuildUserService appUserService;

    public RegistrationService(GuildUserService appUserService) {
        this.appUserService = appUserService;
    }

    public String register(RegistrationRequest request) {
        return "works";
    }
}
