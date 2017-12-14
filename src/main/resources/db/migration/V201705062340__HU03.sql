TRUNCATE TABLE public.records;
ALTER TABLE public.records
  ADD CONSTRAINT doctor_id
FOREIGN KEY (doctor_id) REFERENCES doctors (id) ON UPDATE CASCADE;
