# 建库
CREATE DATABASE soa;
USE soa;

# 授权
CREATE USER 'soa'@'%' IDENTIFIED BY 'soa';
GRANT ALL PRIVILEGES ON soa.* TO 'soa'@'%';

# 建表
create table bankcard
(
	id bigint auto_increment
		primary key,
	card_id varchar(30) null,
	name varchar(20) null,
	id_number varchar(30) null
)
;

create table exchange_order
(
	id bigint auto_increment
		primary key,
	payer_id bigint null,
	target_id bigint null,
	type varchar(30) null,
	payment_key varchar(255) null,
	begin_time datetime null,
	end_time datetime null,
	status int null
)
;

create table user
(
	id bigint auto_increment
		primary key,
	telephone varchar(20) null,
	paypwd varchar(10) null,
	bankcard varchar(30) null,
	password varchar(100) null
)
;

#插入数据
INSERT INTO soa.bankcard (card_id, name, id_number) VALUES ('6222023803013297860', '管理员', '370400197501029483');
INSERT INTO soa.bankcard (card_id, name, id_number) VALUES ('6222021001113379231', '张三', '652700199111058398');
INSERT INTO soa.bankcard (card_id, name, id_number) VALUES ('6222023803023497860', '李四', '360111199210179422');
INSERT INTO soa.exchange_order (payer_id, target_id, type, payment_key, begin_time, end_time, status) VALUES
	(1, 1, '账户充值',
	 'eyJhbGciOiJIUzI1NiJ9.eyJ0YXJnZXRJZCI6MSwicGF5ZXJJZCI6MSwiaWQiOjEwfQ.dsB-6iGTzGyut8jDqSvmA7uRGC3QZmGJvm8tkfYz3e4',
	 '2017-12-30 00:00:00', '2017-12-31 00:00:00', 1);
INSERT INTO soa.user (telephone, paypwd, bankcard, password) VALUES ('15392035361', '888888', '6222023803023497860', '123456');
INSERT INTO soa.user (telephone, paypwd, bankcard, password) VALUES ('15389784123', '888888', '6222021001113379231', '123456');
INSERT INTO soa.user (telephone, paypwd, bankcard, password) VALUES ('15392038976', '666666', '6222021001113379231', '5582875abc');