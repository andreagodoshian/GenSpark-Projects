import React from 'react'

const Contact = () => {
  return (
    <div className='contact'>

        <div className='text-center'>
            <h1>Contact Me</h1>
            <p>If you fill out the form and describe your project needs, I'll contact you as soon as possible.</p>
        </div>

        <div className='container'>
            <div className='row'>

                <div className='col-md-6 col-xs-12'>
                    <input id='name'
                    type ="text"
                    className='form-control'
                    placeholder='Name'
                    name="name"/>
                    <input id='phone'
                    type="text"
                    className='form-control'
                    placeholder='Phone number'
                    phone="phone"/>
                    <input id='email'
                    type="email"
                    className='form-control'
                    placeholder='E-mail'
                    email="email"/>
                    <input id='subject'
                    type="text"
                    className='form-control'
                    placeholder='Subject'
                    subject="subject"/>
                </div>
            
                <div className='col-md-6 col-xs-12'>
                    <textarea id='description'
                    type='text'
                    className='form-control'
                    placeholder='Your message goes here'
                    description='description'
                    ></textarea>
                    <button className='btn-main-offer contact-btn'
                    type='submit'>Send</button>
                </div>

            </div>
        </div>


    </div>
  )
}

export default Contact