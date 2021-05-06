package com.pet.guild.guilduser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GuildUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "Guild User with email %s not found";

    private final GuildUserRepository guildUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return guildUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(GuildUser guildUser) {

        Boolean userExists = guildUserRepository
                .findByEmail(guildUser.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(guildUser.getPassword());

        guildUser.setPassword(encodedPassword);
        guildUserRepository.save(guildUser);

        return "";
    }
}
