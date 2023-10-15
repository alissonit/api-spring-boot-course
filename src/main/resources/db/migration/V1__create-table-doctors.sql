CREATE TABLE doctors(

    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    crm varchar(100) NOT NULL UNIQUE,
    specialty varchar(100) NOT NULL,
    public_place varchar(100) NOT NULL,
    neighborhood varchar(100) NOT NULL,
    city varchar(100) NOT NULL,
    uf varchar(2) NOT NULL,
    complement varchar(100) NOT NULL,
    number varchar(100) NOT NULL,
    cep varchar(100) NOT NULL,

    PRIMARY KEY(id)
);