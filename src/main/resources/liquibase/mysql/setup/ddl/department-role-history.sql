CREATE TABLE IF NOT EXISTS public.department_role_history
(
    id bigint NOT NULL DEFAULT nextval('department_role_history_id_seq'::regclass),
    end_date timestamp(6) without time zone,
    role character varying(255) COLLATE pg_catalog."default",
    start_date timestamp(6) without time zone,
    department_id bigint,
    member_id bigint,
    CONSTRAINT department_role_history_pkey PRIMARY KEY (id),
    CONSTRAINT fkd69aa2bhnfphql7kk0xn2997m FOREIGN KEY (department_id)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkmfdf08i458idos8vu0k5hij53 FOREIGN KEY (member_id)
        REFERENCES public.member (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.department_role_history
    OWNER to nstadmin;