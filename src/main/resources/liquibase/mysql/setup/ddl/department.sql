CREATE TABLE IF NOT EXISTS public.department
(
    id bigint NOT NULL DEFAULT nextval('department_id_seq'::regclass),
    manager bigint,
    name character varying(20) COLLATE pg_catalog."default",
    secretary bigint,
    short_name character varying(5) COLLATE pg_catalog."default",
    CONSTRAINT department_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.department
    OWNER to nstadmin;