/* DB作成 */
DROP DATABASE IF EXISTS taskdb;
CREATE DATABASE taskdb CHARACTER SET utf8 COLLATE utf8_general_ci;

/*DB選択*/
USE taskdb;

/*ユーザーマスタ作成*/
CREATE TABLE taskdb.m_user
(
	user_id VARCHAR(24) NOT NULL PRIMARY KEY,
	password VARCHAR(32) NOT NULL,
	user_name VARCHAR(20) UNIQUE KEY NOT NULL,
	update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/*カテゴリマスタ作成*/
CREATE TABLE taskdb.m_category
(
	category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	catrgory_name VARCHAR(20) NOT NULL UNIQUE KEY,
	update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/*ステータスマスタ作成*/
CREATE TABLE taskdb.m_status

(
	status_code CHAR(2) PRIMARY KEY NOT NULL,
	status_name VARCHAR(20) UNIQUE KEY NOT NULL,
	update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* タスクマスタ作成 */
CREATE TABLE taskdb.t_task
( 
	task_id INT NOT NULL AUTO_INCREMENT,
	task_name   VARCHAR(50) NOT NULL,
	category_id INT NOT NULL,
	limit_date  DATE,
	user_id  VARCHAR(24) NOT NULL,
	status_code  CHAR(2) NOT NULL,
	memo  VARCHAR(100),
	create_datetime  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	update_datetime  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE,
	PRIMARY KEY (task_id)
);

/*カテゴリマスタINSERT*/
INSERT INTO taskdb.m_category (category_name) VALUES ("新商品A：開発プロジェクト");
INSERT INTO taskdb.m_category (category_name) VALUES ("既存商品B：改良プロジェクト");


/*ステータスマスタINSERT*/
INSERT INTO taskdb.m_status (status_code,status_name) VALUES (00,"未着手");
INSERT INTO taskdb.m_status (status_code,status_name) VALUES (50,"着手");
INSERT INTO taskdb.m_status (status_code,status_name) VALUES (99,"完了");

