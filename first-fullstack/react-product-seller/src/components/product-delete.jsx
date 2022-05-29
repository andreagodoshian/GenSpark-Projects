import { forwardRef, useImperativeHandle, useState } from 'react';
import { Modal } from 'react-bootstrap';

// this "delete Modal" is for confirming deletion

const ProductDelete = forwardRef((props, ref) => {
    // ^^since this is a child, using "forwardRef"

    const [show, setShow] = useState(false);
    // determines if visible

    useImperativeHandle(ref, () => ({
        //^^parent can access what's inside of here

        showDeleteModal() {
            setShow(true);
        }

    }));

    // this function is called once clicked
    // props allow us to send info to parent
    const deleteProduct = () => {
        props.onConfirmed();
        setShow(false);
    };

    //////////////////////////////////////////
    // functions are done! it's Modal time! //
    //////////////////////////////////////////

    // onClick={() => setShow(false)}>Cancel</button>
    // onClick={() => deleteProduct()}>I'm sure!</button>

    return (
        <Modal show={show}>

            <div className="modal-header">
                <h5 className="modal-title">Confirmation</h5>
                <button type="button" className="btn-close" onClick={() => setShow(false)}></button>
            </div>

            <div className="modal-body">
                Are you sure to delete the selected product?
            </div>

            <div className="modal-footer">
                <button type="button" className="btn btn-secondary" onClick={() => setShow(false)}>Cancel</button>
                <button type="button" className="btn btn-danger" onClick={() => deleteProduct()}>I'm sure!</button>
            </div>

        </Modal>
    );

});

export {ProductDelete};
