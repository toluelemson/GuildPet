package com.pet.guild.registration;
import com.pet.guild.guilduser.GuildUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final GuildUserService guildUserService;

    public String register(RegistrationRequest request) {
        return "works";
    }
}
