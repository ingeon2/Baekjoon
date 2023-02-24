-- 컬럼명은 '진료과 코드', '5월예약건수'로 지정, 예약한 환자 수를 진료과코드
SELECT MCDP_CD AS "진료과 코드", COUNT(MCDP_CD) AS "5월예약건수"
-- APPOINTMENT 테이블에서
FROM APPOINTMENT
-- 2022년 5월에
WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 5
-- 결과는 진료과별
GROUP BY MCDP_CD
-- 예약한 환자 수를 기준으로 오름차순, 진료과 코드를 기준으로 오름차순
ORDER BY COUNT(MCDP_CD), MCDP_CD