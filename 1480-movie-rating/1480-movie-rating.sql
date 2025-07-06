(SELECT Users.name AS results
                          FROM Users,
                               MovieRating
                          WHERE MovieRating.user_id = Users.user_id
                          GROUP BY name
                          ORDER BY COUNT(*) DESC, name
                          LIMIT 1)
UNION ALL
(SELECT Movies.title AS results
                          FROM Movies,
                               MovieRating
                          WHERE MONTHNAME(created_at) = 'FEBRUARY'
                            AND YEAR(created_at) = '2020'
                            AND Movies.movie_id = MovieRating.movie_id
                          GROUP BY Movies.title
                          ORDER BY AVG(rating) DESC, Movies.title
                          LIMIT 1);