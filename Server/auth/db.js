const pgp = require('pg-promise')();

const connectionString = `postgres://postgres:123@host.docker.internal:5432/testdb`; // Replace with your credentials
// postgres://postgres:123@jdbc:postgresql://localhost:5432/testdb
const pool = pgp(connectionString);

module.exports = pool;
