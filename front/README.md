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
    - postcss.config.js 파일 생성 확인.
    - tailwind.config.js 파일 생성 확인.

파일이 생성되었다면, 설치 완료.



## tailwindcss 기본 설정
- tailwind.config.js 수정
```
content: [
  "./src/**/*.{js,jsx,ts,tsx}",
]
```

- src/index.css 수정
```
기존 코드를 다 지우고
@tailwind base;
@tailwind components;
@tailwind utilities;
```

- src/App.jsx 수정
```
function App() {
  return (
    <>
      <h1 className="text-3xl font-bold underline">Hello React!!!</h1>
    </>
  );
}
```


기본 설정 완료.
