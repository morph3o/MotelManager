-- Converted by db_converter
START TRANSACTION;
SET standard_conforming_strings=off;
SET escape_string_warning=off;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE "salida" (
    "id" integer NOT NULL,
    "id_salida" integer NOT NULL,
    "id_persona" varchar(200) DEFAULT NULL,
    "fecha_egreso" date DEFAULT NULL,
    "cant_prod_sac" integer NOT NULL,
    PRIMARY KEY ("id"),
    UNIQUE ("id_salida")
);


-- Post-data save --
COMMIT;
START TRANSACTION;

-- Typecasts --

-- Foreign keys --
ALTER TABLE "salida" ADD CONSTRAINT "fk_s_id_persona" FOREIGN KEY ("id_persona") REFERENCES "persona" ("id_persona") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "salida" ("id_persona");

-- Sequences --
CREATE SEQUENCE salida_id_seq;
SELECT setval('salida_id_seq', max(id)) FROM "salida";
ALTER TABLE "salida" ALTER COLUMN "id" SET DEFAULT nextval('salida_id_seq');

-- Full Text keys --

COMMIT;
