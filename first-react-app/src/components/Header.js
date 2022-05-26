import React from 'react';
import Typed from "react-typed";

const Header = () => {
  return (
    <div className='header-wrapper'>
        <div className='main-info'>
            <h1>Андрия Годошьян - Developer For Hire</h1>
            <Typed className='typed-text' 
            strings={["Willkommen auf meiner Website!", "Добро пожаловать на мой сайт!", "Welcome to my website!"]}
            typeSpeed={40}
            backSpeed={60}
            loop></Typed>
            <a href='#' className='btn-main-offer'>Contact</a>
        </div>
    </div>
  )
}

export default Header