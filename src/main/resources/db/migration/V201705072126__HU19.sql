CREATE TABLE public.prescription
(
  ID           SERIAL PRIMARY KEY NOT NULL,
  DOSE         TEXT               NOT NULL,
  MEDICAMENT   TEXT               NOT NULL,
  DATE         DATE               NOT NULL,
  RECORD_ID   INTEGER REFERENCES records ON UPDATE CASCADE
);