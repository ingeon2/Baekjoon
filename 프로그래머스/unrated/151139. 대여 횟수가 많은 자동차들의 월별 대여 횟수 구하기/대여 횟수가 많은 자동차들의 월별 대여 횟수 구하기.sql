-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS "MONTH", CAR_ID, COUNT(CAR_ID) AS "RECORDS"
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
--  대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차
WHERE START_DATE BETWEEN "2022-08-01" AND "2022-10-31"
    AND CAR_ID IN (
        --  2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE BETWEEN "2022-08-01" AND "2022-10-31"
        GROUP BY CAR_ID
        HAVING COUNT(CAR_ID) >= 5
    )

GROUP BY CAR_ID, MONTH
HAVING RECORDS > 0
-- 결과는 월을 기준으로 오름차순 정렬하고, 월이 같다면 자동차 ID를 기준으로 내림차순 정렬
ORDER BY MONTH, CAR_ID DESC;
