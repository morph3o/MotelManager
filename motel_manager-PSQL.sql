--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-06-30 12:51:16 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;


SET search_path = public, pg_catalog;

--
-- TOC entry 177 (class 1259 OID 16449)
-- Name: admins_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE admins_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.admins_id_seq OWNER TO ayxcptbkmxszzw;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 176 (class 1259 OID 16437)
-- Name: admins; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE admins (
    id integer DEFAULT nextval('admins_id_seq'::regclass) NOT NULL,
    id_persona character varying(100) DEFAULT ''::character varying NOT NULL,
    clave character varying(200) NOT NULL
);


ALTER TABLE public.admins OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 181 (class 1259 OID 16539)
-- Name: detalle_factura_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE detalle_factura_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalle_factura_id_seq OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 180 (class 1259 OID 16522)
-- Name: detalle_factura; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_factura (
    id integer DEFAULT nextval('detalle_factura_id_seq'::regclass) NOT NULL,
    id_factura integer NOT NULL,
    id_prod integer NOT NULL,
    cantidad integer NOT NULL,
    precio_unitario integer NOT NULL
);


ALTER TABLE public.detalle_factura OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 183 (class 1259 OID 16566)
-- Name: entradas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE entradas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.entradas_id_seq OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 182 (class 1259 OID 16542)
-- Name: entradas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE entradas (
    id integer DEFAULT nextval('entradas_id_seq'::regclass) NOT NULL,
    id_entrada integer NOT NULL,
    id_factura integer,
    id_prod integer,
    id_persona character varying(100) DEFAULT NULL::character varying,
    fecha_ingreso date,
    cant_ingreso integer NOT NULL,
    cant_ext_ant integer NOT NULL,
    cant_ext_desp integer NOT NULL
);


ALTER TABLE public.entradas OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 179 (class 1259 OID 16519)
-- Name: factura_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE factura_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.factura_id_seq OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 178 (class 1259 OID 16501)
-- Name: factura; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE factura (
    id integer DEFAULT nextval('factura_id_seq'::regclass) NOT NULL,
    id_factura integer NOT NULL,
    id_prov character varying(100) DEFAULT NULL::character varying,
    precio_neto integer NOT NULL,
    precio_total integer NOT NULL,
    link_imagen character varying(400) DEFAULT NULL::character varying
);


ALTER TABLE public.factura OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 171 (class 1259 OID 16404)
-- Name: persona_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE persona_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.persona_id_seq OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 170 (class 1259 OID 16394)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona (
    id integer DEFAULT nextval('persona_id_seq'::regclass) NOT NULL,
    id_persona character varying(100) NOT NULL,
    nombre character varying(100) NOT NULL,
    ape_paterno character varying(100) NOT NULL,
    ape_materno character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    telefono character varying(100) NOT NULL
);


ALTER TABLE public.persona OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 173 (class 1259 OID 16421)
-- Name: producto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE producto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producto_id_seq OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 172 (class 1259 OID 16407)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE producto (
    id integer DEFAULT nextval('producto_id_seq'::regclass) NOT NULL,
    id_prod integer NOT NULL,
    nm_prod character varying(200) NOT NULL,
    tipo_prod character varying(200) DEFAULT NULL::character varying,
    marca character varying(100) DEFAULT NULL::character varying,
    cant_prod integer,
    imagen character varying(400) DEFAULT NULL::character varying,
    detalle character varying(400) DEFAULT NULL::character varying
);


ALTER TABLE public.producto OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 175 (class 1259 OID 16434)
-- Name: proveedor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE proveedor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.proveedor_id_seq OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 174 (class 1259 OID 16424)
-- Name: proveedor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE proveedor (
    id integer DEFAULT nextval('proveedor_id_seq'::regclass) NOT NULL,
    id_prov character varying(100) NOT NULL,
    nm_prov character varying(100) NOT NULL,
    tel_prov character varying(100) NOT NULL,
    dir_prov character varying(200) NOT NULL,
    email_prov character varying(40) NOT NULL
);


