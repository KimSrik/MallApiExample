import { RouterProvider } from "react-router-dom"
import root from "./router/root"

function App() {

  return (
    <>
      <RouterProvider router = {root}></RouterProvider>
    </>
  )
}

export default App

// 받을 때 const로 App() 함수를 받고,
// 선언할 땐 function App(){} 선언하고,
// 선언 후에 내보내기 export가 이뤄져야한다.
