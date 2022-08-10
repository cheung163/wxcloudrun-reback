CREATE TABLE `home_produce` (
                                `reduce_id` varchar(255) NOT NULL COMMENT '记录id',
                                `produce` varchar(255) DEFAULT NULL COMMENT '物品名',
                                `address` varchar(255) DEFAULT NULL COMMENT '位置',
                                `createTime` datetime DEFAULT NULL,
                                PRIMARY KEY (`reduce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;