package com.skimpybunnycompany.skimpybunny.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "application_settings", schema = "app_db")
public class ApplicationSettings {

    //    @Id
    //    @Column(name = "user_id")
    //    private String userID;
    @Id
    @Column(name = "user_id", nullable = false)
    private String userID;

    //    @ManyToOne(optional = false)
    //    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    //    private User user;

    @NotNull
    @Size(max = 200)
    @Column(name = "colour_scheme")
    private String colourScheme;

    @NotNull
    @Size(max = 200)
    @Column(name = "language_name")
    private String languageName;

    @NotNull
    @Size(max = 10)
    @Column(name = "currency_name")
    private String currencyName;

    @NotNull
    @Size(max = 200)
    @Column(name = "time_zone_name")
    private String timeZoneName;

    @NotNull
    @Size(max = 200)
    @Column(name = "theme_name")
    private String themeName;

    @NotNull
    @Column(name = "is_notification_active")
    private Boolean isNotificationActive;

    @NotNull
    @Column(name = "is_active_email_raport")
    private Boolean isActiveEmailRaport;

    @NotNull
    @Column(name = "is_paid_subscription")
    private Boolean isPaidSubscription;

    public ApplicationSettings() {}

    public ApplicationSettings(
        String userID,
        String colourScheme,
        String languageName,
        String currencyName,
        String timeZoneName,
        String themeName,
        Boolean isNotificationActive,
        Boolean isActiveEmailRaport,
        Boolean isPaidSubscription
    ) {
        this.userID = userID;
        this.colourScheme = colourScheme;
        this.languageName = languageName;
        this.currencyName = currencyName;
        this.timeZoneName = timeZoneName;
        this.themeName = themeName;
        this.isNotificationActive = isNotificationActive;
        this.isActiveEmailRaport = isActiveEmailRaport;
        this.isPaidSubscription = isPaidSubscription;
    }

    public static ApplicationSettings returnDefaultApplicationSettings() {
        return new ApplicationSettings(null, "default", "EN", "PLN", "default", "WHITE", true, true, false);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getColourScheme() {
        return colourScheme;
    }

    public void setColourScheme(String colourScheme) {
        this.colourScheme = colourScheme;
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

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

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
}
