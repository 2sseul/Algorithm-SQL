-- 코드를 작성해주세요
WITH COLONY AS(
    SELECT ID, SIZE_OF_COLONY, 
    ROW_NUMBER() OVER(ORDER BY SIZE_OF_COLONY DESC) AS NUM
    FROM ECOLI_DATA
)

SELECT ID, 
CASE WHEN NUM <= (SELECT COUNT(ID) FROM ECOLI_DATA)*0.25 THEN 'CRITICAL'  
WHEN NUM > (SELECT COUNT(ID) FROM ECOLI_DATA)*0.25 AND NUM <= (SELECT COUNT(ID) FROM ECOLI_DATA)*0.5 THEN 'HIGH'
WHEN NUM > (SELECT COUNT(ID) FROM ECOLI_DATA)*0.5 AND NUM <= (SELECT COUNT(ID) FROM ECOLI_DATA)*0.75 THEN 'MEDIUM' 
ELSE 'LOW' END AS COLONY_NAME 
FROM COLONY
ORDER BY ID;