ALTER TABLE public.proveedor OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 185 (class 1259 OID 16587)
-- Name: salidas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE salidas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.salidas_id_seq OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 184 (class 1259 OID 16569)
-- Name: salidas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE salidas (
    id integer DEFAULT nextval('salidas_id_seq'::regclass) NOT NULL,
    id_salida integer NOT NULL,
    id_prod integer NOT NULL,
    id_persona character varying(100) DEFAULT NULL::character varying,
    fecha_egreso date NOT NULL,
    cant_egreso integer NOT NULL,
    cant_ext_ant integer NOT NULL,
    cant_ext_desp integer NOT NULL
);


ALTER TABLE public.salidas OWNER TO ayxcptbkmxszzw;

--
-- TOC entry 2307 (class 0 OID 16437)
-- Dependencies: 176
-- Data for Name: admins; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2325 (class 0 OID 0)
-- Dependencies: 177
-- Name: admins_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('admins_id_seq', 1, false);


--
-- TOC entry 2311 (class 0 OID 16522)
-- Dependencies: 180
-- Data for Name: detalle_factura; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2326 (class 0 OID 0)
-- Dependencies: 181
-- Name: detalle_factura_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('detalle_factura_id_seq', 1, false);


--
-- TOC entry 2313 (class 0 OID 16542)
-- Dependencies: 182
-- Data for Name: entradas; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2327 (class 0 OID 0)
-- Dependencies: 183
-- Name: entradas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('entradas_id_seq', 1, false);


--
-- TOC entry 2309 (class 0 OID 16501)
-- Dependencies: 178
-- Data for Name: factura; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO factura VALUES (1, 1, NULL, 100, 119, NULL);


--
-- TOC entry 2328 (class 0 OID 0)
-- Dependencies: 179
-- Name: factura_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('factura_id_seq', 1, true);


--
-- TOC entry 2301 (class 0 OID 16394)
-- Dependencies: 170
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO persona VALUES (1, '16.349.603-8', 'Piero', 'Divasto', 'Martinez', 'pdivasto@gmail.com', '56996191517');
INSERT INTO persona VALUES (2, '8.031.069-2', 'Maria', 'Martinez', 'Farias', 'morph3o@gmail.com', '234234');


--
-- TOC entry 2329 (class 0 OID 0)
-- Dependencies: 171
-- Name: persona_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('persona_id_seq', 2, true);


