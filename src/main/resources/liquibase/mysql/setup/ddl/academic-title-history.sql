CREATE TABLE IF NOT EXISTS public.academic_title_history (
    id SERIAL PRIMARY KEY,
    end_date TIMESTAMP WITHOUT TIME ZONE,
    start_date TIMESTAMP WITHOUT TIME ZONE,
    academic_title_id BIGINT,
    member_id BIGINT,
    scientific_field_id BIGINT,
    CONSTRAINT fk_academic_title_history_member FOREIGN KEY (member_id)
        REFERENCES public.member (id),
    CONSTRAINT fk_academic_title_history_education_field FOREIGN KEY (scientific_field_id)
        REFERENCES public.scientific_field (id),
    CONSTRAINT fk_academic_title_history_academic_title FOREIGN KEY (academic_title_id)
        REFERENCES public.academic_title (id)
);