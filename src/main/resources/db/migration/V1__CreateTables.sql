-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'only_full_group_by',''))
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
                           `code` char(3) NOT NULL DEFAULT '',
                           `name` char(52) NOT NULL DEFAULT '',
                           `continent` enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') NOT NULL DEFAULT 'Asia',
                           `region` char(26) NOT NULL DEFAULT '',
                           `surface_area` decimal(10,2) NOT NULL DEFAULT '0.00',
                           `indep_year` smallint DEFAULT NULL,
                           `population` int NOT NULL DEFAULT '0',
                           `life_expectancy` decimal(3,1) DEFAULT NULL,
                           `gnp` decimal(10,2) DEFAULT NULL,
                           `gnp_old` decimal(10,2) DEFAULT NULL,
                           `local_name` char(45) NOT NULL DEFAULT '',
                           `government_form` char(45) NOT NULL DEFAULT '',
                           `head_of_state` char(60) DEFAULT NULL,
                           `capital` int DEFAULT NULL,
                           `code_2` char(2) NOT NULL DEFAULT '',
                           PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `country_language`;
CREATE TABLE `country_language` (
                                   `country_code` char(3) NOT NULL DEFAULT '',
                                   `language` char(30) NOT NULL DEFAULT '',
                                   `is_official` enum('T','F') NOT NULL DEFAULT 'F',
                                   `percentage` decimal(4,1) NOT NULL DEFAULT '0.0',
                                   PRIMARY KEY (`country_code`,`language`),
                                   KEY `country_code` (`country_code`),
                                   CONSTRAINT `country_language_ibfk_1` FOREIGN KEY (`country_code`) REFERENCES `country` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` char(35) NOT NULL DEFAULT '',
                        `country_code` char(3) NOT NULL DEFAULT '',
                        `district` char(20) NOT NULL DEFAULT '',
                        `population` int NOT NULL DEFAULT '0',
                        PRIMARY KEY (`id`),
                        KEY `country_code` (`country_code`),
                        CONSTRAINT `city_ibfk_1` FOREIGN KEY (`country_code`) REFERENCES `country` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
