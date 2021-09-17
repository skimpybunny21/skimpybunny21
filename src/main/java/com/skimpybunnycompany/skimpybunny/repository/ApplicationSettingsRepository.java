package com.skimpybunnycompany.skimpybunny.repository;

import com.skimpybunnycompany.skimpybunny.domain.ApplicationSettings;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationSettingsRepository extends JpaRepository<ApplicationSettings, String> {
    Optional<ApplicationSettings> findOneByUserID(String userID);
}
