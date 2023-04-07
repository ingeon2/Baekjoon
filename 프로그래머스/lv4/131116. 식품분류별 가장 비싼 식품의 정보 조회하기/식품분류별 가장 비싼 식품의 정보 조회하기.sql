-- FOOD_PRODUCT 테이블에서 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회하는 SQL문
SELECT CATEGORY, PRICE AS "MAX_PRICE", PRODUCT_NAME
FROM FOOD_PRODUCT
-- 식품분류별로 가격이 제일 비싼 식품, 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력
WHERE (CATEGORY, PRICE) IN (SELECT CATEGORY, MAX(PRICE)
               FROM FOOD_PRODUCT
               GROUP BY CATEGORY)
               AND CATEGORY IN ("과자", "국", "김치", "식용유")

-- 결과는 식품 가격을 기준으로 내림차순 정렬
ORDER BY MAX_PRICE DESC;