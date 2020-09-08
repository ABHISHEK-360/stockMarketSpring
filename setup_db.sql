create table company (
    company_id integer not null auto_increment,
    board_of_directors varchar(255),
    ceo varchar(255) not null,
    company_name varchar(255) not null,
    turnover varchar(255) not null,
    write_up varchar(255) not null,
    sector_id integer not null,
    primary key (company_id)
) ENGINE=InnoDB

create table exchange (
    exchange_id integer not null auto_increment,
    address varchar(255) not null,
    brief varchar(255) not null,
    remarks varchar(255),
    primary key (exchange_id)
) ENGINE=InnoDB

create table ipo (
    ipo_id integer not null auto_increment,
    num_of_shares varchar(255) not null,
    open_date date not null,
    price_per_share float not null,
    remarks varchar(255),
    company_id integer,
    primary key (ipo_id)
) ENGINE=InnoDB

create table sector (
    sector_id integer not null auto_increment,
    brief varchar(255),
    sector_name varchar(255) not null,
    primary key (sector_id)
) ENGINE=InnoDB

create table stock_price (
    stock_id integer not null auto_increment,
    date date not null,
    price float not null,
    time time not null,
    company_id integer,
    exchange_id integer,
    primary key (stock_id)
) ENGINE=InnoDB

create table user (
    user_id integer not null auto_increment,
    confirmed bit default 0 not null,
    email varchar(255) not null,
    first_name varchar(255) not null,
    last_name varchar(255),
    mobile varchar(255) not null,
    user_type ENUM('CONSUMER', 'ADMIN') default 'CONSUMER' not null,
    username varchar(255) not null,
    primary key (user_id)
) ENGINE=InnoDB

alter table user
    add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)

alter table user
    add constraint UK_cnjwxx5favk5ycqajjt17fwy1 unique (mobile)

alter table user
    add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

alter table company
    add constraint FKmumulhrkylrdxsl33736gudi6
    foreign key (sector_id)
    references sector (sector_id)

alter table ipo
    add constraint FKafr881ln7aq61c9b3twdhhjld
    foreign key (ipo_id)
    references company (company_id)

alter table stock_price
    add constraint FKjavcfro8axnb5qkgkyxfoobsm
    foreign key (company_id)
    references company (company_id)

alter table stock_price
    add constraint FKen591ntptdvye1e5ixitybqnf
    foreign key (exchange_id)
    references exchange (exchange_id)
