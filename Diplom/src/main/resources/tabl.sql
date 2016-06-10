/*CREATE DATABASE timetable;*/
/*CREATE EXTENSION pgcrypto;  
 default gen_random_uuid()*/

DROP TABLE IF EXISTS GrpMod;
DROP TABLE IF EXISTS Lessons;
DROP TABLE IF EXISTS Grp;
DROP TABLE IF EXISTS ModProf;
DROP TABLE IF EXISTS Module;
DROP TABLE IF EXISTS Professor;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS TypeRoom;
DROP TABLE IF EXISTS Timeslot;

CREATE TABLE Grp 
( id integer,
  groupSize integer,
  CONSTRAINT PK_Grp PRIMARY KEY (id)
);

CREATE TABLE TypeRoom (
id serial,
type char(20) NOT NULL,
CONSTRAINT PK_TypeRoom PRIMARY KEY (id)
);

CREATE TABLE Module (
Id serial,
code name NOT NULL,
name char(5) NOT NULL,
typeRoomId integer,
CONSTRAINT PK_Module PRIMARY KEY (id),
CONSTRAINT FK_Module_TypeRoom FOREIGN KEY (typeRoomId) REFERENCES TypeRoom(id)
);

CREATE TABLE GrpMod (
groupId integer,
moduleId integer,
CONSTRAINT PK_GrpMod PRIMARY KEY(groupId, moduleId),
CONSTRAINT FK_GrpMod_Grp FOREIGN KEY (groupId) REFERENCES Grp(id),
CONSTRAINT FK_GrpMod_Module FOREIGN KEY (moduleId) REFERENCES Module(id)
);

CREATE TABLE Lessons (
groupId integer,
module integer,
professor integer,
room integer,
dayl integer,
timel integer,
CONSTRAINT PK_Lessons PRIMARY KEY (groupid),
CONSTRAINT FK_Lessons_Grp FOREIGN KEY (groupId) REFERENCES Grp(id)
);

CREATE TABLE Professor (
id serial,
name name NOT NULL,
CONSTRAINT PK_Professor PRIMARY KEY (id)
);

CREATE TABLE ModProf (
moduleId integer,
professorId integer,
CONSTRAINT PK_ModProf PRIMARY KEY (moduleId, professorId),
CONSTRAINT FK_ModProf_Module FOREIGN KEY (moduleId) REFERENCES Module(id),
CONSTRAINT FK_ModProf_Professor FOREIGN KEY (professorId) REFERENCES Professor(id)
);

CREATE TABLE Room (
id serial,
number integer NOT NULL,
capacity smallint NOT NULL,
typeRoomId integer,
CONSTRAINT PK_Room PRIMARY KEY (id),
CONSTRAINT FK_Room_TypeRoom FOREIGN KEY (typeRoomId) REFERENCES TypeRoom(id)
);

CREATE TABLE Timeslot (
id serial,
time time NOT NULL,
day char(20) NOT NULL,
CONSTRAINT PK_Timeslot PRIMARY KEY (id)
);
/*заполнение таблицы TypeRoom*/
INSERT INTO TypeRoom (type) 
   VALUES ('Спортзал'),
		('Лаборатория'),
		('Аудитория');
