import { combineReducers } from "redux";
import { reducer as formReducer } from "redux-form";
import PostsReducer from "./reducer_tasks";

const rootReducer = combineReducers({
  tasks: PostsReducer,
  form: formReducer
});

export default rootReducer;
