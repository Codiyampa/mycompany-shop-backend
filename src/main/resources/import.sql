INSERT INTO Category(id, name) VALUES(1, 'Trockenfrüchte');
INSERT INTO Category(id, name) VALUES(2, 'Bio');
INSERT INTO Product(id, name, price) VALUES(1, 'Getrocknete Apfelstücke 500 Gramm', 7.99);
INSERT INTO Product(id, name, price) VALUES(2, 'Getrocknete Bananenstücke 500 Gramm', 7.99);
INSERT INTO Product(id, name, price) VALUES(3, 'Getrocknete Pflaumenstücke Bio 500 Gramm', 9.99);
INSERT INTO product_category(product_id, category_id) VALUES(1, 1);
INSERT INTO product_category(product_id, category_id) VALUES(2, 1);
INSERT INTO product_category(product_id, category_id) VALUES(3, 1);
INSERT INTO product_category(product_id, category_id) VALUES(3, 2);