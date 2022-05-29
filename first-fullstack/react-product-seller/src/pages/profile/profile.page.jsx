import { useEffect, useState } from 'react';
import PurchaseService from '../../services/purchase.service';
import { useDispatch, useSelector } from 'react-redux';
import { Role } from '../../models/role';
import UserService from '../../services/user.service';
import { clearCurrentUser } from '../../store/actions/user';
import { useNavigate } from 'react-router-dom';


const ProfilePage = () => {

    // create a constant array, since we want to
    // display all of the purchases on the profile page
    const [purchaseList, setPurchaseList] = useState([]);

    // of course, declare const for error message
    const [errorMessage, setErrorMessage] = useState('');

    // grab the user
    const currentUser = useSelector(state => state.user);
    
    const dispatch = useDispatch();
    const navigate = useNavigate();

    // mounted method (useEffect because functional)
    useEffect(() => {
        PurchaseService.getAllPurchaseItems().then((response) => {
            setPurchaseList(response.data);
        });
    }, []);

    // this is just an easy toggle for demo
    const changeRole = () => {

        const newRole = currentUser.role === Role.ADMIN ? Role.USER : Role.ADMIN;

        UserService.changeRole(newRole).then(() => {
           // because of JWT token,
           // user has to log-out (clear session)
            dispatch(clearCurrentUser());
            navigate('/login');
        }).catch((err) => {
            setErrorMessage('Unexpected error occurred.');
            console.log(err);
        });
    };

    //////////////////////////////////////////
    // functions are done! it's HTML time!! //
    //////////////////////////////////////////

    // purchaseList.map((item, ind)

    return (
        <div className="container">
            <div className="pt-5">

                {errorMessage &&
                <div className="alert alert-danger">
                    {errorMessage}
                </div>
                }

                <div className="card">
                    <div className="card-header">

                        <div className="row">
                            <div className="col-6">
                                <h3>All Purchased Items</h3>
                            </div>
                            <div className="col-6 text-end">
                                Current role is <strong>{currentUser?.role} </strong>
                                <button className="btn btn-primary" onClick={() => changeRole()}>
                                    Change Role
                                </button>
                            </div>
                        </div>

                    </div>
                    <div className="card-body">
                        <table className="table table-striped">

                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Name</th>
                                <th scope="col">Price</th>
                                <th scope="col">Date</th>
                            </tr>
                            </thead>
                            <tbody>

                            {purchaseList.map((item, ind) =>

                                <tr key={ind}>
                                    <th scope="row">{ind + 1}</th>
                                    <td>{item.name}</td>
                                    <td>{`$ ${item.price}`}</td>
                                    <td>{new Date(item.purchaseTime).toLocaleDateString()}</td>
                                </tr>

                            )}

                            </tbody>

                        </table>
                    </div>
                </div>

            </div>
        </div>
    );
};

export {ProfilePage};
