drop database if exists obs_database;
create database obs_database;
use obs_database;

create table Customer (
                          Customer_ID     int not null auto_increment,
                          Customer_Name   varchar(20),
                          Password        varchar(20),
                          primary key (Customer_ID)
);

create table Account(
                        Account_ID         int not null auto_increment,
                        Customer_ID        int,
                        Account_Num        int unique,
                        Account_Type       varchar(10),
                        Balance            double,
                        primary key (Account_ID),
                        foreign key (Customer_ID) references Customer(Customer_ID)
                            on update cascade
);

create table Transfer(
                         Transfer_ID               int not null auto_increment,
                         Account_ID             int,
                         Sender_Account_Num     int not null,
                         Receiver_Account_Num   int not null,
                         Amount                 double,
                         Frequency			    varchar(20),
                         Date                   date,
                         primary key (Transfer_ID),
                         foreign key (Account_ID) references Account(Account_ID)
                             on delete set null
                             on update cascade
);

create table Payment(
                        Payment_ID             int not null auto_increment,
                        Account_ID             int,
                        Sender_Account_Num     int  not null,
                        External_Payee_Name    varchar(20),
                        Amount                 double,
                        Frequency			   varchar(20),
                        Date                   date,
                        primary key (Payment_ID),
                        foreign key (Account_ID) references Account(Account_ID)
                            on delete set null
                            on update cascade

);


create table Deposit(
                        Deposit_ID              int not null auto_increment,
                        Account_Num             int,
                        Amount                  double,
                        Date                    date,
                        primary key (Deposit_ID),
                        foreign key (Account_Num) references Account(Account_Num)
                            on delete set null
                            on update cascade
);



create table Checks(
                        Check_ID                int not null auto_increment,
                        Account_Num             int,
                        Check_Num               int unique,
                        Amount                  int,
                        Payee_Name              varchar(20),
                        Date                    date,
                        primary key (Check_ID),
                        foreign key (Account_Num) references Account(Account_Num)
                            on delete set null
                            on update cascade

);

create table Fees(
                        Fees_ID          int not null auto_increment,
                        Account_Num             int,
                        Amount                  int,
                        Date                    date,
                        primary key (Fees_ID),
                        foreign key (Account_Num) references Account(Account_Num)
                            on delete set null
                            on update cascade
);

create table External_Payee(
                               External_Payee_ID   	int  not null auto_increment,
                               Payee_Name         	varchar(20),
                               Balance            	double,
                               primary key (External_Payee_ID)
);

# Mock Data Generation
INSERT INTO External_Payee(Payee_Name, Balance)
VALUES ('Target','0.00');
INSERT INTO Customer(Customer_Name, Password)
VALUES ('Tim', '12345')
