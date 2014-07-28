-- Converted by db_converter
START TRANSACTION;
SET standard_conforming_strings=off;
SET escape_string_warning=off;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE "detalle_factura" (
    "id" integer NOT NULL,
    "id_factura" integer NOT NULL,
    "id_prod" integer NOT NULL,
    "cantidad" integer NOT NULL,
    "precio_unitario" integer NOT NULL,
    PRIMARY KEY ("id")
);


-- Post-data save --
COMMIT;
START TRANSACTION;

-- Typecasts --

-- Foreign keys --
ALTER TABLE "detalle_factura" ADD CONSTRAINT "fk_df_id_factura" FOREIGN KEY ("id_factura") REFERENCES "factura" ("id_factura") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "detalle_factura" ("id_factura");
ALTER TABLE "detalle_factura" ADD CONSTRAINT "fk_df_id_prod" FOREIGN KEY ("id_prod") REFERENCES "producto" ("id_prod") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
CREATE INDEX ON "detalle_factura" ("id_prod");

-- Sequences --
CREATE SEQUENCE detalle_factura_id_seq;
SELECT setval('detalle_factura_id_seq', max(id)) FROM "detalle_factura";
ALTER TABLE "detalle_factura" ALTER COLUMN "id" SET DEFAULT nextval('detalle_factura_id_seq');

-- Full Text keys --

COMMIT;
