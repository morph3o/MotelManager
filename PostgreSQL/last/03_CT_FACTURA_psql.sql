-- Converted by db_converter
START TRANSACTION;
SET standard_conforming_strings=off;
SET escape_string_warning=off;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE "factura" (
    "id" integer NOT NULL,
    "id_factura" integer NOT NULL,
    "id_prov" varchar(200) NOT NULL,
    "precio_neto" integer NOT NULL,
    "precio_total" integer NOT NULL,
    "link_imagen" varchar(800) DEFAULT NULL,
    PRIMARY KEY ("id"),
    UNIQUE ("id_factura")
);


-- Post-data save --
COMMIT;
START TRANSACTION;

-- Typecasts --

-- Foreign keys --
ALTER TABLE "factura" ADD CONSTRAINT "fk_f_id_prov" FOREIGN KEY ("id_prov") REFERENCES "proveedor" ("id_prov") ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "factura" ("id_prov");

-- Sequences --
CREATE SEQUENCE factura_id_seq;
SELECT setval('factura_id_seq', max(id)) FROM "factura";
ALTER TABLE "factura" ALTER COLUMN "id" SET DEFAULT nextval('factura_id_seq');

-- Full Text keys --

COMMIT;
