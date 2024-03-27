CREATE TABLE IF NOT EXISTS public.subject
(
    id bigint NOT NULL DEFAULT nextval('subject_id_seq'::regclass),
    esbp integer NOT NULL,
    name character varying(10) COLLATE pg_catalog."default",
    department_id bigint,
    CONSTRAINT subject_pkey PRIMARY KEY (id),
    CONSTRAINT fks2rgt0imytiyktkr2r9yxp9tw FOREIGN KEY (department_id)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.subject
    OWNER to nstadmin;