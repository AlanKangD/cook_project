CREATE TABLE cookMember(
    id          VARCHAR2(20)     NOT NULL, 
    password    VARCHAR2(100)    NOT NULL, 
    email       VARCHAR2(20)     NOT NULL, 
    address     VARCHAR2(100), 
    session_id VARCHAR2(20),
    auto_login VARCHAR2(20),
    PRIMARY KEY (id)
)