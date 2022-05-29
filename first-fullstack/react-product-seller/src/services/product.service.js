import { BASE_API_URL } from '../common/constants';
import axios from 'axios';
import { authHeader } from './base.service';

// define the server/endpoints from backend 
const API_URL = BASE_API_URL + '/api/product';

class ProductService {

    // with axios, we send post request (matches backend)
    // add header to options block (JWT)
    saveProduct(product) {
        return axios.post(API_URL, product, {headers: authHeader()});
    }

    // similar to notes above
    deleteProduct(product) {
        return axios.delete(API_URL + '/' + product.id, {headers: authHeader()});
    }

    // we dont need to send header, because public
    getAllProducts() {
        return axios.get(API_URL);
    }
}

export default new ProductService();
