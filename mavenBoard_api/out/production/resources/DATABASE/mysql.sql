CREATE TABLE FREEBOARD(
                          NUM INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          NAME VARCHAR(20),
                          TITLE VARCHAR(100),
                          CONTENT VARCHAR(1000),
                          REGDATE DATETIME
);
CREATE TABLE FILEBOARD(
                          NUM INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          NAME VARCHAR(20),
                          TITLE VARCHAR(100),
                          CONTENT VARCHAR(1000),
                          REGDATE DATETIME
);

CREATE TABLE FILE(
                     NUM INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                     ORIGINAL_FILE_NAME VARCHAR(1000),
                     SAVE_FILE_NAME VARCHAR(1000),
                     FILE_SIZE VARCHAR(1000),
                     CREATE_DATE DATETIME,
                     DEL_CHK VARCHAR(1));

INSERT INTO FREEBOARD(
    NAME,
    TITLE,
    CONTENT,
    REGDATE
)VALUES(
    'TEST 작성자 1'
    ,'TEST 제목 1'
    ,'TEST 내용 1'
    ,SYSDATE()
);
