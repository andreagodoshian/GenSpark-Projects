import { useEffect, useRef, useState } from 'react';

// need to import product service
import ProductService from '../../services/product.service';
import { ProductSave } from '../../components/product-save';
import Product from '../../models/product';
import { ProductDelete } from '../../components/product-delete';


const AdminPage = () => {

    // since the admin manages the products,
    // the productList should be defined/constant
    const [productList, setProductList] = useState([]);
    
    // this is for editing a product
    // see "createProductRequest" && "editProductRequest"
    const [selectedProduct, setSelectedProduct] = useState(new Product('', '', 0));
    
    // basic error message constant
    const [errorMessage, setErrorMessage] = useState('');

    // to access the child components (the Modals)
    // we need "useRef()"
    const saveComponent = useRef();
    const deleteComponent = useRef();

    // mounted method (callback method)
    // invoked only once
    useEffect(() => {
        // funcion defined in product.service
        ProductService.getAllProducts().then((response) => {
            setProductList(response.data);
        });
    }, []);

    //////////////////////////////////

    // this is for the child/Modal
    const createProductRequest = () => {
        setSelectedProduct(new Product('', '', 0));
        //^^this is for editing
        // if not editing, could remove
        // but of course, we're editing LOL

        saveComponent.current?.showProductModal();
    };

    // this is for the child/Modal
    const editProductRequest = (item) => {
      setSelectedProduct(Object.assign({}, item));
        saveComponent.current?.showProductModal();
    };

    // this is for the child/Modal
    const deleteProductRequest = (product) => {
        setSelectedProduct(product);
        deleteComponent.current?.showDeleteModal();
    };

    //////////////////////////////////

    // also for interacting with child (Modal)
    // SEE BOTTOM
    const saveProductWatcher = (product) => {
        let itemIndex = productList.findIndex(item => item.id === product.id);

        // this block checks if its POST or PUT
        if (itemIndex !== -1) {
            const newList = productList.map((item) => {
                if (item.id === product.id) {
                    return product;
                }
                return item;
            });
            setProductList(newList);
        } else {
            const newList = productList.concat(product);
            setProductList(newList);
        }
    };

    // also for interacting with child (Modal)
    // SEE BOTTOM
    const deleteProduct = () => {
      ProductService.deleteProduct(selectedProduct).then(_ => {
          setProductList(productList.filter(x => x.id !== selectedProduct.id));
      }).catch(err => {
          setErrorMessage('Unexpected error occurred.');
          console.log(err);
      });
    };

    //////////////////////////////////////////
    // functions are done! it's HTML time!! //
    //////////////////////////////////////////

    // productList.map
    // remember: incorporate Modal from "components"
    // (product-save.jsx && product.delete.jsx)

    // onClick={() => createProductRequest()}
    // onClick={() => editProductRequest(item)
    // onClick={() => deleteProductRequest(item)
    return (
        <div>
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
                                    <h3>All Products</h3>
                                </div>

                                <div className="col-6 text-end">
                                    <button className="btn btn-primary" onClick={() => createProductRequest()}>
                                        Create Product
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
                                    <th scope="col">Action</th>
                                </tr>
                                </thead>
                                <tbody>

                                {productList.map((item, ind) =>
                                    <tr key={item.id}>
                                        <th scope="row">{ind + 1}</th>
                                        <td>{item.name}</td>
                                        <td>{`$ ${item.price}`}</td>
                                        <td>{new Date(item.createTime).toLocaleDateString()}</td>
                                        <td>
                                            <button className="btn btn-primary me-1" onClick={() => editProductRequest(item)}>
                                                Edit
                                            </button>
                                            <button className="btn btn-danger" onClick={() => deleteProductRequest(item)}>
                                                Delete
                                            </button>
                                        </td>
                                    </tr>
                                )}


                                </tbody>

                            </table>
                        </div>
                    </div>

                </div>
            </div>

            <ProductSave ref={saveComponent} product={selectedProduct} onSaved={(p) => saveProductWatcher(p)}/>
            <ProductDelete ref={deleteComponent} onConfirmed={() => deleteProduct()}/>

        </div>
    );
};

export {AdminPage};
