CREATE TABLE IF NOT EXISTS users(
	id INT NOT NULL auto_increment,
	full_name varchar(255),
	email varchar(255),
	PRIMARY KEY (id)
);