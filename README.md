게시판
-생성
생성_사용자 콘텐츠 생성
POST /api/users/: 새로운 사용자 생성
POST /api/posts/:새로운 게시글 생성

-조회 
GET /api/users/: 모든 사용자 조회
GET /api/users/{id}: 특정 사용자 조회


-수정
사용자 콘텐츠 수정
(PUT /api/posts/{id})

삭제_
사용자 콘텐츠 삭제
(DELETE /api/posts/{id})



게시글
-생성
POST /api/posts/

-조회 
게시글 조회 
GET/api/posts
특정게시글 조회 
(GET/api/posts/{id})


-수정
사용자 콘텐츠 수정
(PUT /api/posts/{id})


-삭제

사용자 콘텐츠 삭제
(DELETE /api/posts/{id})



댓글

생성
POST /api/comment/

조회
GET/api/comment/

수정
댓글 수정
(PUT /api/comment/{id})

-삭제

댓글 삭제
(DELETE /api/comment/{id})











