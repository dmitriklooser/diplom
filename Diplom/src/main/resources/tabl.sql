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

CREATE TABLE Module (
id serial,
code name NOT NULL,
name varchar(5) NOT NULL,
typeRoom varchar(20),
CONSTRAINT PK_Module PRIMARY KEY (id)
);

CREATE TABLE GrpMod (
groupId integer,
moduleId integer,
CONSTRAINT PK_GrpMod PRIMARY KEY(groupId, moduleId),
CONSTRAINT FK_GrpMod_Grp FOREIGN KEY (groupId) REFERENCES Grp(id),
CONSTRAINT FK_GrpMod_Module FOREIGN KEY (moduleId) REFERENCES Module(id)
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
typeRoom varchar(20),
CONSTRAINT PK_Room PRIMARY KEY (id)
);

CREATE TABLE Timeslot (
id serial,
lessontime integer NOT NULL,
day varchar(20) NOT NULL,
CONSTRAINT PK_Timeslot PRIMARY KEY (id)
);

CREATE TABLE Lessons (
groupId integer,
moduleId integer,
professorId integer,
roomId integer,
timeslotId integer,
CONSTRAINT PK_Lessons PRIMARY KEY (groupId),
CONSTRAINT FK_Lessons_Grp FOREIGN KEY (groupId) REFERENCES Grp(id),
CONSTRAINT FK_Lessons_Timeslot FOREIGN KEY (timeslotId) REFERENCES Timeslot(id),
CONSTRAINT FK_Lessons_Module FOREIGN KEY (moduleId) REFERENCES Module(id),
CONSTRAINT FK_Lessons_Professor FOREIGN KEY (professorId) REFERENCES Professor(id),
CONSTRAINT FK_Lessons_Room FOREIGN KEY (roomId) REFERENCES Room(id)
);
