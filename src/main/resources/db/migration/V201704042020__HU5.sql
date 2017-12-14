CREATE TABLE public.records
(
  ID           SERIAL PRIMARY KEY NOT NULL,
  CENTRE       TEXT               NOT NULL,
  TESTS        TEXT               NOT NULL,
  SYMPTOMS     TEXT               NOT NULL,
  DIAGNOSIS    TEXT               NOT NULL,
  DATE         DATE               NOT NULL,
  TREATMENT    TEXT               NOT NULL,
  OBSERVATIONS TEXT               NOT NULL,
  HISTORY_ID   INTEGER REFERENCES history ON UPDATE CASCADE
);

ALTER TABLE public.records
  ADD CONSTRAINT doctor_id
FOREIGN KEY (id) REFERENCES doctors (id) ON UPDATE CASCADE;
