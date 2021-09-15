package com.skimpybunnycompany.skimpybunny.service;

import com.skimpybunnycompany.skimpybunny.repository.ApplicationSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationSettingsService {

    @Autowired
    private final ApplicationSettingsRepository applicationSettingsRepository;

    @Autowired
    public ApplicationSettingsService(ApplicationSettingsRepository applicationSettingsRepository) {
        this.applicationSettingsRepository = applicationSettingsRepository;
    }
}
