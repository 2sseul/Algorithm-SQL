-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE CONV(GENOTYPE, 10, 2) = 1 OR 
CONV(GENOTYPE, 10, 2) LIKE '%101' OR
CONV(GENOTYPE, 10, 2) LIKE '%100' OR
CONV(GENOTYPE, 10, 2) LIKE '%001';