SELECT firstStudent.name AS Student1, secondStudent.name AS Student2, sports.name AS Sport
FROM students as firstStudent 
JOIN students as secondStudent
ON firstStudent.id < secondStudent.id
JOIN sports
ON 
	(
		firstStudent.id IN 
			(
				SELECT student_id
				FROM student_sport
				WHERE sportGroup_id IN (SELECT id FROM sportgroups WHERE sportgroups.sport_id = sports.id)
			)
	)
AND
	(
	secondStudent.id IN 
		(
			SELECT student_id FROM student_sport WHERE sportGroup_id IN (SELECT id fROM sportgroups WHERE sportgroups.sport_id = sports.id)
		)
	)
WHERE firstStudent.id IN
	(
		SELECT student_id FROM student_sport WHERE sportGroup_id IN (SELECT sportGroup_id FROM student_sport WHERE student_id = secondStudent.id)
	)
ORDER BY Sport;