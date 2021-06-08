DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS user;
   
CREATE TABLE user(
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NULL,
  password VARCHAR(50) NULL,
  role enum('author','admin') DEFAULT NULL,
  token VARCHAR(500) NULL,
  created_at VARCHAR(50) NULL
);
  
CREATE TABLE post(
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT DEFAULT NULL,
  title VARCHAR(255) NOT NULL,
  views INT(11) NOT NULL DEFAULT '0',
  body text NOT NULL,
  published tinyint(1)  NULL,
  created_at VARCHAR(50) NULL,
  updated_at VARCHAR(50) NULL, 
  FOREIGN KEY (user_id) REFERENCES user (id)
); 

INSERT INTO user (username,password,role,token,created_at) VALUES('estevam','123','admin','eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkVzdGV2YW0gTWVuZXNlcyIsInVzZXJuYW1lIjoiZXN0ZXZhbSIsInBvc2l0aW9uIjoiU2VuaW9yIFNvZnR3YXJlIERldmVsb3BlciJ9.nILPY_WwOxdC3iuyt9ggitWueeZEj1VeiRwyo-N85dU', parsedatetime('25-05-2021 18:47:52', 'dd-MM-yyyy hh:mm:ss'));
INSERT INTO post (user_id,title,views,body, published,created_at, updated_at) VALUES(1,'Java 11', 1, 'java 11 will be relised in September 2011', 0, parsedatetime('25-05-2021 18:47:52', 'dd-MM-yyyy hh:mm:ss'), parsedatetime('25-05-2021 18:47:52', 'dd-MM-yyyy hh:mm:ss'));



