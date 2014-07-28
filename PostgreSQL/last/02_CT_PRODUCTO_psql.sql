-- Converted by db_converter
START TRANSACTION;
SET standard_conforming_strings=off;
SET escape_string_warning=off;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE "producto" (
    "id" integer NOT NULL,
    "id_prod" integer NOT NULL,
    "nm_prod" varchar(400) NOT NULL,
    "tipo_prod" varchar(400) NOT NULL,
    "marca" varchar(200) NOT NULL,
    "cant_prod" integer DEFAULT NULL,
    "imagen" varchar(800) NOT NULL,
    "detalle" varchar(800) NOT NULL,
    PRIMARY KEY ("id"),
    UNIQUE ("id_prod")
);


-- Post-data save --
COMMIT;
START TRANSACTION;

-- Typecasts --

-- Foreign keys --

-- Sequences --
CREATE SEQUENCE producto_id_seq;
SELECT setval('producto_id_seq', max(id)) FROM "producto";
ALTER TABLE "producto" ALTER COLUMN "id" SET DEFAULT nextval('producto_id_seq');

-- Full Text keys --

COMMIT;
