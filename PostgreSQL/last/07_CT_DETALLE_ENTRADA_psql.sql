-- Converted by db_converter
START TRANSACTION;
SET standard_conforming_strings=off;
SET escape_string_warning=off;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE "detalle_entrada" (
    "id" integer NOT NULL,
    "id_entrada" integer NOT NULL,
    "id_prod" integer NOT NULL,
    "cant_ingreso" integer NOT NULL,
    "cant_ext_ant" integer NOT NULL,
    "cant_ext_desp" integer NOT NULL,
    PRIMARY KEY ("id")
);


-- Post-data save --
COMMIT;
START TRANSACTION;

-- Typecasts --

-- Foreign keys --
ALTER TABLE "detalle_entrada" ADD CONSTRAINT "fk_de_id_entrada" FOREIGN KEY ("id_entrada") REFERENCES "entrada" ("id_entrada") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "detalle_entrada" ("id_entrada");
ALTER TABLE "detalle_entrada" ADD CONSTRAINT "fk_de_id_prod" FOREIGN KEY ("id_prod") REFERENCES "producto" ("id_prod") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "detalle_entrada" ("id_prod");

-- Sequences --
CREATE SEQUENCE detalle_entrada_id_seq;
SELECT setval('detalle_entrada_id_seq', max(id)) FROM "detalle_entrada";
ALTER TABLE "detalle_entrada" ALTER COLUMN "id" SET DEFAULT nextval('detalle_entrada_id_seq');

-- Full Text keys --

COMMIT;
