INSERT INTO Scientist (id, fullName, username, password) VALUES (1, 'Marie Curie', 'marie.curie', 'radioactive');
INSERT INTO Country (id, name, countryCode) VALUES (1, 'Deutschland', 'DEU');
INSERT INTO Country (id, name, countryCode) VALUES (2, 'Vereinigte Staaten', 'USA');
INSERT INTO Country (id, name, countryCode) VALUES (3, 'China', 'CHN');
INSERT INTO Country (id, name, countryCode) VALUES (4, 'Indien', 'IND');
INSERT INTO Co2Data (id, dataYear, emissionValue, country_id, scientist_id) VALUES (1, 2020, 675000, 1, 1);
INSERT INTO Co2Data (id, dataYear, emissionValue, country_id, scientist_id) VALUES (2, 2021, 705000, 1, 1);
INSERT INTO Co2Data (id, dataYear, emissionValue, country_id, scientist_id) VALUES (3, 2020, 4477000, 2, 1);