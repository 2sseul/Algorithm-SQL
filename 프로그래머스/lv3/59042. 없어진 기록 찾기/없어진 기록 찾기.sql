-- 코드를 입력하세요
SELECT b.ANIMAL_ID, b.NAME
FROM ANIMAL_OUTS b LEFT OUTER JOIN ANIMAL_INS a ON b.ANIMAL_ID = a.ANIMAL_ID
WHERE b.NAME IS NOT NULL && a.NAME IS NULL;