INSERT INTO tasks (
    id, 
    created_at, 
    updated_at, 
    object, 
    user_id, 
    task_priority, 
    status_id, 
    subject, 
    description, 
    due_date
) VALUES (
    'cb5425f0-ed68-4336-bf6b-c2ff03c017a5', 
    '2024-07-19 08:32:02.108', 
    '2024-07-19 15:28:57.179', 
    'Task', 
    '123e4567-e89b-12d3-a456-556642440000', 
    'high', 
    'open', 
    'intergration testing', 
    'Generate an open task .', 
    '2024-07-19T12:00:00'
), (
    'cb5425f0-ed68-4336-bf6b-c2ff03c017a1', 
    '2024-07-19 08:32:02.108', 
    '2024-07-19 15:28:57.179', 
    'Task', 
    '123e4567-e89b-12d3-a456-556642440000', 
    'high', 
    'in_progress', 
    'intergration testing - in_progress task', 
    'Generate an in_progress task for test stop progress.', 
    '2024-07-19T12:00:00'
),(
    'cb5425f0-ed68-4336-bf6b-c2ff03c017a2', 
    '2024-07-19 08:32:02.108', 
    '2024-07-19 15:28:57.179', 
    'Task', 
    '123e4567-e89b-12d3-a456-556642440000', 
    'high', 
    'closed', 
    'intergration testing - closed task', 
    'Generate a closed task in database for test reopen task.', 
    '2024-07-19T12:00:00'
);