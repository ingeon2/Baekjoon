-- 진료과코드 별로 조회하는 SQL문을 작성해주세요. 이때, 컬럼명은 '진료과 코드', '5월예약건수'로 지정
SELECT MCDP_CD AS "진료과 코드", COUNT(MCDP_CD) AS "5월예약건수"
-- APPOINTMENT 테이블에서
FROM APPOINTMENT
-- 2022년 5월에
WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 5
-- 결과는 진료과별 (진료과 마다 COUNT(MCDP_CD))
GROUP BY MCDP_CD
-- 예약한 환자 수를 기준으로 오름차순, 진료과 코드를 기준으로 오름차순
ORDER BY COUNT(MCDP_CD), MCDP_CD