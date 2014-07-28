-- Converted by db_converter
START TRANSACTION;
SET standard_conforming_strings=off;
SET escape_string_warning=off;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE "entrada" (
    "id" integer NOT NULL,
    "id_entrada" integer NOT NULL,
    "id_factura" integer DEFAULT NULL,
    "id_persona" varchar(200) DEFAULT NULL,
    "fecha_ingreso" date DEFAULT NULL,
    "cant_prod_ing" integer NOT NULL,
    PRIMARY KEY ("id"),
    UNIQUE ("id_entrada")
);


-- Post-data save --
COMMIT;
START TRANSACTION;

-- Typecasts --

-- Foreign keys --
ALTER TABLE "entrada" ADD CONSTRAINT "fk_e_id_factura" FOREIGN KEY ("id_factura") REFERENCES "factura" ("id_factura") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "entrada" ("id_factura");
ALTER TABLE "entrada" ADD CONSTRAINT "fk_e_id_persona" FOREIGN KEY ("id_persona") REFERENCES "persona" ("id_persona") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "entrada" ("id_persona");

-- Sequences --
CREATE SEQUENCE entrada_id_seq;
SELECT setval('entrada_id_seq', max(id)) FROM "entrada";
ALTER TABLE "entrada" ALTER COLUMN "id" SET DEFAULT nextval('entrada_id_seq');

-- Full Text keys --

COMMIT;
