import { combineReducers, createStore } from 'redux';
import userReducer from './reducers/user';


const allReducers = combineReducers({
    user: userReducer,
});

const store = createStore(allReducers);

export default store;

// for now, we have a single reducer...
// but allReducers means there can be multiple

// the "createStore" function excpects one reducer...
// that's why we put it in "allReducers"

// make sure you inform the app to use the store!!
// go to the "main" index.js