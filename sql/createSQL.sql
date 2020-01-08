CREATE DATABASE IF NOT EXISTS bankautomat;

USE bankautomat;

CREATE TABLE karte(
	name varchar(255),
    vorname varchar(255),
    kontonummer int,
    iban varchar(34),
    bankbezeichnung varchar(255),
    kartennummer int,
    gueltigbis varchar(5),
    pincode int,
    PRIMARY KEY (iban)
);

CREATE TABLE bank(
	iban varchar(34) UNIQUE,
    gesperrt int(1),
    saldo double,
    bezugslimite int,
    PRIMARY KEY (iban)
);

CREATE TABLE kartegesperrt(
	iban varchar(34),
    gesperrt int(1),
    PRIMARY KEY(iban),
    FOREIGN KEY (iban) REFERENCES karte(iban)
);

CREATE TABLE geldkassette(
	note int,
    anzahl int
);

<!-- SELECT karte.iban, kartegesperrt.gesperrt FROM karte INNER JOIN kartegesperrt ON karte.iban=kartegesperrt.iban -->
<!--SELECT karte.iban, kartegesperrt.iban AS 'kartegesperrt IBAN', kartegesperrt.gesperrt, karte.vorname FROM `karte` LEFT JOIN kartegesperrt ON karte.iban = kartegesperrt.iban -->