import { useEffect, useState } from "react";
import { getOne } from "../../api/todoApi";

const initState = {
  tno:0,
  title:'',
  writer:'',
  dueDate:null,
  complete:false
}

const ReadComponent = ( {tno} ) => {
  const [todo, setTodo] = useState(initState)

  useEffect( () => {
    getOne(tno).then( data => {
      console.log(data);
      setTodo(data);
    })
  }, [tno]);
  // 비동기 통신. 
  // 데이터 변화가 있으면 데이터가 다 오면 한번만 실행함.
  // 데이터 변화에 취약하기 때문에 비동기 통신을 씀.

  return (
    <div>

    </div>
  )
}

export default ReadComponent;