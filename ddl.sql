CREATE TABLE course (
   id INT NOT NULL AUTO_INCREMENT,
   code VARCHAR(6) NOT NULL,
   title VARCHAR(50) NOT NULL,
   credit INT NOT NULL,
   creation_date DATE NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (code)
);

CREATE TABLE trainee (
   id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(50) NOT NULL,
   last_name VARCHAR(50) NOT NULL,
   email VARCHAR(20) NOT NULL,
   phone VARCHAR(11) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (email, phone)
);

CREATE TABLE course_trainee (
   courses_id INT NOT NULL,
   trainees_id INT NOT NULL,
   enrollment_date TIMESTAMP DEFAULT NOW(),
   FOREIGN KEY (trainees_id) REFERENCES trainees (id),
   FOREIGN KEY (courses_id) REFERENCES courses (id)
);

CREATE TABLE user (
   id INT NOT NULL AUTO_INCREMENT,
   username VARCHAR(50) NOT NULL,
   password VARCHAR(130) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (username)
);

