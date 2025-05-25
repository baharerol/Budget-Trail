-- Yurt İçi Şehirler
INSERT INTO cities (name, country, region, daily_cost, description, image_url) VALUES
('İstanbul', 'Türkiye', 'Yurt İçi', 1500.0, 'İki kıtayı birleştiren, tarihi ve modern yüzüyle dünyanın en özel şehirlerinden biri. Ayasofya, Topkapı Sarayı, Kapalıçarşı gibi tarihi mekanların yanı sıra modern alışveriş merkezleri ve eğlence mekanlarıyla zengin bir deneyim sunar.', 'https://images.unsplash.com/photo-1524231757912-21f4fe3a7200'),
('Kapadokya', 'Türkiye', 'Yurt İçi', 1200.0, 'Peri bacaları, balon turları ve tarihi yeraltı şehirleriyle eşsiz bir deneyim. Doğal güzellikleri ve tarihi dokusuyla unutulmaz bir seyahat vaat eder.', 'https://images.unsplash.com/photo-1633613286991-611fe299c4be'),
('Antalya', 'Türkiye', 'Yurt İçi', 1300.0, 'Turkuaz sahilleri, antik kentleri ve modern tesisleriyle Akdeniz''in incisi. Kültür turizmi ve deniz tatilini bir arada sunar.', 'https://images.unsplash.com/photo-1570077188670-e3a8d69ac5ff'),
('İzmir', 'Türkiye', 'Yurt İçi', 1100.0, 'Ege''nin incisi, kordon boyu, antik kentleri ve lezzetli mutfağıyla zengin bir kültür deneyimi sunar.', 'https://images.unsplash.com/photo-1599571234909-29ed5d1321d6'),
('Trabzon', 'Türkiye', 'Yurt İçi', 1000.0, 'Karadeniz''in eşsiz doğası, tarihi Ayasofya''sı ve Uzungöl''ü ile doğa ve kültür turizminin buluşma noktası.', 'https://images.unsplash.com/photo-1599571234909-29ed5d1321d6');

-- Avrupa Şehirleri
INSERT INTO cities (name, country, region, daily_cost, description, image_url) VALUES
('Paris', 'Fransa', 'Avrupa', 2500.0, 'Aşkın, sanatın ve modanın başkenti. Eyfel Kulesi, Louvre Müzesi ve Notre Dame Katedrali gibi ikonik yapılarıyla unutulmaz bir deneyim sunar.', 'https://images.unsplash.com/photo-1502602898657-3e91760cbb34'),
('Roma', 'İtalya', 'Avrupa', 2200.0, 'Antik Roma''nın izlerini taşıyan, Kolezyum, Vatikan ve Trevi Çeşmesi gibi tarihi yapılarıyla açık hava müzesi niteliğinde bir şehir.', 'https://images.unsplash.com/photo-1552832230-c0197dd311b5'),
('Barselona', 'İspanya', 'Avrupa', 2000.0, 'Gaudi''nin eserleri, canlı sokakları ve Akdeniz iklimiyle İspanya''nın en renkli şehirlerinden biri.', 'https://images.unsplash.com/photo-1583422409516-2895a77efded'),
('Amsterdam', 'Hollanda', 'Avrupa', 2300.0, 'Kanalları, bisiklet kültürü ve özgürlükçü yapısıyla benzersiz bir Avrupa deneyimi sunan şehir.', 'https://images.unsplash.com/photo-1512470876302-972faa2aa9a4'),
('Viyana', 'Avusturya', 'Avrupa', 2100.0, 'Klasik müzik, opera ve kafeleriyle Avrupa''nın kültür başkentlerinden biri.', 'https://images.unsplash.com/photo-1516550893923-42d28e5677af');

-- Asya Şehirleri
INSERT INTO cities (name, country, region, daily_cost, description, image_url) VALUES
('Tokyo', 'Japonya', 'Asya', 2800.0, 'Gelecek ve geleneğin iç içe geçtiği, teknoloji ve kültürün harmanlandığı dinamik bir metropol.', 'https://images.unsplash.com/photo-1540959733332-eab4deabeeaf'),
('Bangkok', 'Tayland', 'Asya', 1800.0, 'Tayland''ın başkenti, tapınakları, sokak yemekleri ve canlı gece hayatıyla Asya''nın en renkli şehirlerinden biri.', 'https://images.unsplash.com/photo-1508009603885-50cf7c579365'),
('Seul', 'Güney Kore', 'Asya', 2200.0, 'Geleneksel Kore kültürü ve modern teknolojinin buluştuğu, alışveriş ve eğlencenin merkezi.', 'https://images.unsplash.com/photo-1538485399081-7c8ed730643d'),
('Singapur', 'Singapur', 'Asya', 3000.0, 'Ultra modern yapıları, temiz sokakları ve zengin mutfağıyla Asya''nın en gelişmiş şehirlerinden biri.', 'https://images.unsplash.com/photo-1525625293386-3f8f99389edd'),
('Hanoi', 'Vietnam', 'Asya', 1500.0, 'Vietnam''ın başkenti, sokak yemekleri, tarihi yapıları ve renkli pazarlarıyla otantik bir Asya deneyimi sunar.', 'https://images.unsplash.com/photo-1583417319070-4a69db38a482');

-- Şehir aktiviteleri
INSERT INTO city_activities (city_id, activity) VALUES
-- İstanbul
(1, 'Kültür'), (1, 'Macera'), (1, 'Dinlenme'),
-- Kapadokya
(2, 'Macera'), (2, 'Kültür'),
-- Antalya
(3, 'Dinlenme'), (3, 'Kültür'), (3, 'Macera'),
-- İzmir
(4, 'Kültür'), (4, 'Dinlenme'),
-- Trabzon
(5, 'Kültür'), (5, 'Macera'),
-- Paris
(6, 'Kültür'), (6, 'Dinlenme'),
-- Roma
(7, 'Kültür'), (7, 'Dinlenme'),
-- Barselona
(8, 'Kültür'), (8, 'Macera'), (8, 'Dinlenme'),
-- Amsterdam
(9, 'Kültür'), (9, 'Macera'),
-- Viyana
(10, 'Kültür'), (10, 'Dinlenme'),
-- Tokyo
(11, 'Kültür'), (11, 'Macera'),
-- Bangkok
(12, 'Kültür'), (12, 'Macera'), (12, 'Dinlenme'),
-- Seul
(13, 'Kültür'), (13, 'Macera'),
-- Singapur
(14, 'Kültür'), (14, 'Dinlenme'),
-- Hanoi
(15, 'Kültür'), (15, 'Macera'); 