## 게시판 -생성
POST /api/boards
### body 파라미터
```json
{
  "name": "자유게시판"
}
```


생성_사용자 콘텐츠 생성 POST /api/users/: 새로운 사용자 생성 POST /api/posts/:새로운 게시글 생성

-조회 GET /api/users/: 모든 사용자 조회 GET /api/users/{id}: 특정 사용자 조회

-수정 사용자 콘텐츠 수정 (PUT /api/posts/{id})

삭제_ 사용자 콘텐츠 삭제 (DELETE /api/posts/{id})

게시글 -생성 POST /api/posts/

-조회 게시글 조회 GET/api/posts 특정게시글 조회 (GET/api/posts/{id})

-수정 사용자 콘텐츠 수정 (PUT /api/posts/{id})

-삭제

사용자 콘텐츠 삭제 (DELETE /api/posts/{id})

댓글

생성 POST /api/comment/

조회 GET/api/comment/

수정 댓글 수정 (PUT /api/comment/{id})

-삭제

댓글 삭제 (DELETE /api/comment/{id})

--------------

    //**리뷰삭제 서비스로직(+관리자 삭제기능)
    @Transactional
    public void deleteReview(Long reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new IllegalArgumentException("리뷰를 찾을 수 없습니다.");
        }

        reviewRepository.deleteById(reviewId);
    }

    //**리뷰수정 서비스로직
    @Transactional
    public void update(Long reviewId, ReviewRequest reviewRequest) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("리뷰를 찾을 수 없습니다."));

        // 리뷰 수정
        review.update(
                reviewRequest.userId(),
                reviewRequest.campaignId(),
                reviewRequest.content(),
                reviewRequest.rating());  // update 메서드를 통해 리뷰 업데이트
    }

//**리뷰 삭제 api
@DeleteMapping("/reviews/{reviewId}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteReview(@PathVariable Long reviewId) {
reviewService.deleteReview(reviewId);
}

    //**리뷰 수정 api
    @PutMapping("/reviews/{reviewId}")
    void updateReview(@PathVariable Long reviewId, @RequestBody ReviewRequest reviewRequest) {
        reviewService.update(reviewId, reviewRequest);
    }