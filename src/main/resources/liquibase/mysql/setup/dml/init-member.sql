INSERT INTO member(first_name, last_name, department_id, academic_title_id, education_title_id,scientific_field_id)
VALUES
    ('Pera', 'Peric',
    (SELECT id FROM department WHERE short_name = 'SWD'),
    (SELECT id FROM academic_title WHERE name = 'Professor'),
    (SELECT id FROM education_title WHERE name = 'Master'),
    (SELECT id FROM scientific_field WHERE name = 'Computer Science')),
    ('Mika', 'Mikic',
    (SELECT id FROM department WHERE short_name = 'SWD'),
    (SELECT id FROM academic_title WHERE name = 'Doctor'),
    (SELECT id FROM education_title WHERE name = 'PhD'),
    (SELECT id FROM scientific_field WHERE name = 'Mathematics')),
    ('Zika', 'Zikic',
    (SELECT id FROM department WHERE short_name = 'SWE'),
    (SELECT id FROM academic_title WHERE name = 'Lecturer'),
    (SELECT id FROM education_title WHERE name = 'Bachelor'),
    (SELECT id FROM scientific_field WHERE name = 'Physics'));
