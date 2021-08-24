CREATE TABLE IF NOT EXISTS Users (
    userID UUID DEFAULT uuid_generate_v4 (),
    email varchar(100)   NOT NULL,
    passwordHash varchar(200)   NOT NULL,
    isPaidSubscription Boolean   NOT NULL,
    isAdmin Boolean   NOT NULL,
    CONSTRAINT pk_Users PRIMARY KEY (
        userID
     )
);

CREATE TABLE IF NOT EXISTS  Transactions (
    transactionID UUID  DEFAULT uuid_generate_v4 (),
    userID UUID   NOT NULL,
    amount decimal   NOT NULL,
    transactionDate date   NOT NULL,
    isActive Boolean   NOT NULL,
    CONSTRAINT pk_Transactions PRIMARY KEY (
        transactionID
     )
);

CREATE TABLE IF NOT EXISTS  APIs (
    apiID UUID  DEFAULT uuid_generate_v4 (),
    userID UUID   NOT NULL,
    name varchar(200)   NOT NULL,
    url varchar(500)   NOT NULL,
    token varchar(200)   NOT NULL,
    CONSTRAINT pk_APIs PRIMARY KEY (
        apiID
     )
);


CREATE TABLE IF NOT EXISTS  Currencies (
    currencyName varchar(10)   NOT NULL,
    CONSTRAINT pk_Currencies PRIMARY KEY (
        currencyName
     )
);

CREATE TABLE IF NOT EXISTS  TimeZones (
    timeZoneName varchar(200)   NOT NULL,
    CONSTRAINT pk_TimeZones PRIMARY KEY (
        timeZoneName
     )
);

CREATE TABLE IF NOT EXISTS  Themes (
    themeName varchar(200)   NOT NULL,
    CONSTRAINT pk_Themes PRIMARY KEY (
        themeName
     )
);

CREATE TABLE IF NOT EXISTS  ApplicationSettings (
    userID UUID   NOT NULL,
    colourScheme varchar(200)   NOT NULL,
    languageName varchar(200)   NOT NULL,
    currencyName varchar(10)   NOT NULL,
    timeZoneName varchar(200)   NOT NULL,
    themeName varchar(200)   NOT NULL,
    isNotificationActive Boolean   NOT NULL,
    isActiveEmailRaport Boolean   NOT NULL
);

CREATE TABLE IF NOT EXISTS  Languages (
    languageName varchar(200)   NOT NULL,
    CONSTRAINT pk_Languages PRIMARY KEY (
        languageName
     )
);

ALTER TABLE Transactions ADD CONSTRAINT fk_Transactions_userID FOREIGN KEY(userID)
REFERENCES Users (userID);

ALTER TABLE APIs ADD CONSTRAINT fk_APIs_userID FOREIGN KEY(userID)
REFERENCES Users (userID);

ALTER TABLE ApplicationSettings ADD CONSTRAINT fk_ApplicationSettings_userID FOREIGN KEY(userID)
REFERENCES Users (userID);

ALTER TABLE ApplicationSettings ADD CONSTRAINT fk_ApplicationSettings_languageName FOREIGN KEY(languageName)
REFERENCES Languages (languageName);

ALTER TABLE ApplicationSettings ADD CONSTRAINT fk_ApplicationSettings_currencyName FOREIGN KEY(currencyName)
REFERENCES Currencies (currencyName);

ALTER TABLE ApplicationSettings ADD CONSTRAINT fk_ApplicationSettings_timeZoneName FOREIGN KEY(timeZoneName)
REFERENCES TimeZones (timeZoneName);

ALTER TABLE ApplicationSettings ADD CONSTRAINT fk_ApplicationSettings_themeName FOREIGN KEY(themeName)
REFERENCES Themes (themeName);

