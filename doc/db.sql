DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `u_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(32) NOT NULL,
    `menu_id` INT
);
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
    `m_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `m_name` VARCHAR(50) NOT NULL,
    `display_name` VARCHAR(50) NOT NULL,
    `index` INT NOT NULL,
    `sub_menu` INT,
    `type` INT NOT NULL
);
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
    `s_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `s_name` VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS `menu_song`;
CREATE TABLE `menu_song` (
    `menu_id` INT NOT NULL,
    `song_id` INT NOT NULL,
    PRIMARY KEY (`menu_id`, `song_id`)
);
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
    `r_id` INT NOT NULL PRIMARY KEY,
    `r_name` VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
    `p_id` INT NOT NULL PRIMARY KEY,
    `p_name` VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
    `user_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`)
);
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
    `role_id` INT NOT NULL,
    `permission_id` INT NOT NULL,
    PRIMARY KEY (`role_id`, `permission_id`)
);

INSERT INTO `user`(`u_id`, `username`, `password`) VALUE(1, "root", "123");
INSERT INTO `user`(`u_id`, `username`, `password`) VALUE(2, "web", "w123");
INSERT INTO `user`(`u_id`, `username`, `password`) VALUE(3, "android", "a123");
INSERT INTO `role`(`r_id`, `r_name`) VALUE(1, "SUPER_ADMIN");
INSERT INTO `role`(`r_id`, `r_name`) VALUE(2, "ADMIN");
INSERT INTO `role`(`r_id`, `r_name`) VALUE(3, "MEMBER");
INSERT INTO `permission`(`p_id`, `p_name`) VALUE(1, "CREATE_ADMIN");
INSERT INTO `permission`(`P_id`, `p_name`) VALUE(2, "DELETE_ADMIN");
INSERT INTO `permission`(`p_id`, `p_name`) VALUE(3, "DELETE_MEMBER");
INSERT INTO `permission`(`p_id`, `p_name`) VALUE(4, "LOGIN_WEB");
INSERT INTO `permission`(`p_id`, `p_name`) VALUE(5, "LOGIN_ANDROID");

INSERT INTO `user_role`(`user_id`, `role_id`) VALUE(1, 1);
INSERT INTO `user_role`(`user_id`, `role_id`) VALUE(2, 2);
INSERT INTO `user_role`(`user_id`, `role_id`) VALUE(3, 3);
INSERT INTO `role_permission`(`role_id`, `permission_id`) VALUE(1, 1);
INSERT INTO `role_permission`(`role_id`, `permission_id`) VALUE(1, 2);
INSERT INTO `role_permission`(`role_id`, `permission_id`) VALUE(1, 3);
INSERT INTO `role_permission`(`role_id`, `permission_id`) VALUE(1, 4);
INSERT INTO `role_permission`(`role_id`, `permission_id`) VALUE(1, 5);
INSERT INTO `role_permission`(`role_id`, `permission_id`) VALUE(2, 3);
INSERT INTO `role_permission`(`role_id`, `permission_id`) VALUE(2, 4);
INSERT INTO `role_permission`(`role_id`, `permission_id`) VALUE(3, 5);