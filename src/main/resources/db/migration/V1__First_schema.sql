CREATE TABLE doodle_message (
  id BIGINT AUTO_INCREMENT,
  createdat TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  author VARCHAR(100) NOT NULL,
  message VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);
