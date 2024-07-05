CREATE TABLE user_identity
(
    user_id          TEXT,
    username        TEXT         not null,
    password         TEXT        NOT NULL,
    confirm_password TEXT        NOT NULL,
    created_at       TIMESTAMPTZ NOT NULL default now(),
    modify_at        TIMESTAMPTZ NOT NULL default now(),
    CONSTRAINT unique_username UNIQUE (username),
    CONSTRAINT pk_login_id PRIMARY KEY (user_id)
);