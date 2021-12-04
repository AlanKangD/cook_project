CREATE TABLE recipe_board(
    recipe_no INT NOT NULL, 
    recipe_id VARCHAR2(20) NOT NULL, 
    recipe_title VARCHAR2(50) NOT NULL, 
    recipe_processVARCHAR2(500) NOT NULL
    recipe_ingredient VARCHAR2(300) NOT NULL
    recipe_cooking_time VARCHAR2(50) NOT NULL
    recipe_content VARCHAR2(500) NOT NULL, 
    recipe_file_name VARCHAR2(500) NOT NULL, 
    recipe_uphit INT, 
    recipe_good INT, 
    recipe_date date default sysdate, 
    recipe_category INT NOT NULL, 
    PRIMARY KEY (recipe_no),
constraint fk_id_recipe foreign key(recipe_id) references cook_member(id) on delete cascade enable
);
create sequence recipe_seq_SEQ start with 1 increment by 1;
