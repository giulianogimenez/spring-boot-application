CREATE TABLE `PSS_PESSOA` (
  `PSS_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `PSS_NOME` VARCHAR(200) NOT NULL,
  `PSS_DATA_NASCIMENTO` DATETIME NULL,
  `PSS_CPF` VARCHAR(13) NULL,
  `PSS_CELULAR` VARCHAR(14) NULL,
  `PSS_EMAIL` VARCHAR(200) NULL,
  `PSS_ATIVO` INT NOT NULL,
  PRIMARY KEY (`PSS_ID`));

  CREATE TABLE `USR_USUARIO` (
  `USR_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `USR_NOME` VARCHAR(70) NOT NULL,
  `USR_NOME_REAL` VARCHAR(200) NOT NULL,
  `USR_SENHA` VARCHAR(50) NOT NULL,
  `USR_ADMIN` INT NOT NULL,
  `USR_ATIVO` INT NOT NULL,
  `PSS_ID` BIGINT(20) NULL,
  PRIMARY KEY (`USR_ID`),
  INDEX `fk_USR_PSS_idx` (`PSS_ID` ASC),
  CONSTRAINT `fk_USR_PSS`
    FOREIGN KEY (`PSS_ID`)
    REFERENCES `inscricao`.`PSS_PESSOA` (`PSS_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  
create table SET_SETOR
(
   `SET_ID`               int not null auto_increment,
   `SET_NOME`             varchar(55),
   primary key (`SET_ID`)
);

create table REVINFO (
	REV integer auto_increment,
	REVTSTMP bigint,
	primary key (REV)
);

CREATE TABLE `PSS_PESSOA_AUD` (
  `PSS_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `REV` integer not null,
  `PSS_NOME` VARCHAR(200) NOT NULL,
  `PSS_DATA_NASCIMENTO` DATETIME NULL,
  `PSS_CPF` VARCHAR(13) NULL,
  `PSS_CELULAR` VARCHAR(14) NULL,
  `PSS_EMAIL` VARCHAR(200) NULL,
  `REVTYPE` tinyint,
  `PSS_ATIVO` INT NOT NULL,
  PRIMARY KEY (`PSS_ID`, `REV`));

  CREATE TABLE `USR_USUARIO_AUD` (
  `USR_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `REV` integer not null,
  `USR_NOME` VARCHAR(70) NOT NULL,
  `USR_NOME_REAL` VARCHAR(200) NOT NULL,
  `USR_SENHA` VARCHAR(50) NOT NULL,
  `USR_ADMIN` INT NOT NULL,
  `USR_ATIVO` INT NOT NULL,
  `REVTYPE` tinyint,
  `PSS_ID` BIGINT(20) NULL,
  PRIMARY KEY (`USR_ID`, `REV`));
  
create table SET_SETOR
(
	`SET_ID`               int not null auto_increment,
  	`REV` integer not null,
    `SET_NOME`             varchar(55),
    `REVTYPE` tinyint,
   primary key (`SET_ID`, `REV`)
);

