-- 코드를 입력하세요
# SELECT A.REST_ID, B.REST_NAME, B.FOOD_TYPE, B.FAVORITES, B.ADDRESS, ROUND(AVG(A.REVIEW_SCORE),2) AS SCORE
# FROM REST_REVIEW A
# JOIN REST_INFO B ON A.REST_ID = B.REST_ID
# WHERE B.ADDRESS LIKE '%서울%'
# GROUP BY A.REST_ID
# # HAVING B.ADDRESS LIKE '%서울%'
# ORDER BY SCORE DESC, B.FAVORITES DESC;

SELECT B.REST_ID,	REST_NAME,	FOOD_TYPE,	FAVORITES,	ADDRESS,	round(avg(REVIEW_SCORE),2) as SCORE
from REST_INFO A
join REST_REVIEW B on A.REST_ID=B.REST_ID
where ADDRESS like '서울%'
group by REST_ID
#having ADDRESS like '서울%'
order by SCORE desc,FAVORITES desc