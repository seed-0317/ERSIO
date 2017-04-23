-- /*******************************************************************************
--    Create Tables
-- ********************************************************************************/

drop SCHEMA if exists ersio CASCADE;
create SCHEMA ERSIO;
CREATE TABLE ERSIO.ERS_USER_ROLES
(
  UR_ID SERIAL NOT NULL,
  UR_ROLE VARCHAR(20),
  CONSTRAINT PK_UR_ID PRIMARY KEY  (UR_ID)
);

CREATE TABLE ERSIO.ERS_USERS
(
  U_ID serial NOT NULL,
  U_USERNAME VARCHAR(20) UNIQUE NOT NULL,
  U_FIRSTNAME VARCHAR(20) NOT NULL,
  U_LASTNAME VARCHAR(30) NOT NULL,
  U_EMAIL VARCHAR(20) UNIQUE NOT NULL,
  UR_ID INT,
  U_MANAGER INT,
  CONSTRAINT PK_U_ID PRIMARY KEY (U_ID),
  FOREIGN KEY(UR_ID) REFERENCES ERSIO.ERS_USER_ROLES(UR_ID)
);



CREATE TABLE ERSIO.ERS_REIMBURSEMENT_STATUS
(
  RS_ID SERIAL NOT NULL,
  RS_STATUS VARCHAR(20) NOT NULL,
  CONSTRAINT PK_RS_ID PRIMARY KEY  (RS_ID)
);

CREATE TABLE ERSIO.ERS_REIMBURSEMENT_TYPE
(
  RT_ID SERIAL NOT NULL,
  RT_TYPE VARCHAR(20) NOT NULL,
  CONSTRAINT PK_RT_ID PRIMARY KEY  (RT_ID)
);


CREATE TABLE ERSIO.ERS_REIMBURSEMENTS
(
  R_ID SERIAL NOT NULL,
  R_AMOUNT DECIMAL(8,2) NOT NULL,
  R_DESCRIPTION VARCHAR(220),
  R_SUBMITTED VARCHAR(10) NOT NULL,
  R_RESOLVED VARCHAR(10),
  --R_SUBMITTED TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  --R_RESOLVED TIMESTAMP WITHOUT TIME ZONE,
  U_ID_AUTHOR INT NOT NULL,
  U_ID_RESOLVER INT,
  RT_TYPE VARCHAR(20) NOT NULL,
  RT_STATUS VARCHAR(20) NOT NULL,
  CONSTRAINT PK_R_ID PRIMARY KEY  (R_ID),
  FOREIGN KEY(U_ID_AUTHOR) REFERENCES ERSIO.ERS_USERS(U_ID),
  FOREIGN KEY(U_ID_RESOLVER) REFERENCES ERSIO.ERS_USERS(U_ID),
  FOREIGN KEY(RT_TYPE) REFERENCES ERSIO.ERS_REIMBURSEMENT_TYPE(RT_ID),
  FOREIGN KEY(RT_STATUS) REFERENCES ERSIO.ERS_REIMBURSEMENT_STATUS(RS_ID)
);


/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/


/*******************************************************************************
   Populate Tables
********************************************************************************/
insert into ERSIO.ERS_USER_ROLES (UR_ROLE) values ('employee');
insert into ERSIO.ERS_USER_ROLES (UR_ROLE) values ('manager');

--delete from ersio.ERS_USERS;
--select * from ersio.ERS_USERS;

insert into ERSIO.ers_users (u_username, u_firstname, u_lastname, u_email, ur_id, U_MANAGER) values ('sss123', 'Sarah', 'White',   'sarah@ersio.com', 1 , 4);
insert into ERSIO.ers_users (u_username, u_firstname, u_lastname, u_email, ur_id, U_MANAGER) values ('jjj123', 'John',  'Smith',   'john@ersio.com',  1,  4);
insert into ERSIO.ers_users (u_username, u_firstname, u_lastname, u_email, ur_id, U_MANAGER) values ('bbb123', 'Brian', 'Green',   'brian@ersio.com', 1 , 5);
insert into ERSIO.ers_users (u_username, u_firstname, u_lastname, u_email, ur_id, U_MANAGER) values ('ttt123', 'Tom',   'Brown',   'tom@ersio.com',   2 , 6);
insert into ERSIO.ers_users (u_username, u_firstname, u_lastname, u_email, ur_id, U_MANAGER) values ('ddd123', 'David', 'Johnson', 'david@ersio.com', 2 , 6);
insert into ERSIO.ers_users (u_username, u_firstname, u_lastname, u_email, ur_id)            values ('mmm123', 'Mary',  'Lennon',  'mary@ersio.com',  2);


--select * from ERSIO.ERS_USER_ROLES;
--select * from ERSIO.ERS_USERS;


insert into ERSIO.ERS_REIMBURSEMENT_STATUS (RS_STATUS) values ('Approved');
insert into ERSIO.ERS_REIMBURSEMENT_STATUS (RS_STATUS) values ('Declined');
insert into ERSIO.ERS_REIMBURSEMENT_STATUS (RS_STATUS) values ('Pending');

--select * from ERSIO.ERS_REIMBURSEMENT_STATUS;

insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('Travel');
insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('Mileage');
insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('Meal');
insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('Lodging');
insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('Supplies');
insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('Fun Event');

/* insert into ERSIO.ERS_REIMBURSEMENT_STATUS (RS_STATUS) values ('approved');
insert into ERSIO.ERS_REIMBURSEMENT_STATUS (RS_STATUS) values ('declined');
insert into ERSIO.ERS_REIMBURSEMENT_STATUS (RS_STATUS) values ('pending'); */

--select * from ERSIO.ERS_REIMBURSEMENT_STATUS;

/* insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('travel');
insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('meal');
insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('books');
insert into ERSIO.ERS_REIMBURSEMENT_TYPE (RT_TYPE) values ('fun'); */

--select * from ERSIO.ERS_REIMBURSEMENT_TYPE;
