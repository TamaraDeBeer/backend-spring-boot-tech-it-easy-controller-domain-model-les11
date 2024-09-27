INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold)
    VALUES (5000, '43PFS6808', 'Philips', 'Philips TV5000', 349, 43, 50, 'LED-LCD', 'Standaard', true, true, false, false, false, false, 6000, 1000),
           (5001, '55Q74B', 'Samsung', 'Samsung QLED', 779, 55, 100, 'LED-LCD', 'Goed', true, true, true, true, true, true, 6001, 1111),
           (5002, 'XR-55A80L', 'Sony', 'Sony Bravia', 5079, 83, 100, 'OLED', 'Uitstekend', true, true, true, true, true, true, 6002, 100),
           (5003, '65PUS8808', 'Philips', 'Philips The One', 1199, 65, 100, 'LED-LCD', 'Goed', true, true, true, true, false, true, 6003, 3854),
           (5004, '48C34LA', 'LG', 'LG OLED', 1359, 48, 100, 'OLED', 'Uitstekend', true, true, true, true, true, true, 6004, 589),
           (5005, '65UA2263DG', 'Toshiba', 'Toshibam', 499, 65, 50, 'LED-LCD', 'Standaard', true, false, true, true, false, false, 6005, 5555);

INSERT INTO ci_modules (id, name, type, price)
    VALUES (6000, 'SMiT CI+ 1.3 Interactieve Ziggo Module', 'YC9686', 80),
           (6001, 'Quantis CI+ 1.3 Interactieve Module', '130004', 70);

INSERT INTO remote_controls (id, name, brand, battery_type, price, original_stock, compatible_with)
    VALUES (7000, 'Apple Siri Remote', 'Apple', 'Unknown', 69, 8000, 4568),
           (7001, 'One For All URC7935', 'One for All', 'AAA', 27.99, 8001, 325),
           (7002, 'Philips Universele Afstandsbediening', 'Philips', 'AAA', 9.99, 8002, 8000),
           (7003, 'Philips Senioren Afstandsbediening', 'Unknown', 'AAA', 19.95, 8003, 100),
           (7004, 'Ziggo Mediabox Next', 'Ziggo', 'AA', 16.95, 8004, 987),
           (7005, 'Sony Ultra Remote Control', 'Sony', 'AAA', 95, 8005, 456);

INSERT INTO wall_brackets (id, name, size, adjustable, price)
    VALUES (8000, 'TVM 7675 Elektrische tv-muurbeugel', '40-77 inch', true, 899),
           (8001, 'BlueBuilt', '48-75 inch', true, 112),
           (8002, 'Vogel''s Comfort 3465 OLED', '32-65 inch', false, 169),
           (8003, 'Hama Full Motion XL 3 sterren', '39-65 inch', false, 89),
           (8004, 'Samsung Auto Rotating Wallmount VG-ARAB22WMTXC', '43-55 inch', true, 333),
           (8005, 'Neomounts by Newstar', '32-75 inch', true, 90),
           (8006, 'Wolff Mount', '80-90 inch', true, 199);

UPDATE televisions SET compatible_remote_controls = 7000 WHERE id = 5004;
UPDATE televisions SET compatible_remote_controls = 7001 WHERE id = 5005;
UPDATE televisions SET compatible_remote_controls = 7002 WHERE id = 5000;
UPDATE televisions SET compatible_remote_controls = 7003 WHERE id = 5003;
UPDATE televisions SET compatible_remote_controls = 7004 WHERE id = 5001;
UPDATE televisions SET compatible_remote_controls = 7005 WHERE id = 5002;

UPDATE televisions SET compatible_ci_module = 6000 WHERE id = 5000;
UPDATE televisions SET compatible_ci_module = 6000 WHERE id = 5001;
UPDATE televisions SET compatible_ci_module = 6000 WHERE id = 5002;
UPDATE televisions SET compatible_ci_module = 6000 WHERE id = 5003;
UPDATE televisions SET compatible_ci_module = 6000 WHERE id = 5004;
UPDATE televisions SET compatible_ci_module = 6001 WHERE id = 5000;
UPDATE televisions SET compatible_ci_module = 6001 WHERE id = 5003;
UPDATE televisions SET compatible_ci_module = 6001 WHERE id = 5005;


INSERT INTO televisions_wall_brackets_list (televisions_list_id, wall_brackets_list_id)
VALUES (5000, 8000), (5000, 8002), (5000, 8003), (5000, 8004), (5000, 8005),
       (5001, 8000), (5001, 8001), (5001, 8002), (5001, 8003), (5001, 8004), (5001, 8005),
       (5002, 8006),
       (5003, 8000), (5003, 8001), (5003, 8002), (5003, 8003), (5003, 8005),
       (5004, 8000), (5004, 8001), (5004, 8002), (5004, 8003), (5004, 8004), (5004, 8005),
       (5005, 8000), (5005, 8001), (5005, 8002), (5005, 8003), (5005, 8004), (5005, 8005);

INSERT INTO authorities (username, authority)
    VALUES ('Knabbel', 'ROLE_USER'),
           ('Babbel', 'ROLE_ADMIN');

INSERT INTO users (username, password, email, enabled)
    VALUES ('Knabbel', '$2a$1', 'knabbel@test.nl', true),
           ('Babbel', '$2a$1', 'babbel@test.nl', true);