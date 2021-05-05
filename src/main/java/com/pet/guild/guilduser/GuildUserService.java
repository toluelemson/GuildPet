package com.pet.guild.guilduser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuildUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "Guild User with email %s not found";

    private final GuildUserRepository guildUserRepository = null;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return guildUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

}
