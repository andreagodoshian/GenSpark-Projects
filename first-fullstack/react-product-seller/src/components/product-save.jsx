import { forwardRef, useEffect, useImperativeHandle, useState } from 'react';
import Product from '../models/product';
import ProductService from '../services/product.service';
import { Modal } from 'react-bootstrap';

// this is for the admin page
// need to create {Modal} from react-bootstrap
// (considered a component)

// the component itself is ProductSave

// treated as a child component, so we will
// call it from admin as a child
// (this is why we're using "forwardRef")
const ProductSave = forwardRef((props, ref) => {

    useImperativeHandle(ref, () => ({
        // ^^this is for interaction with parent

        // this function lets parent showP.M.
        showProductModal() {

            // setTimeout ensures the data loads
            setTimeout(() => {
                setShow(true);
            }, 0);
        }
    }));

    //////////////////////////////////////////
    // easy way to implement "edit"
    useEffect(() => {
        setProduct(props.product);
    }, [props.product]);
    //////////////////////////////////////////

    // now we can create variables
    // first, we have a product variable...
    const [product, setProduct] = useState(new Product('', '', 0));
    const [errorMessage, setErrorMessage] = useState('');
    const [submitted, setSubmitted] = useState(false);
    const [show, setShow] = useState(false);
    // ^^is the Modal being shown, or not???

    //////////////////
    // functions... //
    //////////////////

    // first: of course, saveProduct...
    const saveProduct = (e) => {
      e.preventDefault();

      setSubmitted(true);

      if (!product.name || !product.description || !product.price) {
          return;
      }

      // axios stuff - interacting with backend
      ProductService.saveProduct(product).then(response => {
          
        // a "react prop" is an object that listens...
        // sends to parent (parent has "onChildEvent")
        // THIS IS AT THE BOTTOM OF admin.page.jsx !!!!!!
          props.onSaved(response.data);
          setShow(false);
          setSubmitted(false);
      }).catch(err => {
          setErrorMessage('Unexpected error occurred.');
          console.log(err);
      });
    };

    // second function: handleChange
    // this is for variable binding
    // <input name="x" value="y">
    const handleChange = (e) => {
      const {name, value} = e.target;

      setProduct((prevState => {
          return {
              ...prevState,
              [name]: value
          };
      }));
    };

    //////////////////////////////////////////
    // functions are done! it's Modal time! //
    //////////////////////////////////////////

    // remember!! this modal is just for saving
    // onSubmit={(e) => saveProduct(e)}
    // there will be another modal for deleting

    return (
        <Modal show={show}>
            <form onSubmit={(e) => saveProduct(e)}
            noValidate
            className={submitted ? 'was-validated' : ''}>

                <div className="modal-header">
                    <h5 className="modal-title">Product Details</h5>
                    <button type="button" className="btn-close" onClick={() => setShow(false)}></button>
                </div>

                <div className="modal-body">

                    {errorMessage &&
                    <div className="alert alert-danger">
                        {errorMessage}
                    </div>
                    }

                    <div className="form-group">
                        <label htmlFor="name">Name: </label>
                        <input
                            type="text"
                            name="name"
                            placeholder="name"
                            className="form-control"
                            value={product.name}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Name is required.
                        </div>
                    </div>

                    <div className="form-group">
                        <label htmlFor="description">Description: </label>
                        <textarea
                            name="description"
                            placeholder="description"
                            className="form-control"
                            value={product.description}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Description is required.
                        </div>
                    </div>

                    <div className="form-group">
                        <label htmlFor="price">Price: </label>
                        <input
                            type="number"
                            min="1"
                            step="any"
                            name="price"
                            placeholder="price"
                            className="form-control"
                            value={product.price}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Price is required and should be greater than 0.
                        </div>
                    </div>


                </div>

                <div className="modal-footer">
                    <button type="button" className="btn btn-secondary" onClick={() => setShow(false)}>Close</button>
                    <button type="submit" className="btn btn-primary">Save Changes</button>
                </div>
            </form>
        </Modal>
    );

});

export {ProductSave};