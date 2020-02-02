CREATE TABLE blog_metadata (
    id SERIAL,
    title VARCHAR(200) NOT NULL,
    subtitle VARCHAR(500) NOT NULL,
    copyright VARCHAR (100),
    logo_credit VARCHAR(200)
);

CREATE TABLE article (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    body VARCHAR NOT NULL ,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    url VARCHAR(500),
    repository_url VARCHAR(500),
    is_publish BOOLEAN DEFAULT false
);

CREATE TABLE plus_one (
    id SERIAL,
    article_id INTEGER REFERENCES article,
    ip_address VARCHAR(45) NOT NULL
);

CREATE TABLE "user" (
    id SERIAL,
    username VARCHAR(200) NOT NULL,
    password VARCHAR NOT NULL
);

