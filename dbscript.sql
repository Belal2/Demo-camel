
CREATE SCHEMA demo AUTHORIZATION postgres;

CREATE TABLE demo.account (
	id int8 NOT NULL,
	created_on timestamp NULL,
	date_of_birth timestamp NULL,
	file_path varchar(255) NULL,
	image_base varchar NULL,
	is_deleted bool NOT NULL,
	name varchar(255) NULL,
	updated_on timestamp NULL,
	CONSTRAINT account_pkey PRIMARY KEY (id)
);
-----------------------
CREATE TABLE demo.account_wallet_info (
	id int8 NOT NULL,
	balance float8 NULL,
	date_of_birth timestamp NULL,
	last_update timestamp NULL,
	"name" varchar(255) NULL,
	CONSTRAINT account_wallet_info_pkey PRIMARY KEY (id)
);
------------
