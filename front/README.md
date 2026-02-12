# React + Vite (VSCode)

React Vite형식으로 프로젝트를 제작.

```bash
cd front
npm create vite@latest
npm run dev
```
- vite 설치할 때
    - Select a framework : React
    - Select a variant : JavaScript
    - Use Vite 8 beta : No
    - Install ~~~ start now ? : Yes

## tailwindcss

Tailwind CSS 프레임워크를 사용하고 있음.

(front/ 에서 설치 진행)
```bash
npm install -D tailwindcss@3.4.17 postcss autoprefixer
npx tailwindcss init -p
npm run dev
```
- [X]postcss.config.js 파일 생성 확인.
- [X]tailwind.config.js 파일 생성 확인.


## Expanding the ESLint configuration

If you are developing a production application, we recommend using TypeScript with type-aware lint rules enabled. Check out the [TS template](https://github.com/vitejs/vite/tree/main/packages/create-vite/template-react-ts) for information on how to integrate TypeScript and [`typescript-eslint`](https://typescript-eslint.io) in your project.
