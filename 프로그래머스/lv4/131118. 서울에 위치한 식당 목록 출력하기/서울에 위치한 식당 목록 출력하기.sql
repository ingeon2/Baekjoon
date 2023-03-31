-- REST_INFO와 REST_REVIEW 테이블에서 서울에 위치한 식당들의 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회
-- 리뷰 평균점수는 소수점 세 번째 자리에서 반올림
SELECT A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, ROUND(AVG(B.REVIEW_SCORE), 2) AS SCORE
-- 식당 ID 를 공유해서
-- 여기서 핵심은, FROM 과 JOIN 에서 테이블을 지정해주는것
FROM REST_INFO A
INNER JOIN REST_REVIEW B ON A.REST_ID = B.REST_ID
-- 리뷰 평균 점수를 조회하려면 뭐에 따라 평균낼건지 골라야지. 그게 식당 ID가 될거고 그걸로 그룹바이 해야겠다.
GROUP BY A.REST_ID
-- 서울에 위치한 (= 말고 LIKE 써야한다)
HAVING A.ADDRESS LIKE "서울%"
-- 결과는 평균점수를 기준으로 내림차순 정렬, 즐겨찾기수를 기준으로 내림차순
ORDER BY AVG(B.REVIEW_SCORE) DESC, A.FAVORITES DESC