CREATE DATABASE my_Website;
USE my_Website;

CREATE TABLE if not exists users (
user_num INT AUTO_INCREMENT PRIMARY KEY,
user_id VARCHAR(20) UNIQUE KEY,
password VARCHAR(100) NOT NULL,
name VARCHAR(30) NOT NULL,
email VARCHAR(100) UNIQUE,
role VARCHAR(20) DEFAULT 'USER',
status VARCHAR(20) DEFAULT 'ACTIVE',
profile_img VARCHAR(200),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
report_count INT DEFAULT 0,
last_login_at TIMESTAMP
);

CREATE TABLE if not exists boards (
board_id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(100) NOT NULL,
content TEXT NOT NULL,
writer_num INT NOT NULL,
views INT DEFAULT 0,
category VARCHAR(20),
pinned BOOLEAN DEFAULT FALSE,
like_count INT DEFAULT 0,
comment_count INT DEFAULT 0,
report_count INT DEFAULT 0,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
deleted_at TIMESTAMP NULL,
FOREIGN KEY (writer_num) REFERENCES users(user_num)
);

CREATE TABLE if not exists comments (
comment_id INT AUTO_INCREMENT PRIMARY KEY,
board_id INT, 
writer_num INT NOT NULL,
parent_id INT NULL,
content TEXT NOT NULL,
like_count INT DEFAULT 0,
report_count INT DEFAULT 0,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
deleted_at TIMESTAMP NULL,
FOREIGN KEY (board_id) REFERENCES boards(board_id),
FOREIGN KEY (writer_num) REFERENCES users(user_num),
FOREIGN KEY (parent_id) REFERENCES comments(comment_id)
);

CREATE TABLE if not exists files(
file_id INT AUTO_INCREMENT PRIMARY KEY,
board_id INT NOT NULL,
original_name VARCHAR(200) NOT NULL,
saved_name VARCHAR(200) NOT NULL,
file_type ENUM('INLINE', 'ATTACHMENT') NOT NULL,
extension VARCHAR(10) NOT NULL,
file_path VARCHAR(255) NOT NULL,
size BIGINT,
download_count INT DEFAULT 0,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (board_id) REFERENCES boards(board_id)
); 

CREATE TABLE if not exists likes(
like_id INT AUTO_INCREMENT PRIMARY KEY,
target_type VARCHAR(20) NOT NULL, # ENUM('BOARD', 'COMMENT') NOT NULL 도 가능하곘으나, 확장을 위해 안씀.
target_id INT NOT NULL,
user_num INT NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_num) REFERENCES users(user_num),
UNIQUE (target_type, target_id, user_num)
);

CREATE TABLE if not exists reports(
report_id INT AUTO_INCREMENT PRIMARY KEY,
target_type  VARCHAR(20) NOT NULL,
target_id INT NOT NULL,
reporter_num INT NOT NULL,
reason VARCHAR(200),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (reporter_num) REFERENCES users(user_num),
UNIQUE (target_type, target_id, reporter_num)
);

INSERT INTO users (user_id, password, name, email, role, status)
VALUES ('admin', 'admin', '관리자', 'admin@example.com', 'ADMIN', 'ACTIVE');

INSERT INTO users (user_id, password, name, email, role, status)
VALUES ('1234', '1234', '청명', 'cheongmyeong@example.com', 'USER', 'ACTIVE');

SELECT * 
FROM users;