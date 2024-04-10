CREATE TABLE IF NOT EXISTS subject (
    id SERIAL PRIMARY KEY,
    esbp INTEGER NOT NULL,
    name VARCHAR(10) NOT NULL,
    department_id BIGINT,
    CONSTRAINT fk_subject_department FOREIGN KEY (department_id)
        REFERENCES public.department (id)
);