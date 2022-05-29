import { useEffect, useState } from 'react';
import User from '../../models/user';
import { useSelector } from 'react-redux';
import { Link, useNavigate } from 'react-router-dom';
import AuthenticationService from '../../services/authentication.service';
import './register.page.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUserCircle } from '@fortawesome/free-solid-svg-icons';


const RegisterPage = () => {

    // in React, we can create variables with state (useState)
    const [user, setUser] = useState(new User('', '', ''));
    // we need a loading variable, to show when busy
    const [loading, setLoading] = useState(false);
    // we need a submitted variable, to see if submitted
    const [submitted, setSubmitted] = useState(false);
    // we will use it, in case there is an error
    const [errorMessage, setErrorMessage] = useState('');

    // redux stuff :( to access current user
    const currentUser = useSelector(state => state.user);
    // see store.index.js (user: userReducer)
    // ...then we can call the current user from the mounted hook

    // for the router, we can use the "useNavigate" hook
    const navigate = useNavigate;

    // mounted method (functional component - useEffect hook)
    // mounted method is a callback method that is invoked once,
    // when the directive is instantiated (sorry my explanation sucks)
    useEffect(() => {
        if (currentUser?.id) {
            // if the current user is available, 
            // or the current id is available... THEN navigate
            navigate('/profile');
        }
    }, []);

    //////////////////////////////////////
    // now, we can create our functions //
    //////////////////////////////////////

    // first function: variable binding, after html form events
    // in react, there is one-way data flow
    // (variable/state can only change from one side)
    // from html -> we need to assign them to the state


    //<input name="x" value="y" onChange=(event) => handleChange(event)>
    const handleChange = (e) => {
      // we are getting the target element/key && it's value
        const {name, value} = e.target;

      // then, update user in the state
      setUser((prevState => {
          //e.g: prevState ({user: x, pass: x}) + newKeyValue ({user: xy}) => ({user: xy, pass: x})
          return {
              ...prevState,
              [name]: value
          };
      }));
    };

    // second function: call UserService and handle the response
    // we will send the user object as a parameter

    const handleRegister = (e) => {

        // prevent the default refresh
        e.preventDefault();

        // even though not accepted, change state to submitted
      setSubmitted(true);

      // first, make sure the form isn't empty
      if (!user.username || !user.password || !user.name) {
          return;
      }

      // then, if the form isn't empty, show loading bar
      setLoading(true);

        // THEN, FINALLY, call register from AuthenticationService
        // pass a user object && listen with ".then" state
        // since we're using axios, there are "promises"
        // which means success or error
      AuthenticationService.register(user).then(_ => {
          navigate('/login');
      }).catch(error => {
         console.log(error);
         if (error?.response?.status === 409) {
             setErrorMessage('Invalid or already exists.');
         } else {
            navigate('/login');
         }
         // FINALLY, if this far, then set loading to false
         setLoading(false);
      });
    };

    // ms = "margin start";
    // me = "margin end";
    // mt = "margin top";

    // notes about the form...
    // how do we pass from form (html) to component (react) 
    // (then to backend) ??
    // handle with "onChange" event (sorry my explanation sucks)

    // noValidate stops html validation
    // we are validating with bootstrap ("className")
    return (
        <div className="container mt-5">
            <div className="card ms-auto me-auto p-3 shadow-lg custom-card">

                <FontAwesomeIcon icon={faUserCircle} className="ms-auto me-auto user-icon"/>

                {errorMessage &&
                <div className="alert alert-danger">
                    {errorMessage}
                </div>
                }

                <form
                    onSubmit={(e) => handleRegister(e)}
                    noValidate
                    className={submitted ? 'was-validated' : ''}
                >

                    <div className="form-group">
                        <label htmlFor="name">Full Name:</label>
                        <input
                            type="text"
                            name="name"
                            className="form-control"
                            placeholder="name"
                            value={user.name}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Full name is required.
                        </div>
                    </div>

                    <div className="form-group">
                        <label htmlFor="username">Username:</label>
                        <input
                            type="text"
                            name="username"
                            className="form-control"
                            placeholder="username"
                            value={user.username}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Username is required.
                        </div>
                    </div>

                    <div className="form-group">
                        <label htmlFor="password">Password:</label>
                        <input
                            type="password"
                            name="password"
                            className="form-control"
                            placeholder="password"
                            value={user.password}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Password is required.
                        </div>
                    </div>

                    <button className="btn btn-info w-100 mt-3" disabled={loading}>
                        Sign Up
                    </button>

                </form>

                <Link to="/login" className="btn btn-link" style={{color: 'darkgray'}}>
                    I have an Account!
                </Link>

            </div>
        </div>
    );
};

export {RegisterPage};
