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
inuse boolean DEFAULT false NOT NULL,
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

INSERT INTO Timeslot (lessontime, day) 
   VALUES (9, 'MONDAY'),
		(11, 'MONDAY'),
		(13, 'MONDAY'),
		(15, 'MONDAY'),
		(17, 'MONDAY'),
		(9, 'TUESDAY'),
		(11, 'TUESDAY'),
		(13, 'TUESDAY'),
		(15, 'TUESDAY'),
		(17, 'TUESDAY'),
		(9, 'WEDNESDAY'),
		(11, 'WEDNESDAY'),
		(13, 'WEDNESDAY'),
		(15, 'WEDNESDAY'),
		(17, 'WEDNESDAY'),
		(9, 'THURSDAY'),
		(11, 'THURSDAY'),
		(13, 'THURSDAY'),
		(15, 'THURSDAY'),
		(17, 'THURSDAY'),
		(9, 'FRIDAY'),
		(11, 'FRIDAY'),
		(13, 'FRIDAY'),
		(15, 'FRIDAY'),
		(17, 'FRIDAY'),
		(9, 'SATURDAY'),
		(11, 'SATURDAY'),
		(13, 'SATURDAY'),
		(15, 'SATURDAY'),
		(17, 'SATURDAY');