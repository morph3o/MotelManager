-- Converted by db_converter
START TRANSACTION;
SET standard_conforming_strings=off;
SET escape_string_warning=off;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE "persona" (
    "id" integer NOT NULL,
    "id_persona" varchar(200) NOT NULL,
    "nombre" varchar(200) NOT NULL,
    "ape_paterno" varchar(200) NOT NULL,
    "ape_materno" varchar(200) NOT NULL,
    "email" varchar(200) NOT NULL,
    "telefono" varchar(200) NOT NULL,
    PRIMARY KEY ("id"),
    UNIQUE ("id_persona")
);


-- Post-data save --
COMMIT;
START TRANSACTION;

-- Typecasts --

-- Foreign keys --

-- Sequences --
CREATE SEQUENCE persona_id_seq;
SELECT setval('persona_id_seq', max(id)) FROM "persona";
ALTER TABLE "persona" ALTER COLUMN "id" SET DEFAULT nextval('persona_id_seq');

-- Full Text keys --

COMMIT;
