package com.pet.guild.guilduser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface GuildUserRepository
        extends JpaRepository<GuildUser, Long> {

    Optional<GuildUser> findByEmail(String email);

}
