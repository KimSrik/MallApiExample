// Dispatcher Servlet (Front Controller) 역할
import { createBrowserRouter } from "react-router-dom";
import { Suspense, lazy } from "react";
import todoRouter from "./todoRouter";

const Loading = <div>Loading...</div>;

// lazy() 지연 로딩.
// 데이터가 다 들어와야 로딩이 된다.
const Main = lazy( () => import("../pages/MainPage") );
const About = lazy( () => import("../pages/AboutPage") );
const TodoIndex = lazy ( () => import("../pages/todo/IndexPage") );
const TodoList = lazy ( ()=> import("../pages/todo/ListPage") );



const root = createBrowserRouter([
    {
        path:"",
        element:<Suspense fallback={Loading}><Main></Main></Suspense>
    },
    {
        path:"about",
        element:<Suspense fallback={Loading}><About></About></Suspense>
    },
    {
        path:"todo",
        element:<Suspense fallback={Loading}><TodoIndex></TodoIndex></Suspense>,
        children:todoRouter()
    }

]);

export default root;