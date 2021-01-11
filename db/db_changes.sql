-- plamena, 11.01
alter table answers
	add survey_id int(10) null;

alter table answers
	add constraint answers_surveys_id_fk
		foreign key (survey_id) references surveys (survey_id);

alter table surveys
    change suvrvey_name survey_name text not null;
-- end