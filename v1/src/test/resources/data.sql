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
    'closed', 
    'spring boot testing', 
    'Generate a task record in h2 in-memory database for testing purposes', 
    '2024-07-19T12:00:00'
);
