CREATE TABLE IF NOT EXISTS public.department_role_history (
    id SERIAL PRIMARY KEY,
    end_date TIMESTAMP WITHOUT TIME ZONE,
    role VARCHAR(255) COLLATE pg_catalog."default",
    start_date TIMESTAMP WITHOUT TIME ZONE,
    department_id BIGINT,
    member_id BIGINT,
    CONSTRAINT fk_department_role_history_department FOREIGN KEY (department_id)
        REFERENCES public.department (id),
    CONSTRAINT fk_department_role_history_member FOREIGN KEY (member_id)
        REFERENCES public.member (id)
);