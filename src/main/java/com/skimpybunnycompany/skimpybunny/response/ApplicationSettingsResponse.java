package com.skimpybunnycompany.skimpybunny.response;

import com.skimpybunnycompany.skimpybunny.domain.ApplicationSettings;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "ApplicationSettings model", value = "ApplicationSettings")
@Getter
@Setter
@ToString
public class ApplicationSettingsResponse {

    @ApiModelProperty(value = "Theme of page", position = 2, example = "WHITE, BLACK")
    private String theme_name;

    @ApiModelProperty(value = "Language of page", position = 3, example = "EN, PL")
    private String language_name;

    @ApiModelProperty(value = "Currency name for transactions", position = 4, example = "PLN, EUR, USD")
    private String currency_name;

    @ApiModelProperty(value = "isNotificationActive", position = 4, example = "true or false")
    private Boolean is_notification_active;

    @ApiModelProperty(value = "isActiveEmailRaport", position = 4, example = "true or false")
    private Boolean is_active_email_raport;

    @ApiModelProperty(value = "isPaidSubscription", position = 4, example = "true or false")
    private Boolean is_paid_subscription;

    public ApplicationSettingsResponse(ApplicationSettings as) {
        this.theme_name = as.getThemeName();
        this.currency_name = as.getCurrencyName();
        this.language_name = as.getLanguageName();
        this.is_notification_active = as.getNotificationActive();
        this.is_active_email_raport = as.getActiveEmailRaport();
        this.is_paid_subscription = as.getPaidSubscription();
    }

    public ApplicationSettingsResponse() {}

    public String getTheme_name() {
        return theme_name;
    }

    public void setTheme_name(String theme_name) {
        this.theme_name = theme_name;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public Boolean getIs_notification_active() {
        return is_notification_active;
    }

    public void setIs_notification_active(Boolean is_notification_active) {
        this.is_notification_active = is_notification_active;
    }

    public Boolean getIs_active_email_raport() {
        return is_active_email_raport;
    }

    public void setIs_active_email_raport(Boolean is_active_email_raport) {
        this.is_active_email_raport = is_active_email_raport;
    }

    public Boolean getIs_paid_subscription() {
        return is_paid_subscription;
    }

    public void setIs_paid_subscription(Boolean is_paid_subscription) {
        this.is_paid_subscription = is_paid_subscription;
    }

    @Override
    public String toString() {
        return (
            "ApplicationSettingsResponse{" +
            "themeName='" +
            theme_name +
            '\'' +
            ", languageName='" +
            language_name +
            '\'' +
            ", currencyName='" +
            currency_name +
            '\'' +
            ", isNotificationActive=" +
            is_notification_active +
            ", isActiveEmailRaport=" +
            is_active_email_raport +
            ", isPaidSubscription=" +
            is_paid_subscription +
            '}'
        );
    }
}
