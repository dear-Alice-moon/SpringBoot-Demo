
CREATE TABLE user (
  id int(9) NOT NULL COMMENT 'ID, 主键.',
  name varchar(100) DEFAULT NULL COMMENT '姓名',
  age int(11) DEFAULT NULL COMMENT '年龄',
  create_date datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


INSERT INTO user (id, name, age, create_date) VALUES ('1', '张三', '20', '2020-04-02 09:54:23');
INSERT INTO user (id, name, age, create_date) VALUES ('2', '张三', '20', '2020-01-05 11:20:00');
INSERT INTO user (id, name, age, create_date) VALUES ('4', '李四', '25', '2019-10-22 16:27:03');
INSERT INTO user (id, name, age, create_date) VALUES ('5', '刘涛', '22', '2020-04-06 08:07:30');
INSERT INTO user (id, name, age, create_date) VALUES ('6', '张曼玉', '18', '2020-04-09 17:21:45');
INSERT INTO user (id, name, age, create_date) VALUES ('7', '刘德华', '33', '2020-03-18 17:22:07');
INSERT INTO user (id, name, age, create_date) VALUES ('8', '刘备', '23', '2020-03-17 17:22:34');
INSERT INTO user (id, name, age, create_date) VALUES ('1001', '王小二', '18', '2020-04-06 08:07:30');
INSERT INTO user (id, name, age, create_date) VALUES ('1005', '王小二', '18', '2020-04-06 08:14:10');
INSERT INTO user (id, name, age, create_date) VALUES ('1006', 'admin', '20', '2020-02-20 16:12:45');

