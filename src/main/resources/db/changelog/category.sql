-- liquibase formatted sql

-- changeset Muzaffar-Ashurov:populate-category-table
INSERT INTO `eshop`.`category` (name) VALUES
('fruits'),
('food'),
('clothes');