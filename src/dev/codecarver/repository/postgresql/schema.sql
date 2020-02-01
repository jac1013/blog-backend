CREATE TABLE article (
    id            SERIAL,
    title         varchar(200),
    body          varchar ,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    url           varchar(500)
    repository_url varchar(500)
);
