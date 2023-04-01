-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문
-- (아웃엔 잇는데 인엔 없는 얘들)
SELECT A.ANIMAL_ID, A.NAME
-- 라이트아우터쪼인
FROM ANIMAL_OUTS A
LEFT JOIN ANIMAL_INS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- 인엔 업는 애들
WHERE B.ANIMAL_ID IS NULL;