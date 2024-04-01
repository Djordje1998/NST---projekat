INSERT INTO subject(name, esbp, department_id)
VALUES
    ('Programming 1',4, (SELECT id FROM department WHERE short_name = 'SWD')),
    ('Programming 2', 6, (SELECT id FROM department WHERE short_name = 'SWE')),
    ('Algorithms', 5, (SELECT id FROM department WHERE short_name = 'SWE')),
    ('Data structure', 6, (SELECT id FROM department WHERE short_name = 'SWD')),
    ('Network management', 4, (SELECT id FROM department WHERE short_name = 'SWD'));