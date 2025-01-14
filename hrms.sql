PGDMP                 
        y            hrms    13.2    13.2 "    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24576    hrms    DATABASE     a   CREATE DATABASE hrms WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE hrms;
                postgres    false            �            1259    24610    tbl_system_manager    TABLE     ;  CREATE TABLE public.tbl_system_manager (
    "SystemManagerID" integer NOT NULL,
    "SystemManagerName" character varying(50) NOT NULL,
    "SystemManagerSurname" character varying(50) NOT NULL,
    "SystemManagerEmail" character varying(50) NOT NULL,
    "SystemManagerPassword" character varying(16) NOT NULL
);
 &   DROP TABLE public.tbl_system_manager;
       public         heap    postgres    false            �            1259    24608 !   SystemManager_SystemManagerID_seq    SEQUENCE     �   ALTER TABLE public.tbl_system_manager ALTER COLUMN "SystemManagerID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."SystemManager_SystemManagerID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    207            �            1259    24606    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    24589    tbl_companies    TABLE     s  CREATE TABLE public.tbl_companies (
    "CompanyID" bigint NOT NULL,
    "CompanyName" character varying(50) NOT NULL,
    "CompanyWebsite" character varying(75) NOT NULL,
    "CompanyeMail" character varying(90) NOT NULL,
    "CompanyPassword" character varying(16) NOT NULL,
    "CompanyPhone" character varying(14) NOT NULL,
    "BusinessAreaID" integer[] NOT NULL
);
 !   DROP TABLE public.tbl_companies;
       public         heap    postgres    false            �            1259    24587    tbl.Companys_CompanyID_seq    SEQUENCE     �   ALTER TABLE public.tbl_companies ALTER COLUMN "CompanyID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."tbl.Companys_CompanyID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    203            �            1259    24582    tbl_job_seeker_users    TABLE     Y  CREATE TABLE public.tbl_job_seeker_users (
    "JobSeekerID" bigint NOT NULL,
    "JobSeekerName" character varying(50) NOT NULL,
    "JobSeekerSurname" character varying(50) NOT NULL,
    "JobSeekerNationalIdentity" bigint NOT NULL,
    "JobSeekerPassword" character varying(16) NOT NULL,
    "JobSeekereMail" character varying(50) NOT NULL
);
 (   DROP TABLE public.tbl_job_seeker_users;
       public         heap    postgres    false            �            1259    24580 "   tbl.JobSeekerUsers_JobSeekerID_seq    SEQUENCE     �   ALTER TABLE public.tbl_job_seeker_users ALTER COLUMN "JobSeekerID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."tbl.JobSeekerUsers_JobSeekerID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            �            1259    24618 	   tbl_Users    TABLE     �   CREATE TABLE public."tbl_Users" (
    "UsersID" bigint NOT NULL,
    "UsersMail" character varying(50) NOT NULL,
    "UsersPassword" character varying(16) NOT NULL
);
    DROP TABLE public."tbl_Users";
       public         heap    postgres    false            �            1259    24616    tbl_Users_UsersID_seq    SEQUENCE     �   ALTER TABLE public."tbl_Users" ALTER COLUMN "UsersID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."tbl_Users_UsersID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            �            1259    24601    tbl_business_areas    TABLE     }   CREATE TABLE public.tbl_business_areas (
    business_areas_id integer NOT NULL,
    business_area character varying(255)
);
 &   DROP TABLE public.tbl_business_areas;
       public         heap    postgres    false            �          0    24618 	   tbl_Users 
   TABLE DATA           N   COPY public."tbl_Users" ("UsersID", "UsersMail", "UsersPassword") FROM stdin;
    public          postgres    false    209   �,       �          0    24601    tbl_business_areas 
   TABLE DATA           N   COPY public.tbl_business_areas (business_areas_id, business_area) FROM stdin;
    public          postgres    false    204   -       �          0    24589    tbl_companies 
   TABLE DATA           �   COPY public.tbl_companies ("CompanyID", "CompanyName", "CompanyWebsite", "CompanyeMail", "CompanyPassword", "CompanyPhone", "BusinessAreaID") FROM stdin;
    public          postgres    false    203   1-       �          0    24582    tbl_job_seeker_users 
   TABLE DATA           �   COPY public.tbl_job_seeker_users ("JobSeekerID", "JobSeekerName", "JobSeekerSurname", "JobSeekerNationalIdentity", "JobSeekerPassword", "JobSeekereMail") FROM stdin;
    public          postgres    false    201   N-       �          0    24610    tbl_system_manager 
   TABLE DATA           �   COPY public.tbl_system_manager ("SystemManagerID", "SystemManagerName", "SystemManagerSurname", "SystemManagerEmail", "SystemManagerPassword") FROM stdin;
    public          postgres    false    207   k-       �           0    0 !   SystemManager_SystemManagerID_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public."SystemManager_SystemManagerID_seq"', 1, false);
          public          postgres    false    206            �           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);
          public          postgres    false    205            �           0    0    tbl.Companys_CompanyID_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public."tbl.Companys_CompanyID_seq"', 1, false);
          public          postgres    false    202            �           0    0 "   tbl.JobSeekerUsers_JobSeekerID_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public."tbl.JobSeekerUsers_JobSeekerID_seq"', 1, false);
          public          postgres    false    200            �           0    0    tbl_Users_UsersID_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."tbl_Users_UsersID_seq"', 1, false);
          public          postgres    false    208            D           2606    24614 %   tbl_system_manager SystemManager_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.tbl_system_manager
    ADD CONSTRAINT "SystemManager_pkey" PRIMARY KEY ("SystemManagerID");
 Q   ALTER TABLE ONLY public.tbl_system_manager DROP CONSTRAINT "SystemManager_pkey";
       public            postgres    false    207            >           2606    24593    tbl_companies tbl.Companys_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.tbl_companies
    ADD CONSTRAINT "tbl.Companys_pkey" PRIMARY KEY ("CompanyID");
 K   ALTER TABLE ONLY public.tbl_companies DROP CONSTRAINT "tbl.Companys_pkey";
       public            postgres    false    203            <           2606    24586 ,   tbl_job_seeker_users tbl.JobSeekerUsers_pkey 
   CONSTRAINT     w   ALTER TABLE ONLY public.tbl_job_seeker_users
    ADD CONSTRAINT "tbl.JobSeekerUsers_pkey" PRIMARY KEY ("JobSeekerID");
 X   ALTER TABLE ONLY public.tbl_job_seeker_users DROP CONSTRAINT "tbl.JobSeekerUsers_pkey";
       public            postgres    false    201            F           2606    24631    tbl_Users tbl_UsersUnique 
   CONSTRAINT     q   ALTER TABLE ONLY public."tbl_Users"
    ADD CONSTRAINT "tbl_UsersUnique" UNIQUE ("UsersID") INCLUDE ("UsersID");
 G   ALTER TABLE ONLY public."tbl_Users" DROP CONSTRAINT "tbl_UsersUnique";
       public            postgres    false    209    209            @           2606    24605 *   tbl_business_areas tbl_business_areas_pkey 
   CONSTRAINT     w   ALTER TABLE ONLY public.tbl_business_areas
    ADD CONSTRAINT tbl_business_areas_pkey PRIMARY KEY (business_areas_id);
 T   ALTER TABLE ONLY public.tbl_business_areas DROP CONSTRAINT tbl_business_areas_pkey;
       public            postgres    false    204            B           2606    24651 ,   tbl_business_areas tbl_business_areas_unique 
   CONSTRAINT     �   ALTER TABLE ONLY public.tbl_business_areas
    ADD CONSTRAINT tbl_business_areas_unique UNIQUE (business_areas_id) INCLUDE (business_areas_id);
 V   ALTER TABLE ONLY public.tbl_business_areas DROP CONSTRAINT tbl_business_areas_unique;
       public            postgres    false    204    204            I           2606    24652 1   tbl_companies tbl_companies_business_area_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_companies
    ADD CONSTRAINT tbl_companies_business_area_foreign FOREIGN KEY ("CompanyID") REFERENCES public.tbl_business_areas(business_areas_id) NOT VALID;
 [   ALTER TABLE ONLY public.tbl_companies DROP CONSTRAINT tbl_companies_business_area_foreign;
       public          postgres    false    203    2880    204            H           2606    24642 #   tbl_companies tbl_companies_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_companies
    ADD CONSTRAINT tbl_companies_foreign FOREIGN KEY ("CompanyID") REFERENCES public."tbl_Users"("UsersID") NOT VALID;
 M   ALTER TABLE ONLY public.tbl_companies DROP CONSTRAINT tbl_companies_foreign;
       public          postgres    false    203    209    2886            G           2606    24632 1   tbl_job_seeker_users tbl_jpb_seeker_users_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_job_seeker_users
    ADD CONSTRAINT tbl_jpb_seeker_users_foreign FOREIGN KEY ("JobSeekerID") REFERENCES public."tbl_Users"("UsersID") NOT VALID;
 [   ALTER TABLE ONLY public.tbl_job_seeker_users DROP CONSTRAINT tbl_jpb_seeker_users_foreign;
       public          postgres    false    2886    201    209            J           2606    24637 -   tbl_system_manager tbl_system_manager_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_system_manager
    ADD CONSTRAINT tbl_system_manager_foreign FOREIGN KEY ("SystemManagerID") REFERENCES public."tbl_Users"("UsersID") NOT VALID;
 W   ALTER TABLE ONLY public.tbl_system_manager DROP CONSTRAINT tbl_system_manager_foreign;
       public          postgres    false    207    2886    209            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     