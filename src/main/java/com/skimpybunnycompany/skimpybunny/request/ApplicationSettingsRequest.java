package com.skimpybunnycompany.skimpybunny.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationSettingsRequest {

    @JsonProperty("language_name")
    private String languageName;

    @JsonProperty("currency_name")
    private String currencyName;

    @JsonProperty("colour_scheme")
    private String colourName;

    @JsonProperty("is_active_email_raport")
    private Boolean isActiveEmailRaport;

    @JsonProperty("is_paid_subscription")
    private Boolean isPaidSubscription;

    @JsonProperty("is_notification_active")
    private Boolean isNotificationActive;

    @JsonProperty("theme_name")
    private String themeName;

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    public Boolean isActiveEmailRaport() {
        return isActiveEmailRaport;
    }

    public void setActiveEmailRaport(boolean activeEmailRaport) {
        isActiveEmailRaport = activeEmailRaport;
    }

    public Boolean getIsPaidSubscription() {
        return isPaidSubscription;
    }

    public void setIsPaidSubscription(Boolean isPaidSubscription) {
        this.isPaidSubscription = isPaidSubscription;
    }

    public boolean getIsNotificationActive() {
        return isNotificationActive;
    }

    public void setIsNotificationActive(Boolean isNotificationActive) {
        this.isNotificationActive = isNotificationActive;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}
