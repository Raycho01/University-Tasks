-- 1
INSERT INTO students (name, egn, address, phone, class)
VALUES("Ivan Ivanov", "9207186371", "Sofia-Serdica", "0888892950", "10");


-- 2
SELECT * 
FROM students
ORDER BY name;


-- 3
DELETE
FROM students
WHERE name = "Ivan Ivanov";


-- 4
SELECT students.name, sports.name
FROM students
JOIN student_sport
ON student_sport.student_id = students.id
JOIN sportgroups
ON sportgroups.id = student_sport.sportGroup_id
JOIN sports
ON sports.id = sportgroups.sport_id;


-- 5
SELECT students.name, students.class, sportgroups.id
FROM students
JOIN student_sport
ON student_sport.student_id = students.id
JOIN sportgroups
ON sportgroups.id = student_sport.sportGroup_id
WHERE sportgroups.dayOfWeek = "Sunday";


-- 6
SELECT coaches.name
FROM coaches
JOIN sportGroups
ON sportgroups.coach_id = coaches.id
JOIN sports
ON sports.id = sportgroups.sport_id
WHERE sports.name = "Football";


-- 7
SELECT sportgroups.location, sportgroups.dayOfWeek, sportgroups.hourOfTraining
FROM sportgroups
JOIN sports
ON sportgroups.sport_id = sports.id
WHERE sports.name = "Volleyball";


-- 8
SELECT sports.name
FROM sports
JOIN sportgroups
ON sportgroups.sport_id = sports.id
JOIN student_sport
ON student_sport.sportGroup_id = sportgroups.id
JOIN students
ON students.id = student_sport.student_id
WHERE students.name = "Iliyan Ivanov";


-- 9
SELECT students.name
FROM students
JOIN student_sport
ON student_sport.student_id = students.id
JOIN sportgroups
ON sportgroups.id = student_sport.sportGroup_id
JOIN coaches
ON coach_id = sportgroups.coach_id
JOIN sports
ON sports.id = sportgroups.sport_id
WHERE sports.name = "Football" AND coaches.name = "Ivan Todorov Petkov";


-- 10
SELECT students.name, SUM(taxespayments.paymentAmount) AS totalTax FROM students
JOIN taxespayments ON taxespayments.student_id = students.id
GROUP BY taxespayments.student_id, taxespayments.year;