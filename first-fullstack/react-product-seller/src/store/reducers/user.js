import { CLEAR_CURRENT_USER, SET_CURRENT_USER } from '../types';

// reducers call the action functions && update the state

const userReducer = (state = {}, action) => {
  switch (action?.type) {
      case SET_CURRENT_USER:
          localStorage.setItem('currentUser', JSON.stringify(action?.payload));
          return action?.payload;
      case CLEAR_CURRENT_USER:
          localStorage.removeItem('currentUser');
          return null;
      default:
          return JSON.parse(localStorage.getItem('currentUser'));
  };
};

export default userReducer;

// reducers update the state aaaaaand
// the "default case" is the initial state

// see all the "localStorage" stuff???
// :(
// :)