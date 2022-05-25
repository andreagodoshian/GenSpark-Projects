import React from 'react';
import Typed from "react-typed";

const Header = () => {
  return (
    <div className='header-wrapper'>
        <div className='main-info'>
            <h1>Willkommen auf meiner Website!</h1>
            <Typed className='typed-text' 
            strings={["Software Development", "Web Design", "Data Science"]}
            typeSpeed={40}
            backSpeed={60}
            loop></Typed>
            <a href='#' className='btn-main-offer'>Contact</a>
        </div>
    </div>
  )
}

export default Header