DROP TABLE IF EXISTS `system_data`;
CREATE TABLE `system_data` (
  `sd_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sd_id`) USING BTREE,
  `name` VARCHAR(10),
  `type` VARCHAR(20) NOT NULL,
  `total_space` LONG NOT NULL,
  `free_space` LONG NOT NULL,
  `check_time` DATETIME
) ENGINE=InnoDB DEFAULT CHARSET=utf8;