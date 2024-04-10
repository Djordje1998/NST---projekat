INSERT INTO public.academic_title_history (end_date, start_date, academic_title_id, member_id, scientific_field_id)
VALUES
    (null, CURRENT_TIMESTAMP,
    (SELECT id FROM academic_title WHERE name = 'Professor'),
     1, 
    (SELECT id FROM scientific_field WHERE name = 'Computer Science')),
    (null, CURRENT_TIMESTAMP, 
    (SELECT id FROM academic_title WHERE name = 'Doctor'),
     2,
    (SELECT id FROM scientific_field WHERE name = 'Mathematics')),
    (null, CURRENT_TIMESTAMP,
    (SELECT id FROM academic_title WHERE name = 'Lecturer'),
     3, 
    (SELECT id FROM scientific_field WHERE name = 'Physics'));