--
-- TOC entry 2303 (class 0 OID 16407)
-- Dependencies: 172
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO producto VALUES (8, 1000, 'Coca-Cola Zero', NULL, 'Coca-Cola Company', 0, '', '');
INSERT INTO producto VALUES (9, 1001, 'Coca-Cola Light', NULL, 'Coca Cola Company', 0, '', '');
INSERT INTO producto VALUES (10, 1002, 'Coca-Cola', NULL, 'Coca-Cola Company', 0, '', '');
INSERT INTO producto VALUES (11, 1003, 'Fanta', NULL, 'Coca-Cola Company', 0, '', '');
INSERT INTO producto VALUES (12, 1004, 'Sprite', NULL, 'Coca-Cola Company', 0, '', '');
INSERT INTO producto VALUES (13, 1005, 'Mineral c/ Gas', NULL, '', 0, '', '');
INSERT INTO producto VALUES (14, 1006, 'Mineral s/Gas', NULL, '', 0, '', '');
INSERT INTO producto VALUES (15, 1007, 'Ginger Ale', NULL, '', 0, '', '');
INSERT INTO producto VALUES (16, 1008, 'Agua Tónica', NULL, '', 0, '', '');
INSERT INTO producto VALUES (17, 1009, 'Cristal Botellín 250cc', NULL, 'CCU', 0, '', '');
INSERT INTO producto VALUES (18, 1010, 'Baltica Tarro', NULL, '', 0, '', '');
INSERT INTO producto VALUES (19, 1011, 'Carta Blanca Tarro', NULL, '', 0, '', '');
INSERT INTO producto VALUES (20, 1012, 'Corona Botell', NULL, 'Corona', 0, '', '');
INSERT INTO producto VALUES (21, 1013, 'Cristal Tarro', NULL, 'CCU', 0, '', '');
INSERT INTO producto VALUES (22, 1014, 'Energética', NULL, '', 0, '', 'El nombre es muy genérico, debe ser modificado por el nombre del producto original.');
INSERT INTO producto VALUES (23, 1015, 'Paceña', NULL, '', 0, '', '');
INSERT INTO producto VALUES (24, 1016, 'Heineken', NULL, '', 0, '', '');
INSERT INTO producto VALUES (25, 1017, 'Pisco Capel 750/35º', NULL, '', 0, '', '');
INSERT INTO producto VALUES (26, 1018, 'Control 750/35º', NULL, '', 0, '', '');
INSERT INTO producto VALUES (27, 1019, 'Campanario 750/35º', NULL, '', 0, '', '');
INSERT INTO producto VALUES (28, 1020, 'Cochiguas 750/35º', NULL, '', 0, '', '');
INSERT INTO producto VALUES (29, 1021, 'Alto del Carmen 750cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (30, 1022, 'Champagne 750cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (31, 1023, 'Ron Havana', NULL, '', 0, '', '');
INSERT INTO producto VALUES (32, 1024, 'Ron Stelar 700cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (33, 1025, 'Ron Abuelo', NULL, '', 0, '', '');
INSERT INTO producto VALUES (34, 1026, 'Vodka Stolichnaya 1000cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (35, 1027, 'Vodka Eristoff 750cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (36, 1028, 'Gin Booth 1000cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (37, 1029, 'Menta 1000cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (38, 1030, 'Tequila 750cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (39, 1031, 'Martini Rosso 900cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (40, 1032, 'Vermouth 900cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (41, 1033, 'Cognac El Gaitero 750', NULL, '', 0, '', '');
INSERT INTO producto VALUES (42, 1034, 'Cacao Duval 750cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (43, 1035, 'Vino Dulce', NULL, '', 0, '', '');
INSERT INTO producto VALUES (44, 1036, 'Granadina Mitjan''s 900cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (45, 1037, 'Whisky Ballantine 1000cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (46, 1038, 'Whisky Johnnie Walker 750cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (47, 1039, 'Whisky Glen Niven 750cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (48, 1040, 'Whisky Chivas Regal 12 750cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (49, 1041, 'Ron Mitjan''s Blanco 750cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (50, 1042, 'Manquehuito', NULL, '', 0, '', '');
INSERT INTO producto VALUES (51, 1043, 'Vino Chico', NULL, '', 0, '', '');
INSERT INTO producto VALUES (52, 1044, 'Shampoo', NULL, '', 0, '', '');
INSERT INTO producto VALUES (53, 1045, 'Confort', NULL, '', 0, '', '');
INSERT INTO producto VALUES (54, 1046, 'Jabón', NULL, '', 0, '', '');
INSERT INTO producto VALUES (55, 1047, 'Quick', NULL, '', 0, '', '');
INSERT INTO producto VALUES (56, 1048, 'Detergente', NULL, '', 0, '', '');
INSERT INTO producto VALUES (57, 1050, 'Cloro', NULL, '', 0, '', '');
INSERT INTO producto VALUES (58, 1051, 'Insecticida', NULL, '', 0, '', '');
INSERT INTO producto VALUES (59, 1052, 'Desodorante', NULL, '', 0, '', '');
INSERT INTO producto VALUES (60, 1053, 'Lustra Muebles', NULL, '', 0, '', '');
INSERT INTO producto VALUES (61, 1054, 'Cloro Gel', NULL, '', 0, '', '');
INSERT INTO producto VALUES (62, 1055, 'Antigrasa', NULL, '', 0, '', '');
INSERT INTO producto VALUES (63, 1056, 'Purex', NULL, '', 0, '', '');
INSERT INTO producto VALUES (64, 1057, 'Bolsa Basura', NULL, '', 0, '', '');
INSERT INTO producto VALUES (65, 1058, 'Limpia Vidrio', NULL, '', 0, '', '');
INSERT INTO producto VALUES (66, 1059, 'Lysol', NULL, '', 0, '', '');
INSERT INTO producto VALUES (67, 1060, 'Cera', NULL, '', 0, '', '');
INSERT INTO producto VALUES (68, 1061, 'Papas Fritas', NULL, '', 0, '', '');
INSERT INTO producto VALUES (69, 1062, 'Maní Salado', NULL, '', 0, '', '');
INSERT INTO producto VALUES (70, 1063, 'Chocolates', NULL, '', 0, '', '');
INSERT INTO producto VALUES (71, 1064, 'Preservativos', NULL, '', 0, '', '');
INSERT INTO producto VALUES (72, 1065, 'Servilletas', NULL, '', 0, '', '');
INSERT INTO producto VALUES (73, 1066, 'Cigarrillos 20', NULL, '', 0, '', '');
INSERT INTO producto VALUES (74, 1067, 'Cigarrillos 10', NULL, '', 0, '', '');
INSERT INTO producto VALUES (75, 1068, 'Durazno 1500cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (76, 1069, 'Naranja 1500cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (77, 1070, 'Piña 1500cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (78, 1071, 'Tutti Frutti', NULL, '', 0, '', '');
INSERT INTO producto VALUES (79, 1072, 'Damasco 1500cc', NULL, '', 0, '', '');
INSERT INTO producto VALUES (80, 1073, 'Manzana', NULL, '', 0, '', '');
INSERT INTO producto VALUES (81, 1074, 'Fosforos', NULL, '', 0, '', '');
INSERT INTO producto VALUES (82, 1075, 'Piña Colada', NULL, '', 0, '', '');
INSERT INTO producto VALUES (83, 1076, 'Cañitas', NULL, '', 0, '', '');
INSERT INTO producto VALUES (84, 1077, 'Jabón B.', NULL, '', 0, '', '');


--
-- TOC entry 2330 (class 0 OID 0)
-- Dependencies: 173
-- Name: producto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('producto_id_seq', 84, true);


--
-- TOC entry 2305 (class 0 OID 16424)
-- Dependencies: 174
-- Data for Name: proveedor; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2331 (class 0 OID 0)
-- Dependencies: 175
-- Name: proveedor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('proveedor_id_seq', 1, false);


--
-- TOC entry 2315 (class 0 OID 16569)
-- Dependencies: 184
-- Data for Name: salidas; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2332 (class 0 OID 0)
-- Dependencies: 185
-- Name: salidas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('salidas_id_seq', 1, false);


--
-- TOC entry 2166 (class 2606 OID 16442)
-- Name: admins_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY admins
    ADD CONSTRAINT admins_pkey PRIMARY KEY (id);


--
-- TOC entry 2175 (class 2606 OID 16526)
-- Name: detalle_factura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_factura
    ADD CONSTRAINT detalle_factura_pkey PRIMARY KEY (id);


--
-- TOC entry 2180 (class 2606 OID 16547)
-- Name: entradas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY entradas
    ADD CONSTRAINT entradas_pkey PRIMARY KEY (id);


--
-- TOC entry 2168 (class 2606 OID 16512)
-- Name: factura_id_factura_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY factura
    ADD CONSTRAINT factura_id_factura_key UNIQUE (id_factura);


--
-- TOC entry 2171 (class 2606 OID 16510)
-- Name: factura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (id);


--
-- TOC entry 2153 (class 2606 OID 16403)
-- Name: persona_id_persona_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_id_persona_key UNIQUE (id_persona);


--
-- TOC entry 2155 (class 2606 OID 16401)
-- Name: persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);


--
-- TOC entry 2157 (class 2606 OID 16420)
-- Name: producto_id_prod_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_id_prod_key UNIQUE (id_prod);


--
-- TOC entry 2159 (class 2606 OID 16418)
-- Name: producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id, id_prod);


--
-- TOC entry 2161 (class 2606 OID 16433)
-- Name: proveedor_id_prov_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY proveedor
    ADD CONSTRAINT proveedor_id_prov_key UNIQUE (id_prov);


--
-- TOC entry 2163 (class 2606 OID 16431)
-- Name: proveedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY proveedor
    ADD CONSTRAINT proveedor_pkey PRIMARY KEY (id);


--
-- TOC entry 2184 (class 2606 OID 16574)
-- Name: salidas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY salidas
    ADD CONSTRAINT salidas_pkey PRIMARY KEY (id);


--
-- TOC entry 2164 (class 1259 OID 16448)
-- Name: admins_id_persona_idx; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX admins_id_persona_idx ON admins USING btree (id_persona);


--
-- TOC entry 2172 (class 1259 OID 16532)
-- Name: detalle_factura_id_factura_idx; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detalle_factura_id_factura_idx ON detalle_factura USING btree (id_factura);


--
-- TOC entry 2173 (class 1259 OID 16538)
-- Name: detalle_factura_id_prod_idx; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX detalle_factura_id_prod_idx ON detalle_factura USING btree (id_prod);


--
-- TOC entry 2176 (class 1259 OID 16553)
-- Name: entradas_id_factura_idx; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX entradas_id_factura_idx ON entradas USING btree (id_factura);


--
-- TOC entry 2177 (class 1259 OID 16565)
-- Name: entradas_id_persona_idx; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX entradas_id_persona_idx ON entradas USING btree (id_persona);


--
-- TOC entry 2178 (class 1259 OID 16559)
-- Name: entradas_id_prod_idx; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX entradas_id_prod_idx ON entradas USING btree (id_prod);


--
-- TOC entry 2169 (class 1259 OID 16518)
-- Name: factura_id_prov_idx; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX factura_id_prov_idx ON factura USING btree (id_prov);


--
-- TOC entry 2181 (class 1259 OID 16586)
-- Name: salidas_id_persona_idx; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX salidas_id_persona_idx ON salidas USING btree (id_persona);


--
-- TOC entry 2182 (class 1259 OID 16580)
-- Name: salidas_id_prod_idx; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX salidas_id_prod_idx ON salidas USING btree (id_prod);


--
-- TOC entry 2185 (class 2606 OID 16443)
-- Name: admins_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY admins
    ADD CONSTRAINT admins_ibfk_1 FOREIGN KEY (id_persona) REFERENCES persona(id_persona) DEFERRABLE INITIALLY DEFERRED;


--
-- TOC entry 2187 (class 2606 OID 16527)
-- Name: detalle_factura_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalle_factura
    ADD CONSTRAINT detalle_factura_ibfk_1 FOREIGN KEY (id_factura) REFERENCES factura(id_factura) DEFERRABLE INITIALLY DEFERRED;


--
-- TOC entry 2188 (class 2606 OID 16533)
-- Name: detalle_factura_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalle_factura
    ADD CONSTRAINT detalle_factura_ibfk_2 FOREIGN KEY (id_prod) REFERENCES producto(id_prod) DEFERRABLE INITIALLY DEFERRED;


--
-- TOC entry 2189 (class 2606 OID 16548)
-- Name: entradas_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY entradas
    ADD CONSTRAINT entradas_ibfk_1 FOREIGN KEY (id_factura) REFERENCES factura(id_factura) ON UPDATE CASCADE ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;


--
-- TOC entry 2190 (class 2606 OID 16554)
-- Name: entradas_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY entradas
    ADD CONSTRAINT entradas_ibfk_2 FOREIGN KEY (id_prod) REFERENCES producto(id_prod) ON UPDATE CASCADE ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;


--
-- TOC entry 2191 (class 2606 OID 16560)
-- Name: entradas_ibfk_3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY entradas
    ADD CONSTRAINT entradas_ibfk_3 FOREIGN KEY (id_persona) REFERENCES persona(id_persona) ON UPDATE CASCADE ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;


--
-- TOC entry 2186 (class 2606 OID 16513)
-- Name: factura_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY factura
    ADD CONSTRAINT factura_ibfk_1 FOREIGN KEY (id_prov) REFERENCES proveedor(id_prov) DEFERRABLE INITIALLY DEFERRED;


--
-- TOC entry 2192 (class 2606 OID 16575)
-- Name: salidas_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY salidas
    ADD CONSTRAINT salidas_ibfk_1 FOREIGN KEY (id_prod) REFERENCES producto(id_prod) ON UPDATE CASCADE ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;


--
-- TOC entry 2193 (class 2606 OID 16581)
-- Name: salidas_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY salidas
    ADD CONSTRAINT salidas_ibfk_2 FOREIGN KEY (id_persona) REFERENCES persona(id_persona) ON UPDATE CASCADE ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;


--
-- TOC entry 2323 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM ayxcptbkmxszzw;
GRANT ALL ON SCHEMA public TO ayxcptbkmxszzw;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-06-30 12:51:16 CEST

--
-- PostgreSQL database dump complete
--

