package com.skimpybunnycompany.skimpybunny.apivalidator;

import com.skimpybunnycompany.skimpybunny.enums.CurrencyName;
import com.skimpybunnycompany.skimpybunny.enums.LanguageName;
import com.skimpybunnycompany.skimpybunny.enums.ThemeName;
import com.skimpybunnycompany.skimpybunny.exception.ApiRequestException;
import com.skimpybunnycompany.skimpybunny.request.ApplicationSettingsRequest;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ApiApplicationSettingsValidatorImpl")
public class ApiApplicationSettingsValidatorImpl implements ApiApplicationSettingsValidator {

    public void checkValidRequestApplicationSettings(ApplicationSettingsRequest applicationSettingsRequest) {
        checkValidLanguageName(applicationSettingsRequest.getLanguageName());
        checkValidCurrencyName(applicationSettingsRequest.getCurrencyName());
        checkValidThemeName(applicationSettingsRequest.getThemeName());
    }

    private void checkValidThemeName(String requestThemeName) {
        if (!EnumUtils.isValidEnum(LanguageName.class, requestThemeName)) {
            throw new ApiRequestException(
                requestThemeName + "isn't valid for value of ThemeName. Possible options are: " + ThemeName.values()
            );
        }
    }

    private void checkValidCurrencyName(String requestCurrencyName) {
        if (!EnumUtils.isValidEnum(LanguageName.class, requestCurrencyName)) {
            throw new ApiRequestException(
                requestCurrencyName + "isn't valid for value of CurrencyName. Possible options are: " + CurrencyName.values()
            );
        }
    }

    private void checkValidLanguageName(String requestLanguageName) {
        if (!EnumUtils.isValidEnum(LanguageName.class, requestLanguageName)) {
            throw new ApiRequestException(
                requestLanguageName + "isn't valid for value of LanguageName. Possible options are: " + LanguageName.values()
            );
        }
    }
}
