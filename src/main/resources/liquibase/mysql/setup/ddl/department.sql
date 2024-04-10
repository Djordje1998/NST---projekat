CREATE TABLE IF NOT EXISTS public.department (
    id SERIAL PRIMARY KEY,
    manager BIGINT,
    name VARCHAR(20) COLLATE pg_catalog."default",
    secretary BIGINT,
    short_name VARCHAR(5) COLLATE pg_catalog."default"
);