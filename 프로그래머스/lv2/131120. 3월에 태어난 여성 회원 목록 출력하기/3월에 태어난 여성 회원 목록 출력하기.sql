-- ID, 이름, 성별, 생년월일을 조회
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d") AS DATE_OF_BIRTH
-- MEMBER_PROFILE 테이블에서
FROM MEMBER_PROFILE
-- 생일이 3월인 여성 회원의
-- 전화번호가 NULL인 경우는 출력대상에서 제외
-- 조건 순서 맞추기
WHERE MONTH(DATE_OF_BIRTH) = 3 AND GENDER = "W" AND TLNO IS NOT NULL
-- 결과는 회원ID를 기준으로 오름차순 정렬
ORDER BY MEMBER_ID ASC;