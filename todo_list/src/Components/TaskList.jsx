import React, { useEffect, useState } from "react";
import { getTasks, deleteTask, updateTask } from "../services/TaskService";

const TaskList = () => {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    loadTasks();
  }, []);

  const loadTasks = () => {
    getTasks().then((res) => setTasks(res.data));
  };

  const handleDelete = (id) => {
    deleteTask(id).then(loadTasks);
  };

  const toggleComplete = (task) => {
    updateTask(task.id, { ...task, completed: !task.completed }).then(
      loadTasks
    );
  };

  return (
    <ul>
      {tasks.map((task) => (
        <li key={task.id}>
          <span
            style={{ textDecoration: task.completed ? "line-through" : "" }}
          >
            {task.title}
          </span>
          <button onClick={() => toggleComplete(task)}>Toggle</button>
          <button onClick={() => handleDelete(task.id)}>Delete</button>
        </li>
      ))}
    </ul>
  );
};

export default TaskList;
