# 웹사이트 연습

## 화면(UI/UX) 설계

#### 1. 회원
- 회원가입 페이지 (`/users/signup`)
  - 입력: 아이디, 비밀번호, 이름, 이메일, 프로필 이미지(선택)
  - 버튼: 가입하기
- 로그인 페이지 (`/users/login`)
  - 입력: 아이디, 비밀번호
  - 버튼: 로그인
- 마이페이지 (`/users/mypage`)
  - 기능: 회원정보 수정, 비밀번호 변경, 계정 비활성화
  - 프로필 이미지 업로드
- 로그아웃 (`/users/logout`)

#### 2. 게시판
- 게시글 목록 (`/boards/list`)
  - 기능: 카테고리별 탭(공지/자유/질문), 검색창, 정렬(최신순/인기순)
  - 출력: 제목, 작성자, 조회수, 댓글 수, 좋아요 수
- 게시글 작성 (`/boards/write`)
  - 입력: 제목, 내용, 카테고리 선택, 첨부파일 업로드
- 게시글 상세 (`/boards/{id}`)
  - 표시: 제목, 작성자, 작성일, 조회수, 본문, 첨부파일
  - 기능: 좋아요, 수정/삭제(작성자만), 신고
  - 댓글 리스트 출력
- 게시글 수정 (`/boards/{id}/edit`)
  - 기존 데이터 로딩 후 수정 가능

#### 3. 댓글
- 댓글 영역 (게시글 상세 페이지 하단)
  - 댓글 작성 입력창
  - 댓글 목록: 작성자, 작성일, 내용, 좋아요, 신고
  - 대댓글 기능 (2단계까지만)
  - 정렬 옵션: 최신순, 좋아요순

#### 4. 검색
- 검색 결과 페이지 (`/boards/search`)
  - 검색 조건: 제목, 내용, 작성자, 카테고리
  - 출력: 게시글 목록 (제목, 작성자, 날짜, 조회수)

#### 5. 관리자
- 회원 관리 페이지 (`/admin/users`)
  - 출력: 회원 리스트 (아이디, 이메일, 상태)
  - 기능: 계정 상태 변경 (활성/비활성)
- 게시글 관리 페이지 (`/admin/boards`)
  - 출력: 신고된 게시글 리스트
  - 기능: 게시글 삭제, 신고 카운트 초기화


# DB 스키마

## Tables

- **users**
  - user_id (PK)
  - password
  - name
  - email (UNIQUE)
  - role
  - status
  - profile_img
  - created_at
  - last_login_at

- **boards**
  - board_id (PK)
  - title
  - content
  - writer_id (FK → users.user_id)
  - views
  - category
  - pinned
  - like_count
  - comment_count
  - report_count
  - created_at
  - updated_at
  - deleted_at

- **comments**
  - comment_id (PK)
  - board_id (FK → boards.board_id)
  - writer_id (FK → users.user_id)
  - parent_id (FK → comments.comment_id)
  - content
  - like_count
  - report_count
  - comment_count
  - created_at
  - updated_at
  - deleted_at

- **files**
  - file_id (PK)
  - board_id (FK → boards.board_id)
  - original_name
  - saved_name
  - file_type
  - size
  - download_count
  - created_at

- **likes**
  - like_id (PK)
  - target_type
  - target_id
  - user_id (FK → users.user_id)
  - created_at
  - UNIQUE (target_type, target_id, user_id)

- **reports**
  - report_id (PK)
  - target_type
  - target_id
  - reporter_id (FK → users.user_id)
  - reason
  - created_at
  - UNIQUE (target_type, target_id, reporter_id)


## Relationships

- users 1:N boards
- users 1:N comments
- users 1:N likes
- users 1:N reports
- boards 1:N comments
- boards 1:N files
- comments 1:N comments
- boards/comments 1:N likes
- boards/comments 1:N reports