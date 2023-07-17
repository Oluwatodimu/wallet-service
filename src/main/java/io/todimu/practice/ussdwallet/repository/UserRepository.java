package io.todimu.practice.ussdwallet.repository;

import io.todimu.practice.ussdwallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmailIgnoreCase(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);
}
