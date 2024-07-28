CREATE TABLE IF NOT EXISTS tasks (
    id UUID PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    object VARCHAR(255),
    user_id UUID,
    task_priority VARCHAR(50),
    status_id VARCHAR(50),
    subject VARCHAR(255),
    description TEXT,
    due_date TIMESTAMP
);