DROP TABLE IF EXISTS ORDR_CUSTOMER;

-- CREATE ORDR_CUSTOMER
CREATE TABLE ORDR_CUSTOMER(
                              ID VARCHAR(36) NOT NULL,
                              FIRSTNAME VARCHAR(65) NOT NULL,
                              LASTNAME VARCHAR(65) NOT NULL,
                              EMAIL VARCHAR(50) NOT NULL,
                              ADDRESS_STREET_NAME VARCHAR(100) NOT NULL,
                              ADDRESS_HOUSE_NUMBER VARCHAR(10) NOT NULL,
                              ADDRESS_POSTAL_CODE VARCHAR(10) NOT NULL,
                              ADDRESS_COUNTRY VARCHAR(65) NOT NULL,
                              PHONE_NUMBER VARCHAR(65) NOT NULL,
                              PHONE_COUNTRY_CALLING_CODE VARCHAR(10) NOT NULL,
                              CONSTRAINT CUSTOMER_PK PRIMARY KEY (ID)
);

