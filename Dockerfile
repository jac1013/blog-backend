FROM postgres:alpine

COPY ./src/dev/codecarver/repository/postgresql/schema.sql /docker-entrypoint-initdb.d/
