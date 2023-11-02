USE McdDb;

INSERT INTO `role` (`id`, `name`) VALUES (NULL, 'ROLE_USER');
INSERT INTO `role` (name) VALUE ('ROLE_ADMIN');

INSERT INTO `equipments` (name) VALUE ('Grill');
INSERT INTO `equipments` (name) VALUE ('Sokownik');
INSERT INTO `equipments` (name) VALUE ('Toster');
INSERT INTO `equipments` (name) VALUE ('Monitor');
INSERT INTO `equipments` (name) VALUE ('Kiosk');
INSERT INTO `equipments` (name) VALUE ('Combo');
INSERT INTO `equipments` (name) VALUE ('Kostkarka');
INSERT INTO `equipments` (name) VALUE ('UHC');
INSERT INTO `equipments` (name) VALUE ('Frytownica');

INSERT INTO `restaurants` (address, name) VALUE ('ul. Złota 59', 'Złote Tarasy 300');
INSERT INTO `restaurants` (address, name) VALUE ('al. Jerozolimskie 56', 'Dworzec Centralny 427');
INSERT INTO `restaurants` (address, name) VALUE ('rondo Daszyńskiego 2', 'HUB 558');
INSERT INTO `restaurants` (address, name) VALUE ('al. Jana Pawła II 82', 'Arkadia 260');

INSERT INTO `repair_services` (address, name, phone_number, description) VALUE ('ul. Prosta 32', 'EVRE', '535643726', 'Naprawiają sprzęty na kuchni');
INSERT INTO `repair_services` (address, name, phone_number, description) VALUE ('ul. Śnieżna', 'Primulator', '535937482', 'Serwis do napojów zimnych');
INSERT INTO `repair_services` (address, name, phone_number, description) VALUE ('ul. Krasna 125', 'BEST-CS', '535956373', 'Serwis do ekspresów');
INSERT INTO `repair_services` (address, name, phone_number, description) VALUE ('ul. Marszałkowska 129', 'Serwis Desk', '473846237', 'Serwis do usterek technicznych');

INSERT INTO `users` (enabled, job_title, name, password, surname, restaurant_id, username) VALUE (1, 'Kierownik restauracji', 'Eduard', '$2a$10$lwUSwAYVYwMFzBgxzjZmSu4YVYy9sMFzroEdcmnoBliERfPj30nti', 'Synohub', 1, 'User-E.Synohub');
INSERT INTO `user_role` (user_id, role_id) VALUES (1, 2);

INSERT INTO `users` (enabled, job_title, name, password, surname, restaurant_id, username) VALUE (1, 'Asystent', 'Viktoria', '$2a$10$lwUSwAYVYwMFzBgxzjZmSu4YVYy9sMFzroEdcmnoBliERfPj30nti', 'Synohub', 2, 'Vika');
INSERT INTO `user_role` (user_id, role_id) VALUES (2, 1);


INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (1, 1);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (1, 2);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (1, 3);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (1, 4);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (1, 5);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (1, 6);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (1, 7);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (1, 8);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (1, 9);

INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (2, 1);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (2, 2);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (2, 3);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (2, 4);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (2, 5);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (2, 6);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (2, 7);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (2, 8);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (2, 9);

INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (3, 1);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (3, 2);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (3, 3);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (3, 4);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (3, 5);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (3, 6);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (3, 7);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (3, 8);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (3, 9);

INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (4, 1);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (4, 2);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (4, 3);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (4, 4);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (4, 5);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (4, 6);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (4, 7);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (4, 8);
INSERT INTO `restaurants_equipments` (Restaurant_id, equipments_id) VALUE (4, 9);

INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (1, 1);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (1, 2);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (1, 3);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (1, 4);

INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (2, 1);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (2, 2);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (2, 3);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (2, 4);

INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (3, 1);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (3, 2);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (3, 3);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (3, 4);

INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (4, 1);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (4, 2);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (4, 3);
INSERT INTO `restaurant_repairServices` (restaurant_id, repairService_id) VALUE (4, 4);
