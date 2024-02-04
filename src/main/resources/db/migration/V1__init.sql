CREATE TABLE IF NOT EXISTS User (
                        isAccountNonExpired bit(1) NOT NULL,
                        isCredentialsNonExpired bit(1) NOT NULL,
                        isEnabled bit(1) NOT NULL,
                        id bigint NOT NULL AUTO_INCREMENT,
                        email varchar(255) DEFAULT NULL,
                        password varchar(255) DEFAULT NULL,
                        username varchar(255) DEFAULT NULL,
                        PRIMARY KEY (id),
                        UNIQUE KEY uk_user_username (username)
);

CREATE TABLE IF NOT EXISTS Company (
                           id bigint NOT NULL AUTO_INCREMENT,
                           companyName varchar(255) DEFAULT NULL,
                           companyNip varchar(255) DEFAULT NULL,
                           companyRegon varchar(255) DEFAULT NULL,
                           PRIMARY KEY (id),
                           UNIQUE KEY uk_company_companyname (companyName)
)