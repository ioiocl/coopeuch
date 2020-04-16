import axios from "axios";

export const FETCH_TASKS = "fetch_tasks";
export const FETCH_TASK = "fetch_task";
export const CREATE_TASK = "create_task";
export const DELETE_TASK = "delete_task";
export const UPDATE_TASK = "update_task";

const ROOT_URL = "http://localhost:8443/api";


export function fetchTasks() {
  const request = axios.get(`${ROOT_URL}/tasks`);

  return {
    type: FETCH_TASKS,
    payload: request
  };
}

export function createTask(values, callback) {
  const request = axios
    .post(`${ROOT_URL}/tasks`, values)
    .then(() => callback());

  return {
    type: CREATE_TASK,
    payload: request
  };
}

export function fetchTask(id) {
  const request = axios.get(`${ROOT_URL}/tasks/${id}`);

  return {
    type: FETCH_TASK,
    payload: request
  };
}

export function deleteTask(id, callback) {
  const request = axios
    .delete(`${ROOT_URL}/tasks/${id}`)
    .then(() => callback());

  return {
    type: DELETE_TASK,
    payload: id
  };
}

export function updateTask(values, callback) {
  const request = axios
      .put(`${ROOT_URL}/tasks`, values)
      .then(() => callback());

  return {
    type: UPDATE_TASK,
    payload: request
  };
}
