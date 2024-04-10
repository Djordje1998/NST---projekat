INSERT INTO subject(name, esbp, department_id)
VALUES
    ('Prog 1', 4, (SELECT id FROM department WHERE short_name = 'SWD')),
    ('Prog 2', 6, (SELECT id FROM department WHERE short_name = 'SWE')),
    ('Algo', 5, (SELECT id FROM department WHERE short_name = 'SWE')),
    ('DataStruct', 6, (SELECT id FROM department WHERE short_name = 'SWD')),
    ('Net Mgmt', 4, (SELECT id FROM department WHERE short_name = 'SWD'));