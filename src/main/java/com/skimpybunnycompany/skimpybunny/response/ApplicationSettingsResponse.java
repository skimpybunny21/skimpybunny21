package com.skimpybunnycompany.skimpybunny.response;

import static tech.jhipster.config.JHipsterDefaults.ApiDocs.description;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String themeName;

    @ApiModelProperty(value = "Language of page", position = 3, example = "EN, PL")
    private String languageName;

    @ApiModelProperty(value = "Currency name for transactions", position = 4, example = "PLN, EUR, USD")
    private String currencyName;

    @ApiModelProperty(value = "isNotificationActive", position = 4, example = "true or false")
    private Boolean isNotificationActive;

    @ApiModelProperty(value = "isActiveEmailRaport", position = 4, example = "true or false")
    private Boolean isActiveEmailRaport;

    @ApiModelProperty(value = "isPaidSubscription", position = 4, example = "true or false")
    private Boolean isPaidSubscription;

    public ApplicationSettingsResponse(ApplicationSettings as) {
        this.themeName = as.getThemeName();
        this.currencyName = as.getCurrencyName();
        this.languageName = as.getLanguageName();
        this.isNotificationActive = as.getNotificationActive();
        this.isActiveEmailRaport = as.getActiveEmailRaport();
        this.isPaidSubscription = as.getPaidSubscription();
    }

    public ApplicationSettingsResponse() {}

    public Boolean getNotificationActive() {
        return isNotificationActive;
    }

    public void setNotificationActive(Boolean notificationActive) {
        isNotificationActive = notificationActive;
    }

    public Boolean getActiveEmailRaport() {
        return isActiveEmailRaport;
    }

    public void setActiveEmailRaport(Boolean activeEmailRaport) {
        isActiveEmailRaport = activeEmailRaport;
    }

    public Boolean getPaidSubscription() {
        return isPaidSubscription;
    }

    public void setPaidSubscription(Boolean paidSubscription) {
        isPaidSubscription = paidSubscription;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
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

    @Override
    public String toString() {
        return (
            "ApplicationSettingsResponse{" +
            "themeName='" +
            themeName +
            '\'' +
            ", languageName='" +
            languageName +
            '\'' +
            ", currencyName='" +
            currencyName +
            '\'' +
            ", isNotificationActive=" +
            isNotificationActive +
            ", isActiveEmailRaport=" +
            isActiveEmailRaport +
            ", isPaidSubscription=" +
            isPaidSubscription +
            '}'
        );
    }
}
