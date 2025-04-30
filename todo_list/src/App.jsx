// import { useState } from "react";
// import reactLogo from "./assets/react.svg";
// import viteLogo from "/vite.svg";
// import "./App.css";

// function App() {
//   const [count, setCount] = useState(0);

//   return (
//     <>
//       <div>
//         <h1>To Do List </h1>
//       </div>
//     </>
//   );
// }

// export default App;
import React from "react";
import TaskList from './Components/TaskList';
import TaskForm from './Components/TaskForm';

function App() {
  return (
    <div>
      <h1>To-Do List</h1>
      <TaskForm />
      <TaskList />
    </div>
  );
}

export default App;
