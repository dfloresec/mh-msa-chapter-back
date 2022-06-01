--insert values into region table
INSERT INTO region (region_id, region_name) VALUES (1, 'Europe');
INSERT INTO region (region_id, region_name) VALUES (2, 'Americas');
INSERT INTO region (region_id, region_name) VALUES (3, 'Asia');
INSERT INTO region (region_id, region_name) VALUES (4, 'Middle East and Africa');

--insert values into country table
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (1,'IT', 'Italy', 1);
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (2, 'FR', 'France', 1);
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (3, 'DE', 'Germany', 1);
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (4, 'US', 'United States of America', 2);
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (5, 'CA', 'Canada', 2);
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (6, 'JP', 'Japan', 3);
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (7, 'IN', 'India', 3);
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (8, 'CN', 'China', 3);
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (9, 'ZM', 'Zambia', 4);
INSERT INTO country (country_id, country_code, country_name, region_id) VALUES (10, 'EG', 'Egypt', 4);

-- Insert values into location
INSERT INTO location (location_id, street_address, postal_code, city, state_province, country_id) VALUES (1, '1297 Via Cola di Rie', '00989', 'Roma', null, 1);
INSERT INTO location (location_id, street_address, postal_code, city, state_province, country_id) VALUES (2, 'Paris', '00989', 'Paris', null, 2);
INSERT INTO location (location_id, street_address, postal_code, city, state_province, country_id) VALUES (3, 'Berlin', '00989', 'Berlin', null, 3);
INSERT INTO location (location_id, street_address, postal_code, city, state_province, country_id) VALUES (4, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 4);
INSERT INTO location (location_id, street_address, postal_code, city, state_province, country_id) VALUES (5, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 5);
INSERT INTO location (location_id, street_address, postal_code, city, state_province, country_id) VALUES (6, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 5);

--insert values into department table
INSERT INTO department (department_id, department_name, location_id) VALUES (1, 'Sales', 1);
INSERT INTO department (department_id, department_name, location_id) VALUES (2, 'Purchasing', 2);
INSERT INTO department (department_id, department_name, location_id) VALUES (3, 'Marketing', 3);
INSERT INTO department (department_id, department_name, location_id) VALUES (4, 'Administration', 4);

-- insert values into employee
INSERT INTO employee (employee_id, first_name, last_name, email, department_id) VALUES (1, 'Steven', 'King', 'sking@test.com', 1);
INSERT INTO employee (employee_id, first_name, last_name, email, department_id) VALUES (2, 'Ram', 'King', 'lakshman@test.com', 2);
INSERT INTO employee (employee_id, first_name, last_name, email, department_id) VALUES (3, 'Edward', 'Romiro', 'redward@test.com', 3);
