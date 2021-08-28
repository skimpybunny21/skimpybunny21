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

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

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
}
