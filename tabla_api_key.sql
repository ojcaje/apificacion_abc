CREATE TABLE IF NOT EXISTS public.api_key
(
    clave character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT api_key_pkey PRIMARY KEY (clave)
);

ALTER TABLE public.api_key
    OWNER to postgres;
	
INSERT INTO public.api_key VALUES ('4c2c26bd5557f7df65c9fdacb0697d0812c4a6b2e2069d5a3c2d678765215471');