CREATE TABLE APPUSER (
  id NUMBER(9) PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50),
  address VARCHAR(255),
  password VARCHAR(20),
  newsletter NUMBER(1),
  framework VARCHAR(500),
  sex VARCHAR(1),
  NUM NUMBER(9),
  COUNTRY VARCHAR(10),
  SKILL VARCHAR(500)
);


INSERT INTO APPUSER (id, name, email, framework) VALUES (1, 'mkyong', 'mkyong@gmail.com', 'Spring MVC, GWT');
INSERT INTO APPUSER (id, name, email, framework) VALUES (2, 'alex', 'alex@yahoo.com', 'Spring MVC, GWT');
INSERT INTO APPUSER (id, name, email, framework) VALUES (3, 'joel', 'joel@gmail.com', 'Spring MVC, GWT');



COMMIT;