import React, {useRef} from 'react';
import emailjs from '@emailjs/browser';

const Contact = () => {

    const form = useRef();

    const serviceID = "service_ID";
    const templateID = "template_ID";
    const publicKey = "UJbCWKgnQpWMiqHFj";

    const sendEmail = (e) => {
        e.preventDefault();
    
        emailjs.sendForm(serviceID, templateID, form.current, publicKey)
          .then((result) => {
              console.log(result.text);
          }, (error) => {
              console.log(error.text);
          });
          e.target.reset();
          alert("Thank you! Your message was sent.");
      };


  return (
    <div id="contact" className='contact'>

        <div className='text-center'>
            <h1>Contact Me</h1>
            <p>If you fill out the form and describe your project needs, I'll contact you as soon as possible.</p>
        </div>

        <div className='container'>
            <form ref={form} onSubmit={sendEmail}>
                <div className='row'>

                    <div className='col-md-6 col-xs-12'>
                        <input id='name'
                        type ="text"
                        className='form-control'
                        placeholder='Name'
                        name="name"
                        required/>

                        <input id='phone'
                        type="text"
                        className='form-control'
                        placeholder='Phone number'
                        name="phone"
                        required/>

                        <input id='email'
                        type="email"
                        className='form-control'
                        placeholder='E-mail'
                        name="email"
                        required/>

                        <input id='subject'
                        type="text"
                        className='form-control'
                        placeholder='Subject'
                        name="subject"
                        required/>
                    </div>
            
                    <div className='col-md-6 col-xs-12'>
                        <textarea id='description'
                        type='text'
                        className='form-control'
                        placeholder='Your message goes here'
                        name='description'
                        required></textarea>
                        <button className='btn-main-offer contact-btn'
                        type='submit'>Send</button>
                    </div>

                </div>
            </form>
        </div>


    </div>
  )
}

export default Contact