CREATE TABLE IF NOT EXISTS public.member (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) COLLATE pg_catalog."default",
    last_name VARCHAR(255) COLLATE pg_catalog."default",
    academic_title_id BIGINT,
    department_id BIGINT,
    education_title_id BIGINT,
    scientific_field_id BIGINT,
    CONSTRAINT fk_member_department_title FOREIGN KEY (academic_title_id)
        REFERENCES public.academic_title (id),
    CONSTRAINT fk_member_scientific_field FOREIGN KEY (scientific_field_id)
        REFERENCES public.scientific_field (id),
    CONSTRAINT fk_member_department FOREIGN KEY (department_id)
        REFERENCES public.department (id),
    CONSTRAINT fk_member_education_title FOREIGN KEY (education_title_id)
        REFERENCES public.education_title (id)
);