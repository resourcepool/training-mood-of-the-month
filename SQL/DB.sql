CREATE TABLE "employee" (
  "uuid" varchar UNIQUE PRIMARY KEY,
  "name" varchar,
  "email" varchar UNIQUE NOT NULL,
  "birthdate" timestamp,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "motm_answer" (
  "uuid" varchar UNIQUE PRIMARY KEY,
  "message" varchar,
  "grade" integer,
  "employee_id" varchar,
  "motm_id" varchar,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "motm" (
  "uuid" varchar UNIQUE PRIMARY KEY,
  "title" varchar,
  "message_template" varchar,
  "page_template" varchar,
  "created_at" timestamp,
  "updated_at" timestamp
);

ALTER TABLE "motm_answer" ADD FOREIGN KEY ("employee_id") REFERENCES "employee" ("uuid");

ALTER TABLE "motm_answer" ADD FOREIGN KEY ("motm_id") REFERENCES "motm" ("uuid");

INSERT INTO public.employee(
    uuid, name, email, birthdate, created_at, updated_at)
    VALUES
    ('8fbcc868-ba7b-41ca-a3e7-0dd4fe253f72', 'Gano Busson', 'GanoBusson@jourrapide.com', '1993-02-03 19:10:25-07', NOW(), NOW()),
    ('d89663fb-3144-40bf-bfad-6e92f935e7b1', 'Paul Deslauriers', 'PaulDeslauriers@armyspy.com', '1946-06-05 19:10:25-07', NOW(), NOW()),
    ('92f6f3e9-4139-42a0-9f16-94503089eed6', 'Beaufort Daoust', 'BeaufortDaoust@teleworm.us', '1945-12-13 19:10:25-07', NOW(), NOW()),
    ('d87fa62d-d266-43fc-aad5-29845253546f', 'Monique Chicoine', 'MoniqueChicoine@teleworm.us', '1953-08-15 19:10:25-07', NOW(), NOW()),
    ('a495db7d-c33c-4ba7-a039-6ee177d4d729', 'Hardouin Narcisse', 'HardouinNarcisse@dayrep.com', '1952-03-04 19:10:25-07', NOW(), NOW()),
    ('a1d90838-7bf2-4724-b3bd-d9cd719e5738', 'Gill Belisle', 'GillBelisle@armyspy.com', '1974-06-20 19:10:25-07', NOW(), NOW()),
    ('534e85d6-421a-4287-89bb-08bccceedc83', 'Berangaria Ratté', 'BerangariaRatte@rhyta.com', '1961-11-07 19:10:25-07', NOW(), NOW()),
    ('b360b0b2-0730-4127-b702-b5e4efec8a35', 'Noémi Thériault', 'NoemiTheriault@armyspy.com', '1965-04-30 19:10:25-07', NOW(), NOW()),
    ('7e2fe404-5b95-44da-b196-9d38f6757df8', 'Daisi Deslauriers', 'DaisiDeslauriers@armyspy.com', '1996-12-15 19:10:25-07', NOW(), NOW()),
    ('5bc74b8c-71a7-4f02-88bc-9062ed85b688', 'Zara Bois', 'ZaraBois@rhyta.com', '1976-05-03 19:10:25-07', NOW(), NOW());

INSERT INTO public.motm(
                        uuid, title, message_template, page_template, created_at, updated_at)
                        VALUES
                        ('a6417cfd-2716-4a79-ab95-df7b39c9d256', 'Mars', 'Mars message template', 'Mars page template', NOW(), NOW()),
                        ('678fc97f-c749-4011-a33c-e0f1240a4a49', 'Avril', 'Avril message template', 'Avril page template', NOW(), NOW()),
                        ('5b0cdb7d-70f4-4553-9aaa-1ef7afec0ca3', 'Mai', 'Mai message template', 'Mai page template', NOW(), NOW()),
                        ('73c15453-a1e6-4178-badb-f3f534836676', 'Juin', 'Juin message template', 'Juin page template', NOW(), NOW()),
                        ('cd6bb202-20c4-4cf4-9f45-c142a2c5c62e', 'Juillet', 'Juillet message template', 'Juillet page template', NOW(), NOW()),
                        ('24ff46b5-73d5-4074-a4d8-7919532801e7', 'Août', 'Août message template', 'Août page template', NOW(), NOW()),
                        ('10d9bf6c-64ec-4dd6-911d-4a607c564431', 'Septembre', 'Septembre message template', 'Septembre page template', NOW(), NOW()),
                        ('9eca27c5-0fc0-4db1-99c7-bdca75a8d92d', 'Octobre', 'Octobre message template', 'Octobre page template', NOW(), NOW()),
                        ('0e1fa907-7d06-4de5-bc6e-d86af01cb335', 'Novembre', 'Novembre message template', 'Novembre page template', NOW(), NOW()),
                        ('cc6e4624-4d92-4417-854d-fe0e2915f4ff', 'Décembre', 'Décembre message template', 'Décembre page template', NOW(), NOW());



INSERT INTO public.motm_answer(
                               uuid, message, grade, employee_id, motm_id, created_at, updated_at)
VALUES
    ('643ba9cc-ca06-46c1-89dd-e7ce27d59bc9', 'cool', 4, '8fbcc868-ba7b-41ca-a3e7-0dd4fe253f72', 'a6417cfd-2716-4a79-ab95-df7b39c9d256', NOW(), NOW()),
    ('55dbd6d3-42a0-4ec1-99f4-c1a611ae8e1b', 'super', 5, 'd89663fb-3144-40bf-bfad-6e92f935e7b1', 'a6417cfd-2716-4a79-ab95-df7b39c9d256', NOW(), NOW()),
    ('421349b3-a638-4e7e-ab57-d45a7ef1d5ea', 'mouai', 3, '92f6f3e9-4139-42a0-9f16-94503089eed6', 'a6417cfd-2716-4a79-ab95-df7b39c9d256', NOW(), NOW()),
    ('e5bb5677-b9b1-46a4-ba61-3a1176d376ef', 'pas ouf', 2, 'd87fa62d-d266-43fc-aad5-29845253546f', 'a6417cfd-2716-4a79-ab95-df7b39c9d256', NOW(), NOW()),
    ('9f603fb2-b79b-4b19-aead-72a5df742918', 'null', 1, 'a1d90838-7bf2-4724-b3bd-d9cd719e5738', 'a6417cfd-2716-4a79-ab95-df7b39c9d256', NOW(), NOW()),
    ('f2904651-4a3c-4b37-9b19-c89571d0e926', 'Beaucoup de délinquantes prognathes compromettent la chaudière.', 4, '534e85d6-421a-4287-89bb-08bccceedc83', 'a6417cfd-2716-4a79-ab95-df7b39c9d256', NOW(), NOW()),
    ('b9c7b234-47cc-4b21-a200-47398558b9aa', 'Un troubadour sait définitivement se vouer à notre maison.', 4, 'b360b0b2-0730-4127-b702-b5e4efec8a35', 'a6417cfd-2716-4a79-ab95-df7b39c9d256', NOW(), NOW()),
    ('45c1e0fa-21a5-4547-9d57-09d06cfbeda9', 'cool', 4, '8fbcc868-ba7b-41ca-a3e7-0dd4fe253f72', '678fc97f-c749-4011-a33c-e0f1240a4a49', NOW(), NOW()),
    ('8ab86b13-99e3-4e01-a97e-94c00216fc11', 'super', 5, 'd89663fb-3144-40bf-bfad-6e92f935e7b1', '678fc97f-c749-4011-a33c-e0f1240a4a49', NOW(), NOW()),
    ('7e8c1170-bcae-4d17-a169-97cae8a51d02', 'mouai', 3, '92f6f3e9-4139-42a0-9f16-94503089eed6', '678fc97f-c749-4011-a33c-e0f1240a4a49', NOW(), NOW()),
    ('a2c367d0-14a0-4008-92d5-2e16dcc21f0e', 'pas ouf', 2, 'd87fa62d-d266-43fc-aad5-29845253546f', '678fc97f-c749-4011-a33c-e0f1240a4a49', NOW(), NOW()),
    ('c277d7d9-c659-4778-b7be-fd5f69a10dea', 'null', 1, 'a1d90838-7bf2-4724-b3bd-d9cd719e5738', '678fc97f-c749-4011-a33c-e0f1240a4a49', NOW(), NOW()),
    ('dd23e57e-fc4b-4b7b-b2f2-b6886161c815', 'Beaucoup de délinquantes prognathes compromettent la chaudière.', 4, '534e85d6-421a-4287-89bb-08bccceedc83', '678fc97f-c749-4011-a33c-e0f1240a4a49', NOW(), NOW()),
    ('64ecd1d5-4be9-4590-8e38-f649450587c2', 'Un troubadour sait définitivement se vouer à notre maison.', 4, 'b360b0b2-0730-4127-b702-b5e4efec8a35', '678fc97f-c749-4011-a33c-e0f1240a4a49', NOW(), NOW());
