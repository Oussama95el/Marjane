CREATE TABLE super_admin(
sa_id BIGSERIAL NOT NULL PRIMARY KEY,
sa_name VARCHAR(100) NOT NULL,
sa_email VARCHAR(250) UNIQUE NOT NULL,
sa_password VARCHAR(100) NOT NULL

);

CREATE TABLE admin(
a_id BIGSERIAL NOT NULL PRIMARY KEY,
a_name VARCHAR(100) NOT NULL,
a_email VARCHAR(250) UNIQUE NOT NULL,
a_password VARCHAR(100) NOT NULL

);

CREATE TABLE resp_rayon(
rr_id BIGSERIAL NOT NULL PRIMARY KEY,
rr_name VARCHAR(100) NOT NULL,
rr_email VARCHAR(250) UNIQUE NOT NULL,
rr_password VARCHAR(100) NOT NULL,
rr_rayon BIGSERIAL NOT NULL,

FOREIGN KEY (rr_rayon) REFERENCES category(c_id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE promotion (
p_id BIGSERIAL NOT NULL PRIMARY KEY,
p_category BIGSERIAL NOT NULL,
p_sub_category BIGSERIAL,
p_start_date DATE NOT NULL,
p_expire_date DATE NOT NULL,
p_rate decimal(5,2) NOT NULL,
p_point_fidelite int,
p_staus Varchar(100) DEFAULT 'PENDING'

FOREIGN KEY (p_category) REFERENCES category(c_id) ON UPDATE CASCADE ON DELETE CASCADE ,
FOREIGN KEY (p_sub_category) REFERENCES sub_category(sc_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE category (
c_id BIGSERIAL NOT NULL PRIMARY KEY,
c_name VARCHAR(100) NOT NULL
);


CREATE TABLE sub_category (
sc_id BIGSERIAL NOT NULL PRIMARY KEY,
sc_name VARCHAR(100) NOT NULL,
sc_category BIGSERIAL NOT NULL,

FOREIGN KEY (sc_category) REFERENCES category(c_id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE branch(
b_id BIGSERIAL NOT NULL PRIMARY KEY,
b_city BIGSERIAL NOT NULL,
b_adress VARCHAR(255) NOT NULL,
b_admin BIGSERIAL NOT NULL,

FOREIGN KEY (b_city) REFERENCES city(c_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (b_admin) REFERENCES admin(a_id) ON UPDATE CASCADE
);

CREATE TABLE city(
c_id BIGSERIAL NOT NULL PRIMARY KEY,
c_nom VARCHAR(100) NOT NULL
);


CREATE TABLE comment(
c_id BIGSERIAL NOT NULL PRIMARY KEY,
c_content VARCHAR(255) NOT NULL,
c_date date NOT NULL DEFAULT CURRENT_DATE,
c_user INT NOT NULL,
c_promotion INT NOT NULL,
PRIMARY KEY (c_id),
FOREIGN KEY (c_user) REFERENCES resp_rayon(rr_id),
FOREIGN KEY (c_promotion) REFERENCES promotion(p_id)	
);
