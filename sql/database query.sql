/*
Query to get the list of users who took the training lesson more than once at the same day, 
grouped by user and training lesson, each ordered from the most recent lesson date to oldest 
date.
*/
SELECT 
	XU.USER_ID , XU.USERNAME,XUT.TRAINING_ID,XUT.TRAINING_DATE, COUNT(*)
FROM SCHEMA.USER XU 
LEFT OUTER JOIN SCHEMA.USER_TRAINING XUT ON XUT.USER_ID = XU.USER_ID
GROUP BY XU.USER_ID , XU.USERNAME,XUT.TRAINING_ID,XUT.TRAINING_DATE
HAVING COUNT(*) > 1
ORDER BY XUT.TRAINING_DATE DESC;