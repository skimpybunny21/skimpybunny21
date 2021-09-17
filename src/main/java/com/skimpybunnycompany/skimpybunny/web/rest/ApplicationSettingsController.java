package com.skimpybunnycompany.skimpybunny.web.rest;

import com.skimpybunnycompany.skimpybunny.apivalidator.ApiApplicationSettingsValidator;
import com.skimpybunnycompany.skimpybunny.apivalidator.ApiTransactionsValidator;
import com.skimpybunnycompany.skimpybunny.request.ApplicationSettingsRequest;
import com.skimpybunnycompany.skimpybunny.response.ApplicationSettingsResponse;
import com.skimpybunnycompany.skimpybunny.security.SecurityUtils;
import com.skimpybunnycompany.skimpybunny.service.ApplicationSettingsService;
import io.swagger.annotations.Api;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "User application settings controller")
@RestController
@RequestMapping("/api/applicationsettings")
public class ApplicationSettingsController {

    @Autowired
    ApplicationSettingsService applicationSettingsService;

    @Autowired
    @Qualifier("ApiApplicationSettingsValidatorImpl")
    ApiApplicationSettingsValidator apiApplicationSettingsValidator;

    @Autowired
    public ApplicationSettingsController(
        ApplicationSettingsService applicationSettingsService,
        ApiApplicationSettingsValidator apiApplicationSettingsValidator
    ) {
        this.applicationSettingsService = applicationSettingsService;
        this.apiApplicationSettingsValidator = apiApplicationSettingsValidator;
    }

    @GetMapping("")
    public ResponseEntity<ApplicationSettingsResponse> getApplicationSettings(@RequestParam String userLogin) {
        String currentUserLogin = userLogin != null ? userLogin : SecurityUtils.getCurrentUserLogin().get();
        Optional<ApplicationSettingsResponse> applicationSettingsResponse = applicationSettingsService.getApplicationSettings(
            currentUserLogin
        );

        return applicationSettingsResponse
            .map(
                settingsResponse -> {
                    return new ResponseEntity<ApplicationSettingsResponse>(settingsResponse, HttpStatus.OK);
                }
            )
            .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PatchMapping("")
    public ResponseEntity<ApplicationSettingsResponse> patchApplicationSettings(
        @Valid @RequestBody(required = false) ApplicationSettingsRequest applicationSettingsRequest,
        @RequestParam String userLogin
    ) {
        apiApplicationSettingsValidator.checkValidRequestApplicationSettings(applicationSettingsRequest);
        String currentUserLogin = userLogin != null ? userLogin : SecurityUtils.getCurrentUserLogin().get();
        Optional<ApplicationSettingsResponse> applicationSettingsResponse = applicationSettingsService.patchApplicationSettings(
            applicationSettingsRequest,
            currentUserLogin
        );

        return applicationSettingsResponse
            .map(
                settingsResponse -> {
                    return new ResponseEntity<ApplicationSettingsResponse>(settingsResponse, HttpStatus.OK);
                }
            )
            .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
