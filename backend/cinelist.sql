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
  release_date date NOT NULL,
  trailer_url text,
  thumbnail_url text,
  duration varchar(10),
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE seasons(
  id varchar(90) PRIMARY KEY NOT NULL,
  season int(11) NOT NULL,
  episodes int(11) NOT NULL,
  show_id varchar(90) NOT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (show_id) REFERENCES shows (id)
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
  name varchar(90) NOT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE platforms(
  id varchar(90) PRIMARY KEY NOT NULL,
  name varchar(90) NOT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE certificates(
  id varchar(90) PRIMARY KEY NOT NULL,
  age int(11) NOT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
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

CREATE TABLE movies_certificates(
  certificate_id varchar(90) NOT NULL,
  movie_id varchar(90) NOT NULL,
  PRIMARY KEY (certificate_id, movie_id),
  FOREIGN KEY (certificate_id) REFERENCES certificates (id),
  FOREIGN KEY (movie_id) REFERENCES movies (id)
);

CREATE TABLE movies_languages(
  language_id varchar(90) NOT NULL,
  movie_id varchar(90) NOT NULL,
  PRIMARY KEY (language_id, movie_id),
  FOREIGN KEY (language_id) REFERENCES languages (id),
  FOREIGN KEY (movie_id) REFERENCES movies (id)
);

CREATE TABLE movies_platforms(
  platform_id varchar(90) NOT NULL,
  movie_id varchar(90) NOT NULL,
  PRIMARY KEY (platform_id, movie_id),
  FOREIGN KEY (platform_id) REFERENCES platforms (id),
  FOREIGN KEY (movie_id) REFERENCES movies (id)
);

CREATE TABLE shows_certificates(
  certificate_id varchar(90) NOT NULL,
  show_id varchar(90) NOT NULL,
  PRIMARY KEY (certificate_id, show_id),
  FOREIGN KEY (certificate_id) REFERENCES certificates (id),
  FOREIGN KEY (show_id) REFERENCES shows (id)
);

CREATE TABLE shows_languages(
  language_id varchar(90) NOT NULL,
  show_id varchar(90) NOT NULL,
  PRIMARY KEY (language_id, show_id),
  FOREIGN KEY (language_id) REFERENCES languages (id),
  FOREIGN KEY (show_id) REFERENCES shows (id)
);

CREATE TABLE shows_platforms(
  platform_id varchar(90) NOT NULL,
  show_id varchar(90) NOT NULL,
  PRIMARY KEY (platform_id, show_id),
  FOREIGN KEY (platform_id) REFERENCES platforms (id),
  FOREIGN KEY (show_id) REFERENCES shows (id)
);

CREATE TABLE users(
  id varchar(90) NOT NULL PRIMARY KEY,
  first_name varchar(120) NOT NULL,
  last_name varchar(120) NOT NULL,
  username varchar(20) NOT NULL,
  email varchar(120) NOT NULL,
  gender varchar(20),
  birth_date date,
  photo_url varchar(255),
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE user_favorite_movies(
  movie_id varchar(90) NOT NULL,
  user_id varchar(90) NOT NULL,
  PRIMARY KEY (movie_id, user_id),
  FOREIGN KEY (movie_id) REFERENCES movies (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE user_favorite_shows(
  show_id varchar(90) NOT NULL,
  user_id varchar(90) NOT NULL,
  PRIMARY KEY (show_id, user_id),
  FOREIGN KEY (show_id) REFERENCES shows (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE user_watch_movies(
  movie_id varchar(90) NOT NULL,
  user_id varchar(90) NOT NULL,
  PRIMARY KEY (movie_id, user_id),
  FOREIGN KEY (movie_id) REFERENCES movies (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE user_watch_shows(
  show_id varchar(90) NOT NULL,
  user_id varchar(90) NOT NULL,
  PRIMARY KEY (show_id, user_id),
  FOREIGN KEY (show_id) REFERENCES shows (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE genres(
  id varchar(90) PRIMARY KEY NOT NULL,
  genre varchar(20) NOT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  updated_at timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE movies_genres(
  movie_id varchar(90) NOT NULL,
  genre_id varchar(90) NOT NULL,
  PRIMARY KEY (movie_id, genre_id),
  FOREIGN KEY (movie_id) REFERENCES movies (id),
  FOREIGN KEY (genre_id) REFERENCES genres (id)
);

CREATE TABLE shows_genres(
  show_id varchar(90) NOT NULL,
  genre_id varchar(90) NOT NULL,
  PRIMARY KEY (show_id, genre_id),
  FOREIGN KEY (show_id) REFERENCES shows (id),
  FOREIGN KEY (genre_id) REFERENCES genres (id)
);