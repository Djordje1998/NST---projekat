CREATE TABLE IF NOT EXISTS public.education_title
(
    id bigint NOT NULL DEFAULT nextval('education_title_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT education_title_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.education_title
    OWNER to nstadmin;