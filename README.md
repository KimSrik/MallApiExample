# 풀스택 예제 프로젝트 (React + Spring Boot + MariaDB)

## 프로젝트 구조
- `front/` : React Frontend (VSCode로 개발)
- `back/`  : Spring Boot Backend (Eclipse로 개발)

## 실행 방법

### Backend (Spring Boot) - Eclipse
1. Eclipse에서 File → Import → Existing Maven Projects
2. back 폴더 선택
3. Run As → Spring Boot App

### Frontend (React) - VSCode
```bash
cd front
npm create vite@latest
npm run dev
```
- vite 설치할 때
[X] Select a framework : React
[X] Select a variant : JavaScript
[X] Use Vite 8 beta : No
[X] Install ~~~ start now ? : Yes



## 개발 환경
- Frontend: React, VSCode
- Backend: Spring Boot, Eclipse
- Database: MariaDB

## 포트 설정
- Frontend: http://localhost:5173
- Backend: http://localhost:8080