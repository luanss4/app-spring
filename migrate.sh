#!/bin/bash

# Espere até que o banco de dados esteja pronto
./wait-for-it.sh postgres:5432 --timeout=60 --strict -- echo "Banco de dados pronto!"

# Execute as migrações do Flyway
flyway migrate