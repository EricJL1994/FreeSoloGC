ALTER TABLE public.records
  DROP CONSTRAINT doctor_id;
ALTER TABLE public.records
  ADD COLUMN doctor_id INTEGER NOT NULL DEFAULT 0;
