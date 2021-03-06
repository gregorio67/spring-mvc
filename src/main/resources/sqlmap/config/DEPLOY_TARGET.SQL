DROP TABLE DEPLOY_TARGET;

DB NAME :deploy
CREATE TABLE DEPLOY_TARGET
(
	 SEQ					INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , 
     HOST_NAME       		VARCHAR2(50) NOT NULL,
     IP_ADDR				VARCHAR2(50) NOT NULL,
     LISTEN_PORT			INTEGER		 NOT NULL,
     DEPLOY_TYPE			VARCHAR2(50) NOT NULL,
     USE_YN					VARCHAR2(2),
     CONSTRAINT UN_DEPLOY_TARGET unique (HOST_NAME, IP_ADDR, DEPLOY_TYPE),
     CONSTRAINT DEPLOY_TYPE_FK foreign key (DEPLOY_TYPE)
	 references DEPLOY_TYPE(DEPLOY_TYPE)
)

CREATE TABLE DEPLOY_COMMAND
(
	 SEQ					INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , 
     HOST_NAME       		VARCHAR2(50) NOT NULL,
     IP_ADDR				VARCHAR2(50) NOT NULL,
     COMMAND				VARCHAR2(50) NOT NULL,
	 SHELL_COMMAND			VARCHAR2(50),
	 SHELL_NAME				VARCHAR2(50),
	 SHELL_PARAMS			VARCHAR2(50),
     USE_YN					VARCHAR2(2),
     CONSTRAINT UN_DEPLOY_COMMAND unique (HOST_NAME, IP_ADDR, COMMAND)
)

CREATE TABLE DEPLOY_TYPE
(
	 SEQ					INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , 
	 DEPLOY_TYPE			VARCHAR2(50) NOT NULL,
     CONSTRAINT UN_DEPLOY_TYPE unique (DEPLOY_TYPE)
)

INSERT INTO DEPLOY_TYPE VALUES(null, 'WAS');
INSERT INTO DEPLOY_TYPE VALUES(null, 'WEB');
INSERT INTO DEPLOY_TYPE VALUES(null, 'OZ');
INSERT INTO DEPLOY_TYPE VALUES(null, 'BIZACTOR');
INSERT INTO DEPLOY_TYPE VALUES(null, 'BATCH');


INSERT INTO DEPLOY_TARGET VALUES(null, 'PORTAL-WAS', '10.255.84.235', 8080, 'WAS', 'Y');
INSERT INTO DEPLOY_TARGET VALUES(null, 'PORTAL-WAS', '10.255.84.235', 8080, 'BIZACTOR', 'Y');
INSERT INTO DEPLOY_TARGET VALUES(null, 'PORTAL-WAS', '10.255.84.235', 8080, 'OZ', 'Y');

INSERT INTO DEPLOY_TARGET VALUES(null, 'PORTAL-WEB', '10.255.84.234', 8080, 'WEB', 'Y');

INSERT INTO DEPLOY_TARGET VALUES(null, 'PORTAL-WAS', '10.255.84.232', 8080, 'WAS', 'Y');
INSERT INTO DEPLOY_TARGET VALUES(null, 'PORTAL-WAS', '10.255.84.232', 8080, 'BIZACTOR', 'Y');
INSERT INTO DEPLOY_TARGET VALUES(null, 'PORTAL-WAS', '10.255.84.232', 8080, 'OZ', 'Y');

INSERT INTO DEPLOY_TARGET VALUES(null, 'PORTAL-WEB', '10.255.84.231', 8080, 'WEB', 'Y');

INSERT INTO DEPLOY_TARGET VALUES(null, 'IBM-WAS', '10.255.84.230', 8080, 'WAS', 'Y');
INSERT INTO DEPLOY_TARGET VALUES(null, 'IBM-WAS', '10.255.84.230', 8080, 'BIZACTOR', 'Y');
INSERT INTO DEPLOY_TARGET VALUES(null, 'IBM-WAS', '10.255.84.230', 8080, 'OZ', 'Y');

INSERT INTO DEPLOY_TARGET VALUES(null, 'IBM-WEB', '10.255.84.229', 8080, 'WEB', 'Y');

INSERT INTO DEPLOY_TARGET VALUES(null, 'IBM-WAS', '10.255.84.228', 8080, 'WAS', 'Y');
INSERT INTO DEPLOY_TARGET VALUES(null, 'IBM-WAS', '10.255.84.228', 8080, 'BIZACTOR', 'Y');
INSERT INTO DEPLOY_TARGET VALUES(null, 'IBM-WAS', '10.255.84.228', 8080, 'OZ', 'Y');

INSERT INTO DEPLOY_TARGET VALUES(null, 'IBM-WEB', '10.255.84.227', 8080, 'WEB', 'Y');

INSERT INTO DEPLOY_TARGET VALUES(null, 'DSC-WAS', '10.255.84.226', 8080, 'WAS', 'Y');
INSERT INTO DEPLOY_TARGET VALUES(null, 'DSC-WAS', '10.255.84.226', 8080, 'WAS', 'Y');

INSERT INTO DEPLOY_TARGET VALUES(null, 'BATCH', '10.255.84.225', 8080, 'BATCH', 'Y');


INSERT INTO DEPLOY_COMMAND VALUES(null, 'PORTAL-WAS', '10.255.84.235', 'start', 'sh', '/engn001/sehati/portal/tomcat/bin/startPortalSvr.sh', '', 'Y');
INSERT INTO DEPLOY_COMMAND VALUES(null, 'PORTAL-WAS', '10.255.84.235', 'stop', 'sh', '/engn001/sehati/portal/tomcat/bin/stopPortalSvr.sh', '', 'Y');
INSERT INTO DEPLOY_COMMAND VALUES(null, 'PORTAL-WAS', '192.168.11.93', 'deploy', 'java -cp d:/temp', 'ShellTest', '', 'Y');
