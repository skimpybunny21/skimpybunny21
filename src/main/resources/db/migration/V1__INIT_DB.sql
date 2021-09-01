
-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/6ukfXq
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


CREATE TABLE "transactions" (
    "transaction_id" varchar(100)   NOT NULL,
    "user_id" varchar(100)   NOT NULL,
    "name" varchar(200)   NOT NULL,
    "amount" decimal   NOT NULL,
    "transaction_date" date   NOT NULL,
    "is_active" Boolean   NOT NULL,
    "category" varchar(200)   NOT NULL,
    "contractor" varchar(200)   NOT NULL,
    CONSTRAINT "pk_transactions" PRIMARY KEY (
        "transaction_id"
     )
);

CREATE TABLE "apis" (
    "api_id" varchar(100)   NOT NULL,
    "user_id" varchar(100)   NOT NULL,
    "name" varchar(200)   NOT NULL,
    "url" varchar(500)   NOT NULL,
    "token" varchar(200)   NOT NULL,
    CONSTRAINT "pk_apis" PRIMARY KEY (
        "api_id"
     )
);

CREATE TABLE "application_settings" (
    "user_id" varchar(100)   NOT NULL,
    "colour_scheme" varchar(200)   NOT NULL,
    "language_name" varchar(200)   NOT NULL,
    "currency_name" varchar(10)   NOT NULL,
    "time_zone_name" varchar(200)   NOT NULL,
    "theme_name" varchar(200)   NOT NULL,
    "is_notification_active" Boolean   NOT NULL,
    "is_active_email_raport" Boolean   NOT NULL,
    "is_paid_subscription" Boolean   NOT NULL
);


ALTER TABLE "transactions" ADD CONSTRAINT "fk_transactions_user_id" FOREIGN KEY("user_id")
REFERENCES "jhi_user" ("id");

ALTER TABLE "apis" ADD CONSTRAINT "fk_apis_user_id" FOREIGN KEY("user_id")
REFERENCES "jhi_user" ("id");

ALTER TABLE "application_settings" ADD CONSTRAINT "fk_application_settings_user_id" FOREIGN KEY("user_id")
REFERENCES "jhi_user" ("id");

-- ALTER TABLE "jhi_user_authority" ADD CONSTRAINT "fk_jhi_user_authority_user_id" FOREIGN KEY("user_id")
-- REFERENCES "jhi_user" ("id");

