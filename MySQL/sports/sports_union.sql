(SELECT s.name as Sport, sg.location as Place
FROM sports as s
LEFT JOIN sportgroups as sg
ON s.id = sg.sport_id)
UNION
(SELECT sports.name, sportgroups.location
FROM sports 
RIGHT JOIN sportgroups
ON sports.id = sportgroups.sport_id);
