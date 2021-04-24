/*
 Navicat Premium Data Transfer

 Source Server         : local-db
 Source Server Type    : PostgreSQL
 Source Server Version : 130002
 Source Host           : localhost:5432
 Source Catalog        : aplikasi-kasir-db
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130002
 File Encoding         : 65001

 Date: 24/04/2021 23:59:24
*/


-- ----------------------------
-- Sequence structure for category_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."category_id_seq";
CREATE SEQUENCE "public"."category_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 987654321
START 1
CACHE 1;
ALTER SEQUENCE "public"."category_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for product_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."product_id_seq";
CREATE SEQUENCE "public"."product_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 987654321
START 1
CACHE 1;
ALTER SEQUENCE "public"."product_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for shopping_chart_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."shopping_chart_id_seq";
CREATE SEQUENCE "public"."shopping_chart_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 987654321
START 1
CACHE 1;
ALTER SEQUENCE "public"."shopping_chart_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS "public"."category";
CREATE TABLE "public"."category" (
  "category_id" int8 NOT NULL,
  "category_name" varchar(50) COLLATE "pg_catalog"."default",
  "created_by" int8,
  "created_on" timestamp(6),
  "last_modified_by" int8,
  "last_modified_on" timestamp(6),
  "is_deleted" bool
)
;
ALTER TABLE "public"."category" OWNER TO "postgres";

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO "public"."category" VALUES (3, 'Makanan', 1, '2021-04-24 17:41:16.341', 1, '2021-04-24 17:41:16.341', 'f');
INSERT INTO "public"."category" VALUES (4, 'Minuman', 1, '2021-04-24 17:41:25.43', 1, '2021-04-24 17:41:25.43', 'f');
INSERT INTO "public"."category" VALUES (5, 'Cemilan', 1, '2021-04-24 17:41:30.232', 1, '2021-04-24 17:41:30.232', 'f');
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS "public"."product";
CREATE TABLE "public"."product" (
  "product_id" int8 NOT NULL,
  "product_name" varchar(50) COLLATE "pg_catalog"."default",
  "product_photo" text COLLATE "pg_catalog"."default",
  "product_price" numeric,
  "category_id" int8,
  "created_by" int8,
  "created_on" timestamp(6),
  "last_modified_by" int8,
  "last_modified_on" timestamp(6),
  "is_deleted" bool,
  "product_code" varchar(15) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."product" OWNER TO "postgres";

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO "public"."product" VALUES (11, 'Keripik Singkong', 'keripik-singkong.jpeg', 4000, 5, 1, '2021-04-24 17:46:37.194', 1, '2021-04-24 17:46:37.194', 'f', 'CML-001');
INSERT INTO "public"."product" VALUES (12, 'Keripik Ubi', 'keripik-ubi.jpeg', 4000, 5, 1, '2021-04-24 17:46:45.704', 1, '2021-04-24 17:46:45.704', 'f', 'CML-002');
INSERT INTO "public"."product" VALUES (13, 'Keripik Kentang', 'keripik-kentang.jpeg', 5000, 5, 1, '2021-04-24 17:46:57.155', 1, '2021-04-24 17:46:57.155', 'f', 'CML-003');
INSERT INTO "public"."product" VALUES (3, 'Mie Ayam', 'mie-ayam.jpeg', 12000, 3, 1, '2021-04-24 17:43:13.502', 1, '2021-04-24 17:43:13.502', 'f', 'MKN-002');
INSERT INTO "public"."product" VALUES (2, 'Bakso Urat', 'bakso.jpeg', 10000, 3, 1, '2021-04-24 17:42:57.071', 1, '2021-04-24 17:42:57.071', 'f', 'MKN-001');
INSERT INTO "public"."product" VALUES (7, 'Tahu Gejrot', 'tahu-gejrot.jpeg', 6000, 3, 1, '2021-04-24 17:45:00.47', 1, '2021-04-24 17:45:00.47', 'f', 'MKN-006');
INSERT INTO "public"."product" VALUES (6, 'Ketoprak', 'ketoprak.jpeg', 11000, 3, 1, '2021-04-24 17:44:28.074', 1, '2021-04-24 17:44:28.074', 'f', 'MKN-005');
INSERT INTO "public"."product" VALUES (5, 'Tahu Telur', 'tahu-telur.jpeg', 15000, 3, 1, '2021-04-24 17:44:03.897', 1, '2021-04-24 17:44:03.897', 'f', 'MKN-004');
INSERT INTO "public"."product" VALUES (4, 'Seblak', 'seblak.jpeg', 18000, 3, 1, '2021-04-24 17:43:37.921', 1, '2021-04-24 17:43:37.921', 'f', 'MKN-003');
INSERT INTO "public"."product" VALUES (10, 'Air Mineral', 'air-mineral.jpeg', 6000, 4, 1, '2021-04-24 17:46:12.929', 1, '2021-04-24 17:46:12.929', 'f', 'MNM-003');
INSERT INTO "public"."product" VALUES (8, 'Es Teh', 'es-teh.jpeg', 3000, 4, 1, '2021-04-24 17:45:34.883', 1, '2021-04-24 17:45:34.883', 'f', 'MNM-001');
INSERT INTO "public"."product" VALUES (9, 'Jus Jeruk', 'es-jeruk.jpeg', 6000, 4, 1, '2021-04-24 17:45:54.534', 1, '2021-04-24 17:45:54.534', 'f', 'MNM-002');
INSERT INTO "public"."product" VALUES (37, 'Keripik Tales', 'keripik-tales.jpeg', 5000, 5, 1, '2021-04-24 18:26:46.144', 1, '2021-04-24 18:26:46.144', 'f', 'CML-004');
COMMIT;

-- ----------------------------
-- Table structure for shopping_chart
-- ----------------------------
DROP TABLE IF EXISTS "public"."shopping_chart";
CREATE TABLE "public"."shopping_chart" (
  "shopping_chart_id" int8 NOT NULL,
  "total" int4,
  "price" numeric,
  "product_id" int8
)
;
ALTER TABLE "public"."shopping_chart" OWNER TO "postgres";

-- ----------------------------
-- Records of shopping_chart
-- ----------------------------
BEGIN;
INSERT INTO "public"."shopping_chart" VALUES (18, 2, 12000, 10);
INSERT INTO "public"."shopping_chart" VALUES (19, 1, 4000, 11);
INSERT INTO "public"."shopping_chart" VALUES (20, 1, 5000, 13);
INSERT INTO "public"."shopping_chart" VALUES (21, 1, 6000, 7);
INSERT INTO "public"."shopping_chart" VALUES (23, 1, 11000, 6);
INSERT INTO "public"."shopping_chart" VALUES (22, 4, 40000, 2);
INSERT INTO "public"."shopping_chart" VALUES (16, 6, 24000, 12);
INSERT INTO "public"."shopping_chart" VALUES (24, 3, 15000, 37);
INSERT INTO "public"."shopping_chart" VALUES (17, 3, 9000, 8);
COMMIT;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."category_id_seq"', 6, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."product_id_seq"', 38, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."shopping_chart_id_seq"', 25, true);

-- ----------------------------
-- Primary Key structure for table category
-- ----------------------------
ALTER TABLE "public"."category" ADD CONSTRAINT "category_pkey" PRIMARY KEY ("category_id");

-- ----------------------------
-- Primary Key structure for table product
-- ----------------------------
ALTER TABLE "public"."product" ADD CONSTRAINT "zakat_pkey" PRIMARY KEY ("product_id");

-- ----------------------------
-- Foreign Keys structure for table product
-- ----------------------------
ALTER TABLE "public"."product" ADD CONSTRAINT "fkhfsvfenlyr7pbuqih4rd14dk3" FOREIGN KEY ("category_id") REFERENCES "public"."category" ("category_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Primary Key structure for table shopping_chart
-- ----------------------------
ALTER TABLE "public"."shopping_chart" ADD CONSTRAINT "shopping_chart_pkey" PRIMARY KEY ("shopping_chart_id");

-- ----------------------------
-- Foreign Keys structure for table shopping_chart
-- ----------------------------
ALTER TABLE "public"."shopping_chart" ADD CONSTRAINT "fk6oxh1a6l4io9qbh2gai9g0raa" FOREIGN KEY ("product_id") REFERENCES "public"."product" ("product_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
