import store from '../store';
import axios from 'axios';
import { clearCurrentUser } from '../store/actions/user';
import { history } from '../common/history';

//////////////////////////////////////
// Regarding the JsonWebToken

// http header - equal to function authHeader()
export const authHeader = () => {
  const currentUser = store.getState().user;

  // key-value properties for auth-header
  return {
      'Content-Type': 'application/json',
      'authorization': 'Bearer ' + currentUser?.token,
  };
};

//////////////////////////////////////
// Also regarding the JWT
// to check if the Token is still valid,
// we will add this funcion...
export function handleResponseWithLoginCheck() {
    axios.interceptors.response.use(
        response => response,
        error => {
            const currentUser = store.getState().user;
            const isLoggedIn = currentUser?.token;
            const status = error?.response?.status;

            if (isLoggedIn && [401,403].includes(status)) {
                store.dispatch(clearCurrentUser());
                history.push('/login');
            }

            return Promise.reject(error);
        }
        );
};
