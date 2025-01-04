-- 코드를 작성해주세요
WITH SCORE AS (
    SELECT EMP_NO, AVG(SCORE) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
),
GRADE AS (
    SELECT EMP_NO, SCORE, (CASE WHEN SCORE >= 96 THEN 'S' 
                                WHEN SCORE >= 90 THEN 'A' 
                                WHEN SCORE >= 80 THEN 'B' 
                                ELSE 'C' END) AS GRADE
    FROM SCORE
)

SELECT E.EMP_NO, E.EMP_NAME, G.GRADE, CASE WHEN G.GRADE = 'S' THEN E.SAL * 0.2 
                                           WHEN G.GRADE = 'A' THEN E.SAL * 0.15
                                           WHEN G.GRADE = 'B' THEN E.SAL * 0.1
                                           ELSE 0 END AS BONUS
FROM HR_EMPLOYEES E LEFT JOIN GRADE G ON E.EMP_NO = G.EMP_NO
ORDER BY E.EMP_NO