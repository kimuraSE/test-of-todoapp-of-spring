CREATE TABLE users (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE tasks (
  id SERIAL,
  summary VARCHAR(256) NOT NULL,
  description TEXT,
  status VARCHAR(256) NOT NULL,
  PRIMARY KEY(id)
)
