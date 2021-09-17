package com.skimpybunnycompany.skimpybunny.service;

import com.skimpybunnycompany.skimpybunny.domain.ApplicationSettings;
import com.skimpybunnycompany.skimpybunny.repository.ApplicationSettingsRepository;
import com.skimpybunnycompany.skimpybunny.repository.UserRepository;
import com.skimpybunnycompany.skimpybunny.request.ApplicationSettingsRequest;
import com.skimpybunnycompany.skimpybunny.response.ApplicationSettingsResponse;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationSettingsService {

    @Autowired
    private final ApplicationSettingsRepository applicationSettingsRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public ApplicationSettingsService(ApplicationSettingsRepository applicationSettingsRepository, UserRepository userRepository) {
        this.applicationSettingsRepository = applicationSettingsRepository;
        this.userRepository = userRepository;
    }

    public Optional<ApplicationSettingsResponse> getApplicationSettings(String currentUserLogin) {
        String currentUserLoginID = userRepository.findOneByLogin(currentUserLogin).get().getId();
        Optional<ApplicationSettings> maybeUserApplicationSettings = applicationSettingsRepository.findOneByUserID(currentUserLoginID);
        if (maybeUserApplicationSettings.isEmpty()) {
            ApplicationSettings returnDefaultApplicationSettings = ApplicationSettings.returnDefaultApplicationSettings();
            returnDefaultApplicationSettings.setUserID(currentUserLoginID);

            maybeUserApplicationSettings = Optional.of(returnDefaultApplicationSettings);
        }

        ApplicationSettings userApplicationSettings = applicationSettingsRepository.save(maybeUserApplicationSettings.get());

        return Optional.of(new ApplicationSettingsResponse(userApplicationSettings));
    }

    public Optional<ApplicationSettingsResponse> patchApplicationSettings(
        ApplicationSettingsRequest applicationSettingsRequest,
        String currentUserLogin
    ) {
        ApplicationSettings applicationSettings = new ApplicationSettings(applicationSettingsRequest);
        prepareApplicationSettingsToUpdate(applicationSettings, currentUserLogin);
        ApplicationSettings userApplicationSettings = applicationSettingsRepository.save(applicationSettings);

        return Optional.of(new ApplicationSettingsResponse(userApplicationSettings));
    }

    private void prepareApplicationSettingsToUpdate(ApplicationSettings applicationSettings, String currentUserLogin) {
        applicationSettings.setUserID(userRepository.findOneByLogin(currentUserLogin).get().getId());

        if (applicationSettings.getColourScheme() == null) {
            applicationSettings.setColourScheme("default");
        }

        if (applicationSettings.getTimeZoneName() == null) {
            applicationSettings.setTimeZoneName("default");
        }
    }
}
