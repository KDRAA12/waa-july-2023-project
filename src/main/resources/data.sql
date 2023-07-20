--DO $$
--BEGIN
--	  IF NOT EXISTS (SELECT * FROM role  WHERE name = 'admin') THEN
--	   INSERT INTO role (id, name) VALUES (1, 'admin'), (2, 'faculty'), (3, 'student');
--	   SELECT SETVAL('role_seq',3);
--	  END IF;
--END $$



INSERT INTO role (id, name) VALUES (1, 'admin');
INSERT INTO role (id, name) VALUES (2, 'faculty');
INSERT INTO role (id, name) VALUES (3, 'student');

INSERT INTO tag (id, label, color) VALUES
                                                 (1, 'Information Technology (IT)'),
                                                 (2, 'Marketing and Advertising'),
                                                 (3, 'Finance and Accounting'),
                                                 (4, 'Sales and Business Development'),
                                                 (5, 'Human Resources (HR)'),
                                                 (6, 'Healthcare and Medical'),
                                                 (7, 'Education and Teaching'),
                                                 (8, 'Engineering and Technology'),
                                                 (9, 'Creative Arts and Design'),
                                                 (10, 'Customer Service and Support');

SELECT SETVAL('role_seq',3);