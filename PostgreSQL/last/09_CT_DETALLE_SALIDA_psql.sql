-- Converted by db_converter
START TRANSACTION;
SET standard_conforming_strings=off;
SET escape_string_warning=off;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE "detalle_salida" (
    "id" integer NOT NULL,
    "id_salida" integer NOT NULL,
    "id_prod" integer NOT NULL,
    "cant_salida" integer NOT NULL,
    "cant_ext_ant" integer NOT NULL,
    "cant_ext_desp" integer NOT NULL,
    PRIMARY KEY ("id")
);


-- Post-data save --
COMMIT;
START TRANSACTION;

-- Typecasts --

-- Foreign keys --
ALTER TABLE "detalle_salida" ADD CONSTRAINT "fk_ds_id_prod" FOREIGN KEY ("id_prod") REFERENCES "producto" ("id_prod") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "detalle_salida" ("id_prod");
ALTER TABLE "detalle_salida" ADD CONSTRAINT "fk_ds_id_salida" FOREIGN KEY ("id_salida") REFERENCES "salida" ("id_salida") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "detalle_salida" ("id_salida");

-- Sequences --
CREATE SEQUENCE detalle_salida_id_seq;
SELECT setval('detalle_salida_id_seq', max(id)) FROM "detalle_salida";
ALTER TABLE "detalle_salida" ALTER COLUMN "id" SET DEFAULT nextval('detalle_salida_id_seq');

-- Full Text keys --

COMMIT;
