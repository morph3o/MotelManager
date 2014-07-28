-- Converted by db_converter
START TRANSACTION;
SET standard_conforming_strings=off;
SET escape_string_warning=off;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE "proveedor" (
    "id" integer NOT NULL,
    "id_prov" varchar(200) NOT NULL,
    "nm_prov" varchar(200) NOT NULL,
    "tel_prov" varchar(200) DEFAULT NULL,
    "dir_prov" varchar(400) DEFAULT NULL,
    "email_prov" varchar(200) NOT NULL,
    PRIMARY KEY ("id"),
    UNIQUE ("id_prov")
);


-- Post-data save --
COMMIT;
START TRANSACTION;

-- Typecasts --

-- Foreign keys --

-- Sequences --
CREATE SEQUENCE proveedor_id_seq;
SELECT setval('proveedor_id_seq', max(id)) FROM "proveedor";
ALTER TABLE "proveedor" ALTER COLUMN "id" SET DEFAULT nextval('proveedor_id_seq');

-- Full Text keys --

COMMIT;
