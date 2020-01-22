DROP DATABASE IF EXISTS bankautomat;

CREATE DATABASE IF NOT EXISTS bankautomat;

USE bankautomat;

CREATE TABLE karte(
	name varchar(18),
    vorname varchar(12),
    iban varchar(26),
    bankbezeichnung varchar(255),
    kartennummer int,
    gueltigbis varchar(5),
    pincode int,
    PRIMARY KEY (iban)
);

CREATE TABLE bank(
	iban varchar(26) UNIQUE,
    gesperrt int(1),
    saldo double,
    bezugslimite int,
	bereitsbezogenesgeld int,
    PRIMARY KEY (iban)
);

CREATE TABLE kartegesperrt(
	iban varchar(26),
    PRIMARY KEY(iban),
    FOREIGN KEY (iban) REFERENCES karte(iban)
);

CREATE TABLE geldkassette(
	note int,
    anzahl int
);

INSERT INTO `geldkassette`(`note`, `anzahl`) VALUES (20,10);
INSERT INTO `geldkassette`(`note`, `anzahl`) VALUES (50,10);
INSERT INTO `geldkassette`(`note`, `anzahl`) VALUES (100,10);
INSERT INTO `geldkassette`(`note`, `anzahl`) VALUES (200,10);

INSERT INTO `karte`(`name`, `vorname`, `iban`, `bankbezeichnung`, `kartennummer`, `gueltigbis`, `pincode`) VALUES ('Flury','Lars','CH56 0087 2077 0176 0442 6','UBS',8546247,'12/20',12345);
INSERT INTO `bank`(`iban`, `gesperrt`, `saldo`, `bezugslimite`, `bereitsbezogenesgeld`) VALUES ('CH56 0087 2077 0176 0442 6',0,3500,2000,0);

INSERT INTO `karte`(`name`, `vorname`, `iban`, `bankbezeichnung`, `kartennummer`, `gueltigbis`, `pincode`) VALUES ('Kindler','Timon','CH25 6528 7418 9852 0456 1','Credit Suisse',7539567,'12/20',11111);
INSERT INTO `bank`(`iban`, `gesperrt`, `saldo`, `bezugslimite`, `bereitsbezogenesgeld`) VALUES ('CH25 6528 7418 9852 0456 1',0,3500,2000,0);

<!-- SELECT karte.iban, kartegesperrt.gesperrt FROM karte INNER JOIN kartegesperrt ON karte.iban=kartegesperrt.iban -->
<!--SELECT karte.iban, kartegesperrt.iban AS 'kartegesperrt IBAN', kartegesperrt.gesperrt, karte.vorname FROM `karte` LEFT JOIN kartegesperrt ON karte.iban = kartegesperrt.iban -->