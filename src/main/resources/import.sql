--Insert das referencias Geograficas dos Destinos(Aeroporto) e Pontos Aéreos(Referencia)
INSERT INTO ref_geo( latitude, longitude) VALUES ( -30.033056, -50.243056 ); --Aeroporto1
INSERT INTO ref_geo( latitude, longitude) VALUES ( -15.033056, -27.243056 ); --Aeroporto2
INSERT INTO ref_geo( latitude, longitude) VALUES (  20.033056,  10.243056 ); --Aeroporto3
INSERT INTO ref_geo( latitude, longitude) VALUES ( -70.033056, -50.243056 ); --Aeroporto4
INSERT INTO ref_geo( latitude, longitude) VALUES ( -42.033056, -12.243056 ); --Aeroporto5
INSERT INTO ref_geo( latitude, longitude) VALUES ( -27.033056, -19.243056 ); --Referencia1
INSERT INTO ref_geo( latitude, longitude) VALUES ( -19.033056, -40.243056 ); --Referencia2

--Insert das aerovias Onde o nome A indica Aeroporto e R referencia
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA1A2', 800, 1, 2);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA2A1', 800, 2, 1);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA3A4', 500, 3, 4);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA4A5', 200, 4, 5);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA5A3', 650, 5, 3);

Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA1R1', 300, 1, 6);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR1A4', 600, 6, 4);

Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA2R2', 700, 2, 7);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR2A5', 1000, 7, 5);

Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA3R1', 200, 3, 6);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR1A2', 400, 6, 2);

Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA4R1', 200, 4, 6);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR1A3', 150, 6, 3);

Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA5R2', 1000, 5, 7);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR2A1', 860, 7, 1);

--Insert das rotas
Insert into rota(nome, origem ,destino) VALUES ('RotaA1A2', 'A1', 'A2');
Insert into rota(nome, origem ,destino) VALUES ('RotaA2A1', 'A2', 'A1');
Insert into rota(nome, origem ,destino) VALUES ('RotaA3A4', 'A3', 'A4');
Insert into rota(nome, origem ,destino) VALUES ('RotaA4A5', 'A4', 'A5');
Insert into rota(nome, origem ,destino) VALUES ('RotaA5A3', 'A5', 'A3');
Insert into rota(nome, origem ,destino) VALUES ('RotaA1A4', 'A1', 'A4');
Insert into rota(nome, origem ,destino) VALUES ('RotaA2A5', 'A2', 'A5');
Insert into rota(nome, origem ,destino) VALUES ('RotaA3A2', 'A3', 'A2');
Insert into rota(nome, origem ,destino) VALUES ('RotaA4A3', 'A4', 'A3');
Insert into rota(nome, origem ,destino) VALUES ('RotaA5A1', 'A5', 'A1');

--Insert da tabela intermediária ligando aerovias com as rotas

Insert into rota_aerovia(id_rota, id_aerovia) VALUES (1, 1);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (2, 2);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (3, 3);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (4, 4);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (5, 5);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (6, 6);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (6, 7);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (7, 8);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (7, 9);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (8, 10);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (8, 11);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (9, 12);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (9, 13);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (10, 14);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (10, 15);

--Insert dos slots de horarios OBS: Atualmente SOMENTE PARA 1 AEROVIA

insert into slot_horario(horario, aerovia_id) VALUES (0, 1);
insert into slot_horario(horario, aerovia_id) VALUES (1, 1);
insert into slot_horario(horario, aerovia_id) VALUES (2, 1);
insert into slot_horario(horario, aerovia_id) VALUES (3, 1);
insert into slot_horario(horario, aerovia_id) VALUES (4, 1);
insert into slot_horario(horario, aerovia_id) VALUES (5, 1);
insert into slot_horario(horario, aerovia_id) VALUES (6, 1);
insert into slot_horario(horario, aerovia_id) VALUES (7, 1);
insert into slot_horario(horario, aerovia_id) VALUES (8, 1);
insert into slot_horario(horario, aerovia_id) VALUES (9, 1);
insert into slot_horario(horario, aerovia_id) VALUES (10, 1);
insert into slot_horario(horario, aerovia_id) VALUES (11, 1);
insert into slot_horario(horario, aerovia_id) VALUES (12, 1);
insert into slot_horario(horario, aerovia_id) VALUES (13, 1);
insert into slot_horario(horario, aerovia_id) VALUES (14, 1);
insert into slot_horario(horario, aerovia_id) VALUES (15, 1);
insert into slot_horario(horario, aerovia_id) VALUES (16, 1);
insert into slot_horario(horario, aerovia_id) VALUES (17, 1);
insert into slot_horario(horario, aerovia_id) VALUES (18, 1);
insert into slot_horario(horario, aerovia_id) VALUES (19, 1);
insert into slot_horario(horario, aerovia_id) VALUES (20, 1);
insert into slot_horario(horario, aerovia_id) VALUES (21, 1);
insert into slot_horario(horario, aerovia_id) VALUES (22, 1);
insert into slot_horario(horario, aerovia_id) VALUES (23, 1);

