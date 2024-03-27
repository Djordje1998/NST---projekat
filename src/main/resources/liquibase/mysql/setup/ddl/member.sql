CREATE TABLE IF NOT EXISTS public.member
(
    id bigint NOT NULL DEFAULT nextval('member_id_seq'::regclass),
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    department_title_id bigint,
    department_id bigint,
    education_title_id bigint,
    scientific_field_id bigint,
    CONSTRAINT member_pkey PRIMARY KEY (id),
    CONSTRAINT fke4qtpd1mqhql26q8q7sb7w8ie FOREIGN KEY (department_title_id)
        REFERENCES public.academic_title (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkkarn111hkvnoujdvxd60d4tc8 FOREIGN KEY (scientific_field_id)
        REFERENCES public.scientific_field (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fklmd4h7lh9acdyvi0xxbvsqrmk FOREIGN KEY (department_id)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkousd9shldpot38vj7yepnuq83 FOREIGN KEY (education_title_id)
        REFERENCES public.education_title (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.member
    OWNER to nstadmin;