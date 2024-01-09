CREATE DATABASE testmobile;

\c testmobile

CREATE TABLE personne(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(250),
    prenom VARCHAR(250),
    date_naissance DATE
);

CREATE SEQUENCE personne_sequence INCREMENT 1 START 1;

INSERT INTO personne VALUES(nextval('personne_sequence'), 'RANDRIA', 'Steph', '2019-12-12');