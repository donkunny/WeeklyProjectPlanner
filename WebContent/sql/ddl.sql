/* Project */
DROP TABLE Project 
   CASCADE CONSTRAINTS;

/* Employee */
DROP TABLE Employee 
   CASCADE CONSTRAINTS;

/* Department */
DROP TABLE Department 
   CASCADE CONSTRAINTS;

/* ProjectDetail */
DROP TABLE ProjectDetail 
   CASCADE CONSTRAINTS;

/* ProjectTeam */
DROP TABLE ProjectTeam 
   CASCADE CONSTRAINTS;

/* 임시 테이블 */
DROP TABLE Temporary 
   CASCADE CONSTRAINTS;

/* Project */
CREATE TABLE Project (
   pIndex NUMBER(5) NOT NULL, /* 프로젝트코드 */
   pName VARCHAR2(100), /* 프로젝트이름 */
   eIndex NUMBER(5), /* 사원코드(책임자) */
   pProgress NUMBER(10,2) DEFAULT 0, /* 진행률 */
   pStartDate DATE, /* 시작일 */
   pEndDate DATE, /* 종료일 */
   pWriteDate DATE /* 작성일 */
);

COMMENT ON TABLE Project IS 'Project';

COMMENT ON COLUMN Project.pIndex IS '프로젝트코드';

COMMENT ON COLUMN Project.pName IS '프로젝트이름';

COMMENT ON COLUMN Project.eIndex IS '사원코드(책임자)';

COMMENT ON COLUMN Project.pProgress IS '진행률';

COMMENT ON COLUMN Project.pStartDate IS '시작일';

COMMENT ON COLUMN Project.pEndDate IS '종료일';

COMMENT ON COLUMN Project.pWriteDate IS '작성일';

CREATE UNIQUE INDEX PK_Project
   ON Project (
      pIndex ASC
   );

ALTER TABLE Project
   ADD
      CONSTRAINT PK_Project
      PRIMARY KEY (
         pIndex
      );

ALTER TABLE Project
   ADD
      CONSTRAINT CK_Project
      CHECK (pProgress between 0 and 100);

/* Employee */
CREATE TABLE Employee (
   eIndex NUMBER(5) NOT NULL, /* 사원코드 */
   eNum NUMBER(6) NOT NULL, /* 사원번호(아이디) */
   eName VARCHAR2(20), /* 사원이름 */
   ePassword VARCHAR2(20) NOT NULL, /* 비밀번호 */
   eHiredate DATE, /* 입사일 */
   ePosition VARCHAR2(20), /* 직책 */
   eTel VARCHAR2(20), /* 전화번호 */
   dIndex NUMBER(5) /* 담당코드 */
);

COMMENT ON TABLE Employee IS 'Employee';

COMMENT ON COLUMN Employee.eIndex IS '사원코드';

COMMENT ON COLUMN Employee.eNum IS '사원번호(아이디)';

COMMENT ON COLUMN Employee.eName IS '사원이름';

COMMENT ON COLUMN Employee.ePassword IS '비밀번호';

COMMENT ON COLUMN Employee.eHiredate IS '입사일';

COMMENT ON COLUMN Employee.ePosition IS '직책';

COMMENT ON COLUMN Employee.eTel IS '전화번호';

COMMENT ON COLUMN Employee.dIndex IS '담당코드';

CREATE UNIQUE INDEX PK_Employee
   ON Employee (
      eIndex ASC
   );

ALTER TABLE Employee
   ADD
      CONSTRAINT PK_Employee
      PRIMARY KEY (
         eIndex
      );

/* Department */
CREATE TABLE Department (
   dIndex NUMBER(5) NOT NULL, /* 담당코드 */
   dName VARCHAR2(20) NOT NULL, /* 부서이름 */
   dPart VARCHAR2(20) /* 담당이름 */
);

COMMENT ON TABLE Department IS 'Department';

COMMENT ON COLUMN Department.dIndex IS '담당코드';

COMMENT ON COLUMN Department.dName IS '부서이름';

COMMENT ON COLUMN Department.dPart IS '담당이름';

CREATE UNIQUE INDEX PK_Department
   ON Department (
      dIndex ASC
   );

ALTER TABLE Department
   ADD
      CONSTRAINT PK_Department
      PRIMARY KEY (
         dIndex
      );

/* ProjectDetail */
CREATE TABLE ProjectDetail (
   pdIndex NUMBER(5) NOT NULL, /* 업무코드 */
   pIndex NUMBER(5) NOT NULL, /* 프로젝트코드 */
   eIndex NUMBER(5) NOT NULL, /* 사원코드 */
   pdName VARCHAR2(100), /* 업무이름 */
   pdProgress NUMBER(10,2) DEFAULT 0, /* 진행률 */
   pdStartDate DATE, /* 시작일 */
   pdEndDate DATE, /* 종료일 */
   pdWriteDate DATE /* 작성일 */
);

