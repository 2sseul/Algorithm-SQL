-- 코드를 입력하세요
SELECT CART_ID
FROM CART_PRODUCTS
WHERE (CART_ID) IN (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME = 'Yogurt' GROUP BY CART_ID) AND (CART_ID) IN (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME = 'Milk' GROUP BY CART_ID)
GROUP BY CART_ID;