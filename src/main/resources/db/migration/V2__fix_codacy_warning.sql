-- Update foreign key constraints to be schema qualified
ALTER TABLE public.refresh_tokens
    DROP CONSTRAINT IF EXISTS "FK_REFRESH_TOKENS_ON_USER",
    ADD CONSTRAINT "FK_REFRESH_TOKENS_ON_USER"
        FOREIGN KEY (user_id) REFERENCES public.users (id);

ALTER TABLE public.user_roles
    DROP CONSTRAINT IF EXISTS "fk_userol_on_role",
    ADD CONSTRAINT "fk_userol_on_role"
        FOREIGN KEY (role_id) REFERENCES public.roles (id);

ALTER TABLE public.user_roles
    DROP CONSTRAINT IF EXISTS "fk_userol_on_user",
    ADD CONSTRAINT "fk_userol_on_user"
        FOREIGN KEY (user_id) REFERENCES public.users (id);

-- Update unique constraints to be schema qualified
ALTER TABLE public.customers
    DROP CONSTRAINT IF EXISTS "uc_customers_customer_email",
    ADD CONSTRAINT "uc_customers_customer_email"
        UNIQUE (customer_email);

ALTER TABLE public.refresh_tokens
    DROP CONSTRAINT IF EXISTS "uc_refresh_tokens_token",
    ADD CONSTRAINT "uc_refresh_tokens_token"
        UNIQUE (token);

ALTER TABLE public.refresh_tokens
    DROP CONSTRAINT IF EXISTS "uc_refresh_tokens_user",
    ADD CONSTRAINT "uc_refresh_tokens_user"
        UNIQUE (user_id);

ALTER TABLE public.users
    DROP CONSTRAINT IF EXISTS "uc_users_username",
    ADD CONSTRAINT "uc_users_username"
        UNIQUE (username);

-- Update indexes to be schema qualified
DROP INDEX IF EXISTS idx_customer_email;
CREATE INDEX idx_customer_email ON public.customers (customer_email);

DROP INDEX IF EXISTS idx_customer_name;
CREATE INDEX idx_customer_name ON public.customers (customer_name);

DROP INDEX IF EXISTS idx_customer_phone;
CREATE INDEX idx_customer_phone ON public.customers (customer_phone);