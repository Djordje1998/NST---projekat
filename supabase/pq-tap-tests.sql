begin;
select plan( 52 );

select has_table( 'academic_title' );
select has_column( 'academic_title', 'name');
select col_is_pk( 'academic_title', 'id');
SELECT results_eq(
    'SELECT id, name FROM academic_title LIMIT 5',
    'VALUES 
        (1::bigint, ''Lecturer''::varchar),
        (2::bigint, ''Assistant Professor''::varchar),
        (3::bigint, ''Associate Professor''::varchar),
        (4::bigint, ''Professor''::varchar),
        (5::bigint, ''Doctor''::varchar)'
);

select has_table( 'academic_title_history' );
select has_column( 'academic_title_history', 'end_date');
select has_column( 'academic_title_history', 'start_date');
select has_column( 'academic_title_history', 'academic_title_id');
select has_column( 'academic_title_history', 'member_id');
select has_column( 'academic_title_history', 'scientific_field_id');
select has_column( 'academic_title_history', 'id');
select col_is_pk( 'academic_title_history', 'id');

select has_table( 'department' );
select has_column( 'department', 'manager');
select has_column( 'department', 'name');
select has_column( 'department', 'secretary');
select has_column( 'department', 'short_name');
select has_column( 'department', 'id');
select col_is_pk( 'department', 'id');

select has_table( 'department_role_history' );
select has_column( 'department_role_history', 'end_date');
select has_column( 'department_role_history', 'role');
select has_column( 'department_role_history', 'start_date');
select has_column( 'department_role_history', 'department_id');
select has_column( 'department_role_history', 'member_id');
select has_column( 'department_role_history', 'id');
select col_is_pk( 'department_role_history', 'id');

select has_table( 'education_title' );
select has_column( 'education_title', 'name');
select has_column( 'education_title', 'id');
select col_is_pk( 'education_title', 'id' );
SELECT results_eq(
    'SELECT id, name FROM education_title LIMIT 4',
    'VALUES 
        (1::bigint, ''High School Diploma''::varchar),
        (2::bigint, ''Bachelor''::varchar),
        (3::bigint, ''Master''::varchar),
        (4::bigint, ''PhD''::varchar)'
);

select has_table( 'member' );
select has_column( 'member', 'first_name');
select has_column( 'member', 'last_name');
select has_column( 'member', 'academic_title_id');
select has_column( 'member', 'department_id');
select has_column( 'member', 'education_title_id');
select has_column( 'member', 'scientific_field_id');
select has_column( 'member', 'id');
select col_is_pk( 'member', 'id');

select has_table( 'scientific_field' );
select has_column( 'scientific_field', 'name');
select has_column( 'scientific_field', 'id');
select col_is_pk( 'scientific_field', 'id' );
SELECT results_eq(
    'SELECT id, name FROM scientific_field LIMIT 5',
    'VALUES 
        (1::bigint, ''Physics''::varchar),
        (2::bigint, ''Biology''::varchar),
        (3::bigint, ''Chemistry''::varchar),
        (4::bigint, ''Computer Science''::varchar),
        (5::bigint, ''Mathematics''::varchar)'
);

select has_table( 'subject' );
select has_column( 'subject', 'esbp');
select has_column( 'subject', 'name');
select has_column( 'subject', 'department_id');
select has_column( 'subject', 'id');
select col_is_pk( 'subject', 'id');

select * from finish();
rollback;
