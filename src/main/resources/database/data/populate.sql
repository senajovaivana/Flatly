INSERT INTO "developer" (id, login, active)
VALUES (-6, 'Turtle', 'F');
INSERT INTO "developer" (login, active)
VALUES ('A', 'T');
INSERT INTO "developer" (login, active)
VALUES ('G', 'T');
INSERT INTO "developer" (login, active)
VALUES ('I', 'T');
INSERT INTO "developer" (login, active)
VALUES ('Ł', 'T');
INSERT INTO "developer" (login, active)
VALUES ('Crocodile', 'F');
INSERT INTO "developer" (login, active)
VALUES ('Eagle', 'F');
INSERT INTO "developer" (login, active)
VALUES ('Shark', 'F');
INSERT INTO "developer" (login, active)
VALUES ('Tiger', 'F');

INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user1','fgfdgfdgdfgdf', 'Martin', 'King');
INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user2','fgfdgfdgdfgdf', 'Bob', 'Liev');
INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user3','fgfdgfdgdfgdf', 'Karla', 'Huub');
INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user4','fgfdgfdgdfgdf', 'Anna', 'Korta');
INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user5','fgfdgfdgdfgdf', 'Paul', 'Porta');
INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user6','fgfdgfdgdfgdf', 'Jean', 'King');
INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user7','fgfdgfdgdfgdf', 'Lucas', 'Erl');
INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user8','fgfdgfdgdfgdf', 'Hubert', 'Folsk');
INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user9','fgfdgfdgdfgdf', 'Christina', 'Giraman');
INSERT INTO "users" (login,password,first_name,last_name)
VALUES ('user10','fgfdgfdgdfgdf', 'Mary', 'Hungbert');

INSERT INTO "payment_method" (id,name_of_method)
VALUES (1,'cash');
INSERT INTO "payment_method" (id,name_of_method)
VALUES (2,'credit card');
INSERT INTO "payment_method" (id,name_of_method)
VALUES (3,'viamo');

INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (1,'user1', 'Bed and Breakfast',
 '2018-05-01', 'Bed & Breakfast is housed in a 400-year-old town house, located in the Canal District in the ' ||
'Amsterdam city center. It offers modern decorated rooms with amenities such as Smart- TV and free WiFi.',
'Amsterdam', 'Kerkstraat', '62', '1017 GA', 'Netherlands', 100, '13:00', '23:00', '12:00', 4);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (2,'user2', 'Amsterdam Downtown Hotel', '2019-01-21',
'This non-smoking hotel provides accommodation in the heart of Amsterdam, a 5-minute walk from' ||
' Leidse Square and the Flower Market. Free Wi-Fi is available throughout the hotel.',
'Amsterdam', 'Kerkstraat', '25', '1017 GA', 'Netherlands', 60, '14:00', '23:59', '10:00', 2);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (3,'user3', 'Nice apartment in the center of Warsaw',
'2018-08-01', 'These apartments in Berlins city centre offer free Wi-Fi, self-catering kitchens,' ||
' and good transport links. Sights including the Museum Island are within easy reach.',
'Berlín', 'Prentzlauer street', '7', '10243', 'Germany', 45, '13:00', '22:00', '12:00', 2);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (4,'user4', 'Junckers Hotel',  '2019-10-01', 'Located in Berlins trendy Friedrichshain district, ' ||
'this traditional hotel is a 5-minute walk from Frankfurter Tor Underground Station. Free Wi-Fi and a cosy bar are' ||
' offered here.', 'Berlín', 'Grünberger', '21', '10243', 'Germany', 100, '13:00', '23:59', '11:00', 2);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (5,'user5', 'Apartment for 2 in Warsaw',
'2019-10-04', 'Flat includes shared bathroom fitted with a bath or4shower.
Extras include free toiletries and a hairdryer. We also offer free WiFi.
There is a shared kitchen at the property with space to cook and a lounge with a kettle,
microwave and complementary tea and coffee.', 'Warsaw', 'Grybowska', '39', '00-864',
'Poland', 100, '14:00', '23:59', '10:00', 2);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (6,'user5', 'ArtStudio Zielona', '2019-04-01',
'Set in Warsaw, ArtStudio Zielona offers free WiFi, 4.4 km from Wilanow Palace and 5 km from Lazienki Palace.
There is a fully equipped kitchen and a private bathroom. Frideric Chopins Monument is 5 km from the apartment, ' ||
'while Royal Łazienki Park is 6 km away. The nearest airport is Warsaw Frederic Chopin Airport, 9 km from the apartment.',
'Warsaw', 'Zielona', '44', '00-864', 'Poland', 80, '14:00', '23:59', '10:00', 2);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (7,'user6', 'Apartment in the Warsaw',
'2019-08-01', 'Flat includes shared bathroom fitted with a bath or4shower.
Extras include free toiletries and a hairdryer. We also offer free WiFi.
There is a shared kitchen at the property with space to cook and a lounge with a kettle,
microwave and complementary tea and coffee.', 'Warsaw', 'Grybowska', '37', '00-864',
'Poland', 100, '14:00', '23:59', '10:00', 4);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (8,'user7', 'Apartment in the center of Krakow',
'2017-01-01', 'Boasting garden views, Jewish Quarter Comfort - In City Apartments ' ||
'features accommodation with a patio and a kettle, around 1.8 km from Wawel Royal Castle.',
'Krakow', 'Krakowskia street', '54', '30-007', 'Poland', 150, '13:00', '23:59', '11:00', 5);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (9,'user8', 'Villa Moko', '2019-10-01',
'Set in Warsaw, 5 km from Frideric Chopins Monument, Villa Moko offers accommodation ' ||
'with a shared lounge, free private parking, a garden and barbecue facilities.',
'Warsaw', 'Mokotowska street', '78', '00-864', 'Poland', 60, '14:00', '23:59', '11:00', 3);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (10,'user9', 'ClickTheFlat apartment room',
'2019-01-01', 'Conveniently located in the Sródmiescie district of Warsaw.' ||
'Free WiFi is available and private parking can be arranged at an extra charge.' ||
'The shared bathroom is fitted with a shower and a hairdryer.Nowy Świat Street is 2.7 km from the hostel, ' ||
'while Saxon Garden is 2.9 km from the property. The nearest airport is Warsaw Frederic Chopin Airport, ' ||
 '9 km from the flat.', 'Warsaw', 'Hoza street', '2', '00-864', 'Poland', 80, '15:00', '23:00', '12:00', 2);
