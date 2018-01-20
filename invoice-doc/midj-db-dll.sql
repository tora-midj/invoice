-- --------------------------------------------------------
-- ホスト:                          127.0.0.1
-- サーバーのバージョン:                   10.1.29-MariaDB - mariadb.org binary distribution
-- サーバー OS:                      Win32
-- HeidiSQL バージョン:               9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- midj のデータベース構造をダンプしています
DROP DATABASE IF EXISTS `midj`;
CREATE DATABASE IF NOT EXISTS `midj` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `midj`;

--  テーブル midj.client の構造をダンプしています
DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `client_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '顧客管理番号',
  `client_charge_last_name` varchar(150) COLLATE utf8_bin NOT NULL COMMENT '顧客担当者氏名（名字）',
  `client_charge_first_name` varchar(159) COLLATE utf8_bin NOT NULL COMMENT '顧客担当者氏名（名前）',
  `client_name` varchar(300) COLLATE utf8_bin NOT NULL COMMENT '法人名',
  `client_address` varchar(300) COLLATE utf8_bin NOT NULL COMMENT '住所',
  `client_tel` varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT '電話番号',
  `client_fax` varchar(150) COLLATE utf8_bin NOT NULL COMMENT 'FAX',
  `create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  `update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `del_flg` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '削除フラグ',
  PRIMARY KEY (`client_no`)
) ENGINE=InnoDB AUTO_INCREMENT=20002 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='顧客管理テーブル';

-- テーブル midj.client: ~0 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`client_no`, `client_charge_last_name`, `client_charge_first_name`, `client_name`, `client_address`, `client_tel`, `client_fax`, `create_datetime`, `update_datetime`, `del_flg`) VALUES
	(20001, '顧客名字', '顧客名前', 'クライアント名', '顧客住所', '03-1234-5678', '03-1234-5678', '2018-01-05 19:25:31', '2018-01-05 19:25:39', '0');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

--  テーブル midj.invoice の構造をダンプしています
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '請求書管理番号',
  `client_no` int(11) NOT NULL COMMENT '顧客管理番号',
  `invoice_status` char(2) COLLATE utf8_bin NOT NULL COMMENT '請求状態',
  `invoice_create_date` date NOT NULL COMMENT '請求書作成日',
  `invoice_title` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '請求書件名',
  `invoice_amt` int(11) NOT NULL COMMENT '消費税',
  `invoice_start_date` date NOT NULL COMMENT '請求期間開始日',
  `invoice_end_date` date NOT NULL COMMENT '請求期間終了日',
  `invoice_note` varchar(3000) COLLATE utf8_bin DEFAULT NULL COMMENT '備考',
  `create_user` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '登録ユーザID',
  `create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  `update_user` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '更新ユーザID',
  `update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `del_flg` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0',
  PRIMARY KEY (`invoice_no`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='請求書テーブル';

-- テーブル midj.invoice: ~7 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` (`invoice_no`, `client_no`, `invoice_status`, `invoice_create_date`, `invoice_title`, `invoice_amt`, `invoice_start_date`, `invoice_end_date`, `invoice_note`, `create_user`, `create_datetime`, `update_user`, `update_datetime`, `del_flg`) VALUES
	(1, 1, '10', '2018-01-03', 'ほげ', 1000, '2018-01-03', '2018-01-03', '備考です。', 'kudarar', '2018-01-03 14:17:39', 'kudarar', '2018-01-03 14:17:06', '0'),
	(2, 1, '20', '2018-01-05', 'ふー', 1200, '2018-01-05', '2018-01-05', '備考２です。', 'kudarar', '2018-01-05 19:29:19', 'kudarar', '2018-01-05 19:29:21', '0'),
	(3, 10, '20', '2018-01-05', 'title', 100, '2018-01-05', '2018-01-05', 'note', 'createUser', '2018-01-05 20:50:06', 'updateUser', '2018-01-05 20:50:06', '0'),
	(5, 10, '20', '2018-01-05', 'title', 100, '2018-01-05', '2018-01-05', 'note', 'createUser', '2018-01-05 21:00:40', 'updateUser', '2018-01-05 21:00:40', '0'),
	(6, 10, '20', '2017-01-01', 'title', 100, '2018-01-05', '2018-01-05', 'note', 'createUser', '2018-01-05 21:10:02', 'updateUser', '2018-01-05 21:10:02', '0'),
	(7, 10, '20', '2018-01-05', 'title', 100, '2018-01-05', '2018-01-05', 'note', 'createUser', '2018-01-05 21:11:30', 'updateUser', '2018-01-05 21:11:30', '0'),
	(8, 10, '20', '2018-01-07', 'title', 100, '2018-01-07', '2018-01-07', 'note', 'createUser', '2018-01-07 20:12:21', 'updateUser', '2018-01-07 20:12:21', '0'),
	(9, 10, '20', '2018-01-07', 'title', 100, '2018-01-07', '2018-01-07', 'note', 'createUser', '2018-01-07 20:14:31', 'updateUser', '2018-01-07 20:14:31', '0');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;

--  テーブル midj.order の構造をダンプしています
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '注文管理番号',
  `client_no` int(11) NOT NULL COMMENT '顧客管理番号',
  `item_no` int(11) NOT NULL COMMENT '商品管理番号',
  `item_name` varchar(300) COLLATE utf8_bin NOT NULL COMMENT '商品名',
  `item_type` char(2) COLLATE utf8_bin NOT NULL COMMENT '商材区分',
  `item_price` int(11) NOT NULL COMMENT '商品販売価格（税抜き）',
  `item_count` int(11) NOT NULL COMMENT '購入数量',
  `create_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  `update_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `del_flg` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '削除フラグ',
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='注文実績テーブル';

-- テーブル midj.order: ~0 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`order_no`, `client_no`, `item_no`, `item_name`, `item_type`, `item_price`, `item_count`, `create_datetime`, `update_datetime`, `del_flg`) VALUES
	(100, 20001, 1, '商品A', '10', 108, 2, '2018-01-05 19:22:28', '2018-01-05 19:23:07', '0');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
