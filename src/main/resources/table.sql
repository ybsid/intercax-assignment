CREATE TABLE IF NOT EXISTS test.robot
(
    id integer NOT NULL DEFAULT nextval('test.robot_id_seq'::regclass),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    year_built date,
    mass integer,
    list_of_functions character varying(200)[] COLLATE pg_catalog."default",
    state character varying(50) COLLATE pg_catalog."default",
    deleted boolean DEFAULT false,
    CONSTRAINT robot_pkey PRIMARY KEY (id)
)

---

CREATE SEQUENCE IF NOT EXISTS test.hibernate_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;