// hi guys :) in this lesson :)
// this is where we conntect with backend
// axios helps us create the connection

import axios from "axios";
import { BASE_API_URL } from "../common/constant";

// of course, we need the server url :P
const BASE_URL = BASE_API_URL + '/api/authentication';
// see "AuthenticationController" in Spring Boot

class AuthenticationService {

    login(user) {
        return axios.post(BASE_URL + '/sign-in', user)
    }

    register(user) {
        return axios.post(BASE_URL + '/sign-up', user)
    }

}

export default new AuthenticationService();