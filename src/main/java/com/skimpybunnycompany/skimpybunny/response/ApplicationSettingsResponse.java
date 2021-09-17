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

    public ApplicationSettingsResponse(ApplicationSettings as) {
        this.themeName = as.getThemeName();
        this.currencyName = as.getCurrencyName();
        this.languageName = as.getLanguageName();
    }

    public ApplicationSettingsResponse() {}

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
            '}'
        );
    }
}
