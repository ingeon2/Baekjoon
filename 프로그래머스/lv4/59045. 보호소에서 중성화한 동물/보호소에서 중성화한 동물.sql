--  동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문
SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME

FROM ANIMAL_INS A
INNER JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID

-- 보호소에 들어올 당시에는 중성화1되지 않았지만, 보호소를 나갈 당시에는 중성화된
WHERE (A.SEX_UPON_INTAKE = "Intact Male" OR A.SEX_UPON_INTAKE = "Intact Female")
AND
(B.SEX_UPON_OUTCOME = "Spayed Female" OR
 B.SEX_UPON_OUTCOME = "Spayed Male" OR
 B.SEX_UPON_OUTCOME = "Neutered Male" OR
 B.SEX_UPON_OUTCOME = "Neutered Female");