-- plamena, 11.01
alter table answers
	add survey_id int(10) null;

alter table answers
	add constraint answers_surveys_id_fk
		foreign key (survey_id) references surveys (survey_id);

alter table surveys
    change suvrvey_name survey_name text not null;
-- end

--alex, 16.01
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
-- --------------------------------------------------------

--
-- Структура на таблица `submitted`
--

CREATE TABLE `submitted` (
  `submit_id` int(11) NOT NULL,
  `survey_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer_id` int(11) NOT NULL,
  `user_key` int(11) NOT NULL,
  `time_submitted` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for table `submitted`
--
ALTER TABLE `submitted`
  ADD PRIMARY KEY (`submit_id`);

--
-- AUTO_INCREMENT for table `submitted`
--
ALTER TABLE `submitted`
  MODIFY `submit_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

--
-- restart the data
--
delete from answers;
delete from questions;
delete from submitted;
delete from surveys;
delete from users;

--
-- restart auto increment
--

ALTER TABLE answers AUTO_INCREMENT = 1;
ALTER TABLE questions AUTO_INCREMENT = 1;
ALTER TABLE submitted AUTO_INCREMENT = 1;
ALTER TABLE surveys AUTO_INCREMENT = 1;
ALTER TABLE users AUTO_INCREMENT = 1;

--
-- fill tables with accurate data
--

--
-- Схема на данните от таблица `answers`
--
INSERT INTO `answers` VALUES
(1, 1, 'Да, много.', 1),
(2, 1, 'Става.', 1),
(3, 1, 'Не.', 1),
(4, 2, 'Отлично', 2),
(5, 2, 'Под средното', 2),
(6, 2, 'Добро	', 2),
(7, 2, 'Слабо', 2),
(8, 2, 'Средно', 2),
(9, 3, 'Отлично', 2),
(10, 3, 'Добро	', 2),
(11, 3, 'Слабо', 2),
(12, 3, 'Средно', 2),
(13, 3, 'Под средното', 2),
(14, 4, 'Отлично', 2),
(15, 4, 'Добро', 2),
(16, 4, 'Средно', 2),
(17, 4, 'Под средното', 2),
(18, 4, 'Слабо', 2),
(19, 5, 'Отлично', 2),
(20, 5, 'Добро', 2),
(21, 5, 'Средно', 2),
(22, 5, 'Слабо', 2),
(23, 5, 'Под средното', 2),
(24, 6, 'Добро', 2),
(25, 6, 'Отлично', 2),
(26, 6, 'Средно', 2),
(27, 6, 'Под средното', 2),
(28, 6, 'Слабо', 2),
(29, 7, 'Отлично', 2),
(30, 7, 'Слабо', 2),
(31, 7, 'Под средното', 2),
(32, 7, 'Добро', 2),
(33, 7, 'Средно', 2),
(34, 8, 'Отлично', 2),
(35, 8, 'Добро', 2),
(36, 8, 'Под средното', 2),
(37, 8, 'Средно', 2),
(38, 8, 'Слабо', 2),
(39, 9, 'Отличен', 2),
(40, 9, 'Слаб', 2),
(41, 9, 'Добър', 2),
(42, 9, 'Под среден', 2),
(43, 9, 'Среден', 2);

--
-- Схема на данните от таблица `questions`
--
INSERT INTO `questions` VALUES
(1, 1, 'Харесва ли ти това уеб приложение?'),
(2, 2, 'Моля, оценете забавленията в курорта:'),
(3, 2, 'Моля оценете обществените места в курорта:'),
(4, 2, 'Моля оценете приятелско отношение, честност и отзивчивост на персонала:'),
(5, 2, 'Моля, оценете декора в стаите:'),
(6, 2, 'Моля, оценете поддръжка и чистота на стаите:'),
(7, 2, 'Моля, оценете качеството на храната:'),
(8, 2, 'Моля, оценете качеството за платената цена:'),
(9, 2, 'Като цяло Вашата оценка за хотела/курорта е:');

--
-- Схема на данните от таблица `submitted`
--
INSERT INTO `submitted` VALUES
(1, 1, 1, 1, 905, '2021-01-16 14:26:06'),
(2, 1, 1, 1, 798, '2021-01-16 14:26:25'),
(3, 1, 1, 1, 938, '2021-01-16 14:32:50'),
(4, 2, 2, 4, 235, '2021-01-16 14:36:03'),
(5, 2, 3, 9, 235, '2021-01-16 14:36:03'),
(6, 2, 4, 14, 235, '2021-01-16 14:36:03'),
(7, 2, 5, 19, 235, '2021-01-16 14:36:03'),
(8, 2, 6, 24, 235, '2021-01-16 14:36:03'),
(9, 2, 7, 29, 235, '2021-01-16 14:36:03'),
(10, 2, 8, 34, 235, '2021-01-16 14:36:03'),
(11, 2, 9, 39, 235, '2021-01-16 14:36:03');

--
-- Схема на данните от таблица `surveys`
--
INSERT INTO `surveys` VALUES
(1, 'About Survey Maker', 1),
(2, 'Удовлетвореност на клиентите от хотел', 2);

--
-- Схема на данните от таблица `users`
--

INSERT INTO `users` VALUES
(1, 'user', 'user', ''),
(2, 'someUser', 'Mypassword.123', 'somemail@abv.bg');
--end