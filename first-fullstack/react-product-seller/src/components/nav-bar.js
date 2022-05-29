import logo from '../logo.svg';
import { NavLink, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { clearCurrentUser } from '../store/actions/user';
import { Role } from '../models/role';


const NavBar = () => {

    // we need a currentUser object, so we can display
    const currentUser = useSelector(state => state.user);

    // this is from react-redux
    const dispatch = useDispatch();
    // this is react-router-dom
    const navigate = useNavigate();

    // react-redux "useDispatch"
    const logout = () => {
        dispatch(clearCurrentUser());
        navigate('/login');
    };

    // dashboard is different, for ADMIN && USER
    // since log-out is function, need "onClick"
    return (
        <nav className="navbar navbar-expand navbar-dark bg-dark">
            <a href="https://reactjs.org" className="navbar-brand ms-1">
                <img src={logo} className="App-logo" alt="logo" />
                React
            </a>

            <div className="navbar-nav me-auto">
                {currentUser?.role === Role.ADMIN &&
                <li className="nav-item">
                    <NavLink to="/admin" className="nav-link">
                        Admin
                    </NavLink>
                </li>
                }

                <li className="nav-item">
                    <NavLink to="/home" className="nav-link">
                        Home
                    </NavLink>
                </li>
            </div>

            {!currentUser &&
            <div className="navbar-nav ms-auto">
                <li className="nav-item">
                    <NavLink to="/register" className="nav-link">
                        Sign Up
                    </NavLink>
                </li>
                <li className="nav-item">
                    <NavLink to="/login" className="nav-link">
                        Sign In
                    </NavLink>
                </li>
            </div>
            }

            {currentUser &&
            <div className="navbar-nav ms-auto">
                <li className="nav-item">
                    <NavLink to="/profile" className="nav-link">
                        {currentUser.name}
                    </NavLink>
                </li>
                <li className="nav-item">
                    <a href="#" className="nav-link" onClick={() => logout()}>
                        Sign Out
                    </a>
                </li>
            </div>
            }

        </nav>
    );
};

export {NavBar};