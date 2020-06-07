```mysql
CREATE TABLE IF NOT EXISTS lagou_teacher(
	tid INT PRIMARY KEY AUTO_INCREMENT,
	tname VARCHAR(10),
	intro VARCHAR(50),
	tlevel CHAR(4),
	KEY ind_name(tname)
);

CREATE TABLE IF NOT EXISTS lagou_subject(
	sid INT PRIMARY KEY AUTO_INCREMENT,
	sname VARCHAR(10),
	description VARCHAR(50),
	create_time DATE,
	update_time DATE
);

CREATE TABLE IF NOT EXISTS lagou_course(
	cid INT PRIMARY KEY AUTO_INCREMENT,
	teacher_id INT,
	subject_id INT,
	title VARCHAR(10),
	total_time INT,
	read_time BIGINT,
	course_status CHAR(1) DEFAULT '0',
	INDEX ind_title(title),
	CONSTRAINT for_teacher FOREIGN KEY(teacher_id) REFERENCES lagou_teacher(tid),
	CONSTRAINT for_subject FOREIGN KEY(subject_id) REFERENCES lagou_subject(sid)
);


-- 向讲师表插入两条数据 
INSERT INTO lagou_teacher VALUES (1, '刘德华', '毕业于清华大学，主攻前端技术,授课风格生动活泼,深受学员喜爱', '高级讲师'); 
INSERT INTO lagou_teacher VALUES (2, '郭富城', '毕业于北京大学，多年的IT经验，研发多项Java课题,授课经验丰富', '首席讲师');

SELECT * FROM lagou_teacher;

-- 向课程分类表中插入两条数据 
INSERT INTO lagou_subject VALUES (1, '后端开发', '后端课程包括 Java PHP Python', '2020-03-27 00:44:04', '2020-03-27 00:44:04'); 
INSERT INTO lagou_subject VALUES (2, '前端开发', '前端课程包括 JQuery VUE angularJS', '2020-02-27 10:00:04', '2020-02-27 18:44:04');

SELECT * FROM lagou_subject;

-- 向课程表中插入两条数据 
-- 插入Java课程 
INSERT INTO lagou_course VALUES (1,1,2 ,'Java', 300,250000, '1'); 
-- 插入VUE课程 
INSERT INTO lagou_course VALUES (2,2,1, 'VUE', 400,200000,'1');

# 查询刘德华老师所教的课程属于哪个课程分类
	-- 查询刘德华老师的id
	-- 查询该id有哪些课程
	-- 查询这些课程的分类

SELECT 
sname 
FROM lagou_subject 
WHERE sid IN (
SELECT 
subject_id FROM lagou_course 
WHERE teacher_id = (SELECT tid FROM lagou_teacher WHERE tname = '刘德华')
);

```

