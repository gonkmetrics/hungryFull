CREATE TABLE user (
    userNum INT AUTO_INCREMENT PRIMARY KEY,
    userID varchar(50) NOT NULL,
    userPw VARCHAR(50)  NOT NULL,
    userName VARCHAR(50) NOT NULL,
    userEmail VARCHAR(100) NOT NULL,
    uage int NOT NULL,
    isAdmin tinyint
);

CREATE TABLE board (
    postID int auto_increment PRIMARY KEY,
    postAuthor int,
    foreign KEY (postAuthor)
    REFERENCES user(userNum),
    postTitle VARCHAR(300) NOT NULL,
    postContent VARCHAR(3000) NOT NULL,
    postTime DATETIME DEFAULT now(),
    postLastModified DATETIME DEFAULT now(),
    viewCount int,
    postType tinyint,
    imageLink varchar(500)
);

CREATE TABLE comment (
commentID int auto_increment PRIMARY KEY,
postID int,
foreign key (postID) REFERENCES board(postID),
commentAuthor int NOT NULL,
commentContent varchar(1000) NOT NULL
);

CREATE TABLE likes (
likeID int PRIMARY KEY auto_increment,
likeType tinyint,
postID int, foreign key (postID) references board(postID),
userNum int, foreign key (userNum) references user(userNum)
); 




#Example Data

INSERT INTO user VALUES (null, 'userA', 'abc123', 'userA_name', 'userA@email.com', 20, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Tacos with Avocado', '게시글_userA Test Post 1', now(), now(), 0 , 0, null);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Pesto Gnocchi', '게시글_userA Test Post 2', now(), now(), 0 , 0, null);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Steak with Hotelier Butter', '게시글_userA Test Post 3', now(), now(), 0 , 0, null);

INSERT INTO user VALUES (null, 'userB', 'abc123', 'userB_name', 'userB@email.com', 25, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Bacon Fryup', '게시글_userB', now(), now(), 0 , 0, null);

INSERT INTO user VALUES (null, 'userC', 'abc123', 'userC_name', 'userC@email.com', 30, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Dalgona Latte', '게시글_userC', now(), now(), 0 , 0, null);

INSERT INTO user VALUES (null, 'userD', 'abc123', 'userA_name', 'userA@email.com', 20, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Crab Fried Rice', '게시글_userD', now(), now(), 0 , 0, null);

INSERT INTO user VALUES (null, 'userE', 'abc123', 'userB_name', 'userB@email.com', 25, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Okonomiyaki', '게시글_userE', now(), now(), 0 , 0, null);

INSERT INTO user VALUES (null, 'userF', 'abc123', 'userC_name', 'userC@email.com', 30, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Hawaiian Poke', '게시글_userF', now(), now(), 0 , 0, null);

INSERT INTO user VALUES (null, 'userG', 'abc123', 'userA_name', 'userA@email.com', 20, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Peruvian Ceviche', '게시글_userG', now(), now(), 0 , 0, null);

INSERT INTO user VALUES (null, 'userH', 'abc123', 'userB_name', 'userB@email.com', 25, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Poutine and Fried Cheese Cruds', '게시글_userH', now(), now(), 0 , 0, null);

INSERT INTO user VALUES (null, 'userI', 'abc123', 'userC_name', 'userC@email.com', 30, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Currywurst with Homemade Curry Sauce', '게시글_userI', now(), now(), 0 , 0, null);

INSERT INTO user VALUES (null, 'userJ', 'abc123', 'userC_name', 'userC@email.com', 30, 0);
INSERT INTO board VALUES (null, LAST_INSERT_ID(), 'Sichuan Bssted Pork', '게시글_userJ', now(), now(), 0 , 0, null);

INSERT INTO board (postAuthor, postTitle, postContent) (SELECT postAuthor, postTitle, postContent FROM board);

#truncate test tables
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE user;
TRUNCATE board;
TRUNCATE likes;
TRUNCATE comment;

SELECT * FROM user;
SELECT * FROM board;
SELECT * FROM likes;


