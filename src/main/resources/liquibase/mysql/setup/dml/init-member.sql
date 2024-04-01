INSERT INTO member(first_name, last_name, department_id, academic_title_id, education_title_id,scientific_field_id)
VALUES
    ('Pera', 'Peric',
    (SELECT id FROM department WHERE short_name = 'SWD'),
    (SELECT id FROM academic_title WHERE title = 'Professor'),
    (SELECT id FROM education_title WHERE title = 'Master'),
    (SELECT id FROM scientific_field WHERE title = 'Computer Science')),
    ('Mika', 'Mikic',
    (SELECT id FROM department WHERE short_name = 'SWD'),
    (SELECT id FROM academic_title WHERE title = 'Doctor'),
    (SELECT id FROM education_title WHERE title = 'PhD'),
    (SELECT id FROM scientific_field WHERE title = 'Mathematics')),
    ('Zika', 'Zikic',
    (SELECT id FROM department WHERE short_name = 'SWE'),
    (SELECT id FROM academic_title WHERE title = 'Lecturer'),
    (SELECT id FROM education_title WHERE title = 'Bachelor'),
    (SELECT id FROM scientific_field WHERE title = 'Physics'));
