# 📝 Spring Boot & React 기반 블로그 프로젝트

Java Spring Boot와 JPA를 기반으로 구축한 블로그 백엔드 및 React/Vite 기반 프론트엔드 레포지토리입니다.

---

## 🛠 주요 의존성 (Tech Stack & Dependencies)

### 🟢 Backend
- **`spring-boot-starter-web`**
    - RESTful 웹 애플리케이션 및 서버 구축
- **`spring-boot-starter-data-jpa`**
    - DB 영속성 관리 및 ORM(Object-Relational Mapping) 적용
- **`spring-boot-starter-validation`**
    - DTO 객체의 유효성 및 입력값 검증

### 🔵 Frontend
- **`Vite`** (`^8.3.4`)
    - 빠르고 경량화된 번들링 및 개발 서버 프록시 설정
- **`React Router`** (`^8.5.0`)
    - 싱글 페이지 애플리케이션(SPA) 내 화면 전환 및 라우팅

---

## 🚀 백엔드 API 명세 (API Endpoints)

| 기능 | HTTP Method | Endpoint | 설명 |
| :--- | :---: | :--- | :--- |
| **Create** | `POST` | `/api/posts/` | 게시글 단건 생성 |
| **Read (목록)** | `GET` | `/api/posts` | 게시글 전체 목록 조회 |
| **Read (상세)** | `GET` | `/api/posts/{postId}` | 게시글 상세 내용 조회 |
| **Update** | `PUT` | `/api/posts/{postId}` | 게시글 단건 수정 |
| **Delete** | `DELETE` | `/api/posts/{postId}` | 게시글 단건 삭제 |

---

## 🖥 프론트엔드 화면 구성 (Presentation)

1. **홈 화면 (`/`)**
    - **구성 요소:** 블로그 홈 헤더, 게시글 목록
2. **블로그 상세 화면 (`/posts/:postId`)**
    - **구성 요소:** 게시글 제목, 내용, 작성일