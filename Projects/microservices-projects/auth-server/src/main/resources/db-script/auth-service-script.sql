DROP DATABASE IF EXISTS auth-db;
CREATE DATABASE auth-db;
USE auth_db;

CREATE TABLE IF NOT EXISTS user_role(
	id int not null auto_increment,
	role varchar(250),
	PRIMARY KEY(id)
);

INSERT INTO user_role (role) SELECT role FROM (
	SELECT 'ROLE_ADMIN' as role
)  AS tmp where not exists(SELECT role FROM user_role WHERE role = 'ROLE_ADMIN');

INSERT INTO user_role (role) SELECT role FROM (
	SELECT 'ROLE_USER' as role
)  AS tmp where not exists(SELECT role FROM user_role WHERE role = 'ROLE_USER');

CREATE TABLE IF NOT EXISTS users(
	id INT NOT NULL auto_increment,
	full_name varchar(255),
	email varchar(255),
	password varchar(250),
	created_at DATE,
	updated_at DATE,
	role_id int,
	PRIMARY KEY (id),
	FOREIGN KEY (role_id) REFERENCES user_role(id)
);

CREATE TABLE IF NOT EXISTS user_address(
	id INT NOT NULL auto_increment,
	line1 varchar(500),
	line2 varchar(500),
	city varchar(50),
	state varchar(50),
	country varchar(50),
	pin_code varchar(10),
	user_id int,
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES users(id)
);
