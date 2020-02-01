CREATE TABLE article (
    id            SERIAL,
    title         varchar(200),
    body          varchar ,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    url           varchar(500)
    repository_url varchar(500)
);

CREATE TABLE like (
    id SERIAL
    article_id INTEGER
    ip_address varchar(45)
    FOREIGN KEY (article_id) REFERENCES article (id)
)

