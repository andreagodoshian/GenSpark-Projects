import { useSelector } from 'react-redux';
import { Navigate } from 'react-router-dom';

// this guard will work for users that are signed-in
// then each route has a "role" attribute

// also need to navigate to main App.js && add
// AuthGuard to guarded pages

export const AuthGuard = ({ children, roles }) => {

    // need current user, to determine role
    const currentUser = useSelector(state => state.user);

    // if user hasn't signed-in
    // if user isn't authorized, redirect
    const authorize = () => {
      if (!currentUser) {
          return (<Navigate to={{pathname: '/login'}}/>);
      }

      if (roles?.indexOf(currentUser.role) === -1) {
          return (<Navigate to={{pathname: '/401'}}/>);
      }

      // we provided routes and children of authguard
      return (children);
    };

    // then call authorization method
    return (authorize());
};
