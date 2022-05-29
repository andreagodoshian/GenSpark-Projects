import { BASE_API_URL } from '../common/constants';
import axios from 'axios';
import { authHeader } from './base.service';

// desrcibe the backend endpoints
const API_URL = BASE_API_URL + '/api/user';

class UserService {

    // with axios, we will send a put request
    changeRole(role) {
        return axios.put(API_URL + '/change/' + role, {}, {headers: authHeader()});
    }
}

export default new UserService();


// this is for changing the role!!!!!!!!!!!!!!!

// make sure to add the authheader
// because JWT token implemented in backend!!!!!