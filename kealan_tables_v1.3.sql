CREATE TABLE charities (
	username VARCHAR(50) UNIQUE NOT NULL,
	name VARCHAR(100) UNIQUE NOT NULL,
	telephone VARCHAR(12),
	email VARCHAR(50) NOT NULL,
	address VARCHAR(255) NOT NULL,
	password VARCHAR(50) NOT NULL,
	id INT AUTO_INCREMENT,
	paypal_email VARCHAR(50),
	domain_url VARCHAR(50),
	verified_email BOOLEAN,
	salt VARCHAR(50) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE articles (
	id INT AUTO_INCREMENT,
	charity_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY(charity_id) REFERENCES charities(id)
);

CREATE TABLE donations (
	date DATETIME,
	amount INT NOT NULL,
	charity_id INT,
	PRIMARY KEY(charity_id, date),
	FOREIGN KEY(charity_id) REFERENCES charities(id)
);

CREATE TABLE sponsorships (
	id INT AUTO_INCREMENT,
	amount INT NOT NULL,
	article_id INT,
	charity_id INT,
	time_period INT NOT NULL,
	daye_of_sponsorship DATE,
	sponsor_email VARCHAR(50) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(charity_id) REFERENCES charities(id),
	FOREIGN KEY(article_id) REFERENCES articles(id)
);

CREATE TABLE lost_and_found (
	id INT AUTO_INCREMENT,
	status BOOLEAN,
	type_of_post CHAR NOT NULL,
	description VARCHAR(255),
	charity_id INT,
	date DATE,
	PRIMARY KEY(id),
	FOREIGN KEY(charity_id) REFERENCES charities(id)
);
