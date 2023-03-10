CREATE TABLE "employee" (
  "uuid" varchar PRIMARY KEY,
  "name" varchar,
  "email" varchar,
  "birthdate" timestamp,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "motm_answer" (
  "uuid" varchar PRIMARY KEY,
  "message" varchar,
  "grade" integer,
  "employee_id" varchar,
  "motm_id" varchar,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "motm" (
  "uuid" varchar PRIMARY KEY,
  "title" varchar,
  "message_template" varchar,
  "page_template" varchar,
  "created_at" timestamp,
  "updated_at" timestamp
);

ALTER TABLE "motm_answer" ADD FOREIGN KEY ("employee_id") REFERENCES "employee" ("uuid");

ALTER TABLE "motm_answer" ADD FOREIGN KEY ("motm_id") REFERENCES "motm" ("uuid");
