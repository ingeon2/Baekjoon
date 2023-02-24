-- 코드를 입력하세요
-- 평균 일일 대여 요금을 출력
-- 소수 첫 번째 자리에서 반올림하고, 컬럼명은 AVERAGE_FEE 로 지정
SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
-- CAR_RENTAL_COMPANY_CAR 테이블에서
FROM CAR_RENTAL_COMPANY_CAR
-- 자동차 종류가 'SUV'인 자동차들의
WHERE CAR_TYPE = "SUV"