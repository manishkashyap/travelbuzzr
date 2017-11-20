CREATE DATABASE travelbuzzr;
ALTER DATABASE travelbuzzr CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS user (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  phone VARCHAR(45) NULL DEFAULT NULL,
  creation_tstamp TIMESTAMP  NOT NULL DEFAULT 0,
  last_modified_tstamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id) ,
  UNIQUE KEY (phone)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE IF NOT EXISTS pnr (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  pnr_number VARCHAR(45) NOT NULL,
  train_id INTEGER UNSIGNED NOT NULL,
  from_station_id INTEGER UNSIGNED NOT NULL,
  to_station_id INTEGER UNSIGNED NOT NULL,
  pnr_details TEXT  NOT NULL,
  creation_tstamp TIMESTAMP  NOT NULL DEFAULT 0,
  last_modified_tstamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id) ,
  UNIQUE KEY (pnr_number),
  foreign key (train_id)
    references train (id)
    on delete no action
    on update no action,
  foreign key (to_station_id)
    references station (id)
    on delete no action
    on update no action,
  foreign key (from_station_id)
    references station (id)
    on delete no action
    on update no action
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE IF NOT EXISTS user_pnr_rel (
	id int(10) unsigned not null auto_increment,
	user_id int(10) unsigned not null,
	pnr_id int(10) unsigned not null,
  primary key (id),
  foreign key (user_id)
    references user (id)
    on delete no action
    on update no action,
  foreign key (pnr_id)
    references pnr (id)
    on delete no action
    on update no action
)	ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE IF NOT EXISTS station (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(10) NOT NULL,
  lat DECIMAL NULL DEFAULT NULL,
  lng DECIMAL NULL DEFAULT NULL,
  creation_tstamp TIMESTAMP  NOT NULL DEFAULT 0,
  last_modified_tstamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id) ,
  UNIQUE KEY (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE IF NOT EXISTS train (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  name VARCHAR(255) NOT NULL,
  number INTEGER UNSIGNED NOT NULL,
  status enum('MON','TUE','WED','THU', 'FRI', 'SAT', 'SUN')  NOT NULL DEFAULT 'INACTIVE',
  status enum('INACTIVE','ACTIVE','DELETED','BOGUS', 'PREVIEW', 'EMPTY')  NOT NULL DEFAULT 'ACTIVE',
  days INT UNSIGNED NOT NULL DEFAULT 0000000,
  classes INT UNSIGNED NOT NULL DEFAULT 00000000,
  src_station_id INTEGER UNSIGNED NOT NULL,
  src_station_dep_time INTEGER UNSIGNED NOT NULL,
  dest_station_id INTEGER UNSIGNED NOT NULL,
  dest_station_arr_time INTEGER UNSIGNED NOT NULL,
  creation_tstamp TIMESTAMP  NOT NULL DEFAULT 0,
  last_modified_tstamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id) ,
  UNIQUE KEY (code),
  foreign key (src_station_id)
    references station (id)
    on delete no action
    on update no action,
  foreign key (dest_station_id)
    references station (id)
    on delete no action
    on update no action
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE IF NOT EXISTS train_routes (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	train_id INTEGER UNSIGNED NOT NULL,
	station_id INTEGER UNSIGNED NOT NULL,
	arr_time INTEGER UNSIGNED NOT NULL DEFAULT 0,
	dep_time INTEGER UNSIGNED NOT NULL DEFAULT 0,
	distance INTEGER UNSIGNED NOT NULL DEFAULT 0,
	halt INTEGER UNSIGNED NOT NULL DEFAULT 0,
	foreign key (station_id)
		references station (id)
		on delete no action
		on update no action,
	foreign key (train_id)
		references train (id)
		on delete no action
		on update no action
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



