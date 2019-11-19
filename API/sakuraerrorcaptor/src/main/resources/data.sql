INSERT INTO public.tenant(name) VALUES ('Test tenant');
INSERT INTO public.system_user(active, admin, created_in, disabled_in, email, name, password, token, tenant_id) VALUES (true, true, null, null, 'teste@teste.com.br', 'Test user', 'aaa','', 1);
INSERT INTO public.tracked_system(location, name, token, tenant_id) VALUES ('127.0.0.1', 'Test system', '', 1);
INSERT INTO public.occurrence(detail, title) VALUES ('Full detail of our test title','Our test title');
INSERT INTO public.log(environment, level, tracked_system_id) VALUES ( 'DEV', 'ERROR', 1);
INSERT INTO public.log_occurrence(occurred_in, log_id, occurrence_id) VALUES ('2019-01-01T08:01:00', 1, 1);
