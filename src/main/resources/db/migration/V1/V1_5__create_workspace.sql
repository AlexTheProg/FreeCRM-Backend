CREATE TABLE IF NOT EXISTS workspaces (
    workspace_id UUID NOT NULL PRIMARY KEY,
    workspace_name varchar(50)
);

ALTER TABLE IF EXISTS users ADD COLUMN workspace_id UUID NOT NULL default gen_random_uuid();

ALTER TABLE  IF EXISTS users add constraint workspace_fk foreign key (workspace_id) references workspaces;

