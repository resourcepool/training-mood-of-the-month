CREATE TABLE "Employee" (
  "uuid" SERIAL PRIMARY KEY,
  "name" varchar,
  "email" varchar,
  "birthdate" timestamp,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "MOTM_Answer" (
  "uuid" SERIAL PRIMARY KEY,
  "message" varchar,
  "grade" integer,
  "Employee_id" integer,
  "MOTM_id" integer,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "MOTM" (
  "uuid" SERIAL PRIMARY KEY,
  "title" varchar,
  "message_template" varchar,
  "page_template" varchar,
  "created_at" timestamp,
  "updated_at" timestamp
);

ALTER TABLE "MOTM_Answer" ADD FOREIGN KEY ("Employee_id") REFERENCES "Employee" ("uuid");

ALTER TABLE "MOTM_Answer" ADD FOREIGN KEY ("MOTM_id") REFERENCES "MOTM" ("uuid");
