CREATE TABLE IF NOT EXISTS public.academic_title_history
(
    id bigint NOT NULL DEFAULT nextval('academic_title_history_id_seq'::regclass),
    end_date timestamp(6) without time zone,
    start_date timestamp(6) without time zone,
    academic_title_id bigint,
    member_id bigint,
    education_field_id bigint,
    CONSTRAINT academic_title_history_pkey PRIMARY KEY (id),
    CONSTRAINT fk3xnichhbrwr6g9mokuqetgxyy FOREIGN KEY (member_id)
        REFERENCES public.member (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk5t7y0o5yk8hom8ruvhwes6n3c FOREIGN KEY (education_field_id)
        REFERENCES public.scientific_field (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkigtqrowvcj759fok0v7raknb2 FOREIGN KEY (academic_title_id)
        REFERENCES public.academic_title (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.academic_title_history
    OWNER to nstadmin;