INSERT INTO "room" (id,owner_of_room,name_of_room,start_date,
description,city,street,number_of_street,zip_code,country,price,
check_in_from,check_in_to,check_out,limit_of_quests)
VALUES (11,'user10', 'Bed4city Szpitalna Street',
'2018-10-01', 'Bed4city Szpitalna Street is a self-catering accommodation located in Warsaw’s city centre,' ||
' a 5-minute walk from the popular Nowy Świat Street and a 7-minute walk from the Palace of Culture.',
 'Warsaw', 'Szpitalna street', '20', '00-864', 'Poland', 20, '15:00', '23:00', '12:00', 1);

INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (1,1);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (1,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (1,3);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (2,1);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (2,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (2,3);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (3,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (3,3);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (4,1);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (4,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (5,1);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (5,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (5,3);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (6,1);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (6,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (7,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (7,3);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (8,1);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (8,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (9,1);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (9,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (10,2);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (10,1);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (10,3);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (11,1);
INSERT INTO "payment_method_of_room" (id_room,id_payment_method)
VALUES (11,2);

INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person1', '2018-06-01', '2018-06-03', 1);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person1', '2019-07-21', '2019-07-22', 2);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person2', '2019-09-01', '2019-09-05', 1);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person3', '2018-09-01', '2018-09-02', 3);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person4', '2019-12-25', '2019-12-26', 4);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person5', '2019-10-04', '2019-10-06', 4);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person5', '2019-12-27', '2019-12-28', 5);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person2', '2019-12-04', '2019-12-08', 6);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person6', '2019-11-21', '2019-11-23', 7);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person7', '2017-01-02', '2017-01-03', 8);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person8', '2019-10-21', '2019-10-22', 9);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person9', '2019-06-30', '2019-07-01', 10);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person10', '2020-01-29', '2020-01-30', 11);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person2', '2018-09-01', '2018-09-03', 1);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person3', '2019-10-01', '2018-10-03', 3);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person7', '2019-12-02', '2019-12-04', 4);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person5', '2019-11-17', '2019-11-20', 5);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person11', '2019-10-13', '2019-10-15', 6);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person15', '2019-10-25', '2019-10-26', 5);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person12', '2019-05-06', '2019-05-11', 6);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person13', '2019-12-01', '2019-12-03', 7);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person4', '2018-03-04', '2018-03-09', 8);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person1', '2019-01-08', '2019-01-09', 8);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person3', '2019-03-10', '2019-03-11', 8);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person7', '2019-06-01', '2019-06-20', 8);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person14', '2019-12-01', '2019-12-06', 9);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person9', '2019-08-01', '2019-08-05', 10);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person15', '2018-12-01', '2018-12-03', 11);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person15', '2019-03-21', '2019-03-22', 11);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person1', '2019-11-20', '2019-11-24', 11);
INSERT INTO "booking" (owner_of_booking,start_date,end_date,item_id)
VALUES ('person15', '2020-01-27', '2020-01-30', 2);

INSERT INTO "room_image" (id_room,content)
VALUES (1,'');
INSERT INTO "room_image" (id_room,content)
VALUES (2,'');
INSERT INTO "room_image" (id_room,content)
VALUES (2,'');
INSERT INTO "room_image" (id_room,content)
VALUES (3,'');
INSERT INTO "room_image" (id_room,content)
VALUES (3,'');
INSERT INTO "room_image" (id_room,content)
VALUES (3,'');
INSERT INTO "room_image" (id_room,content)
VALUES (4,'');
INSERT INTO "room_image" (id_room,content)
VALUES (4,'');
INSERT INTO "room_image" (id_room,content)
VALUES (5,'');
INSERT INTO "room_image" (id_room,content)
VALUES (6,'');
INSERT INTO "room_image" (id_room,content)
VALUES (7,'');
INSERT INTO "room_image" (id_room,content)
VALUES (7,'');
INSERT INTO "room_image" (id_room,content)
VALUES (9,'');
INSERT INTO "room_image" (id_room,content)
VALUES (10,'');
INSERT INTO "room_image" (id_room,content)
VALUES (10,'');

