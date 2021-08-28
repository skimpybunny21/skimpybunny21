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
@Table(name = "APIs", schema = "app_db")
public class APIs {

    @Id
    @Size(max = 100)
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "api_id", nullable = false)
    private String apiID;

    @Size(max = 100)
    @Column(name = "user_id")
    private String userID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @NotNull
    @Size(max = 200)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 500)
    @Column(name = "url")
    private String url;

    @NotNull
    @Size(max = 200)
    @Column(name = "token")
    private String token;
}
