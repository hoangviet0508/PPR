--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.17
-- Dumped by pg_dump version 9.6.17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Data for Name: place; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.place (place_id, description, image_path, image_vr_path, location, name, type) VALUES (1, 'Usual classrom that can fit 40 people', NULL, NULL, 'Floor 2', '211', 0);
INSERT INTO public.place (place_id, description, image_path, image_vr_path, location, name, type) VALUES (2, 'Large hall that can be use to hold medium event', NULL, NULL, 'Floor 1', 'Central hall', 2);


--
-- Data for Name: user_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_info (user_id, full_name, phone, status) VALUES ('ec4b322e-a6de-11ea-bb37-0242ac130002', 'Nguyen Van Hoa', '0704705559', 1);
INSERT INTO public.user_info (user_id, full_name, phone, status) VALUES ('2cf9a126-273e-4e7d-a953-b59e7f17b94c', 'Nguyen Minh Tu', '0899906998', 1);
INSERT INTO public.user_info (user_id, full_name, phone, status) VALUES ('9c9c2d7d-84c4-4429-8ebf-04f30e0cca99', 'Pham Tran Thanh Phong', '0902966070', 1);
INSERT INTO public.user_info (user_id, full_name, phone, status) VALUES ('4080394f-3f3f-4f5a-958e-9af7ebb5bcf1', 'Nguyen Hoang Viet', '0353140522', 1);


--
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.booking_id_seq', 1, false);


--
-- Name: place_place_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.place_place_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--

