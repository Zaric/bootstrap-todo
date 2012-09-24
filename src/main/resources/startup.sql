DROP TABLE IF EXISTS USER_ROLES;
DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
  USER_ID INTEGER NOT NULL,
  USERNAME VARCHAR(45) NOT NULL,
  PASSWORD VARCHAR(45) NOT NULL,
  ENABLED SMALLINT NOT NULL,
  PRIMARY KEY (USER_ID) 
);


CREATE TABLE USER_ROLES (
  USER_ROLE_ID INTEGER NOT NULL,
  USER_ID INTEGER NOT NULL,
  AUTHORITY VARCHAR(45) NOT NULL,
  PRIMARY KEY (USER_ROLE_ID),
  FOREIGN KEY (USER_ID) REFERENCES users (USER_ID)
);

INSERT INTO USERS VALUES(001, 'sam', 'secr3t', 1);

INSERT INTO USER_ROLES VALUES (1, 001, 'ROLE_USER');

select * from user_details;
select * from user_roles;
select * from user_role_join;

select * from task


select * from hibernate_sequence;
select setval('hibernate_sequence',1);
drop sequence hibernate_sequence;

create sequence user_sequence;
create sequence user_role_sequence;

select * from user_sequence;
select * from user_role_sequence;



   	
   	
   	
   	
   	
