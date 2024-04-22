CREATE DATABASE cinelist;

USE cinelist;

CREATE TABLE movies(
  id varchar(90) PRIMARY KEY NOT NULL,
  title varchar(70) NOT NULL,
  short_description varchar(255) NOT NULL,
  long_description text NOT NULL,
  release_date date NOT NULL,
  trailer_url text,
  thumbnail_url text,
  duration varchar(10),
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE shows(
  id varchar(90) PRIMARY KEY NOT NULL,
  title varchar(70) NOT NULL,
  short_description varchar(255) NOT NULL,
  long_description text NOT NULL,
  season int(11),
  episodes int(11),
  release_date date NOT NULL,
  trailer_url text,
  thumbnail_url text,
  duration varchar(10),
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE actors(
  id varchar(90) PRIMARY KEY NOT NULL,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  birth_date date,
  gender varchar(10) NOT NULL,
  photo_url text,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE directors(
  id varchar(90) PRIMARY KEY NOT NULL,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  birth_date date,
  gender varchar(10) NOT NULL,
  photo_url text,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE languages(
  id varchar(90) PRIMARY KEY NOT NULL,
  name varchar(90) NOT NULL
);

CREATE TABLE platforms(
  id varchar(90) PRIMARY KEY NOT NULL,
  name varchar(90) NOT NULL
);

CREATE TABLE certificates(
  id varchar(90) PRIMARY KEY NOT NULL,
  age int(11) NOT NULL
);

CREATE TABLE seasons(
  id varchar(90) PRIMARY KEY NOT NULL,
  season int(11) NOT NULL,
  episodes int(11) NOT NULL,
  show_id varchar(90) NOT NULL,
  FOREIGN KEY (show_id) REFERENCES shows (id)
);

CREATE TABLE directors_movies(
  director_id varchar(90) NOT NULL,
  movie_id varchar(90) NOT NULL,
  PRIMARY KEY (director_id, movie_id),
  FOREIGN KEY (director_id) REFERENCES directors (id),
  FOREIGN KEY (movie_id) REFERENCES movies (id)
);

CREATE TABLE directors_shows(
  director_id varchar(90) NOT NULL,
  show_id varchar(90) NOT NULL,
  PRIMARY KEY (director_id, show_id),
  FOREIGN KEY (director_id) REFERENCES directors (id),
  FOREIGN KEY (show_id) REFERENCES shows (id)
);

CREATE TABLE actors_movies(
  actor_id varchar(90) NOT NULL,
  movie_id varchar(90) NOT NULL,
  character_name varchar(60),
  role_description varchar(255),
  PRIMARY KEY (actor_id, movie_id),
  FOREIGN KEY (actor_id) REFERENCES actors (id),
  FOREIGN KEY (movie_id) REFERENCES movies (id)
);

CREATE TABLE actors_shows(
  actor_id varchar(90) NOT NULL,
  show_id varchar(90) NOT NULL,
  character_name varchar(60),
  role_description varchar(255),
  PRIMARY KEY (actor_id, show_id),
  FOREIGN KEY (actor_id) REFERENCES actors (id),
  FOREIGN KEY (show_id) REFERENCES shows (id)
);