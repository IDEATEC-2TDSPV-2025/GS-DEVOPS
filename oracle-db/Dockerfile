FROM container-registry.oracle.com/database/express:21.3.0-xe

USER oracle
WORKDIR /opt/oracle/scripts/setup

# Copia o script SQL para inicialização automática
COPY setup.sql .

ENV ORACLE_PWD=Oracle123 \
    ORACLE_ALLOW_REMOTE=true

EXPOSE 1521