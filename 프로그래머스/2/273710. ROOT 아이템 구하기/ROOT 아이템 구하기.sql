-- 코드를 작성해주세요
SELECT DISTINCT A.ITEM_ID, A.ITEM_NAME
FROM ITEM_INFO A JOIN ITEM_TREE B ON B.ITEM_ID = A.ITEM_ID
WHERE PARENT_ITEM_ID IS NULL
ORDER BY A.ITEM_ID;