COMMENT ON TABLE ProjectDetail IS 'ProjectDetail';

COMMENT ON COLUMN ProjectDetail.pdIndex IS '업무코드';

COMMENT ON COLUMN ProjectDetail.pIndex IS '프로젝트코드';

COMMENT ON COLUMN ProjectDetail.eIndex IS '사원코드';

COMMENT ON COLUMN ProjectDetail.pdName IS '업무이름';

COMMENT ON COLUMN ProjectDetail.pdProgress IS '진행률';

COMMENT ON COLUMN ProjectDetail.pdStartDate IS '시작일';

COMMENT ON COLUMN ProjectDetail.pdEndDate IS '종료일';

COMMENT ON COLUMN ProjectDetail.pdWriteDate IS '작성일';

CREATE UNIQUE INDEX PK_ProjectDetail
   ON ProjectDetail (
      pdIndex ASC
   );

ALTER TABLE ProjectDetail
   ADD
      CONSTRAINT PK_ProjectDetail
      PRIMARY KEY (
         pdIndex
      );

ALTER TABLE ProjectDetail
   ADD
      CONSTRAINT CK_ProjectDetail
      CHECK (pdProgress between 0 and 100);

/* ProjectTeam */
CREATE TABLE ProjectTeam (
   ptIndex NUMBER(5) NOT NULL, /* 팀인덱스 */
   pIndex NUMBER(5) NOT NULL, /* 프로젝트코드 */
   eIndex NUMBER(5) NOT NULL /* 사원코드 */
);

COMMENT ON TABLE ProjectTeam IS 'ProjectTeam';

COMMENT ON COLUMN ProjectTeam.ptIndex IS '팀인덱스';

COMMENT ON COLUMN ProjectTeam.pIndex IS '프로젝트코드';

COMMENT ON COLUMN ProjectTeam.eIndex IS '사원코드';

CREATE UNIQUE INDEX PK_ProjectTeam
   ON ProjectTeam (
      ptIndex ASC
   );

ALTER TABLE ProjectTeam
   ADD
      CONSTRAINT PK_ProjectTeam
      PRIMARY KEY (
         ptIndex
      );

/* 임시 테이블 */
CREATE TABLE Temporary (
);

COMMENT ON TABLE Temporary IS '임시 테이블';

ALTER TABLE Project
   ADD
      CONSTRAINT FK_Employee_TO_Project
      FOREIGN KEY (
         eIndex
      )
      REFERENCES Employee (
         eIndex
      )
      ON DELETE CASCADE;

ALTER TABLE Employee
   ADD
      CONSTRAINT FK_Department_TO_Employee
      FOREIGN KEY (
         dIndex
      )
      REFERENCES Department (
         dIndex
      )
      ON DELETE CASCADE;

ALTER TABLE ProjectDetail
   ADD
      CONSTRAINT FK_Project_TO_ProjectDetail
      FOREIGN KEY (
         pIndex
      )
      REFERENCES Project (
         pIndex
      )
      ON DELETE CASCADE;

ALTER TABLE ProjectDetail
   ADD
      CONSTRAINT FK_Employee_TO_ProjectDetail
      FOREIGN KEY (
         eIndex
      )
      REFERENCES Employee (
         eIndex
      )
      ON DELETE CASCADE;

ALTER TABLE ProjectTeam
   ADD
      CONSTRAINT FK_Project_TO_ProjectTeam
      FOREIGN KEY (
         pIndex
      )
      REFERENCES Project (
         pIndex
      )
      ON DELETE CASCADE;

ALTER TABLE ProjectTeam
   ADD
      CONSTRAINT FK_Employee_TO_ProjectTeam
      FOREIGN KEY (
         eIndex
      )
      REFERENCES Employee (
         eIndex
      )
      ON DELETE CASCADE;
      
DROP SEQUENCE SEQ_D;
   DROP SEQUENCE SEQ_E;
   DROP SEQUENCE SEQ_P;
   DROP SEQUENCE SEQ_PT;
   DROP SEQUENCE SEQ_PD;

   CREATE SEQUENCE SEQ_D INCREMENT BY 1 START WITH 1;
   CREATE SEQUENCE SEQ_E INCREMENT BY 1 START WITH 1;
   CREATE SEQUENCE SEQ_P INCREMENT BY 1 START WITH 1;
   CREATE SEQUENCE SEQ_PT INCREMENT BY 1 START WITH 1;
   CREATE SEQUENCE SEQ_PD INCREMENT BY 1 START WITH 1;      