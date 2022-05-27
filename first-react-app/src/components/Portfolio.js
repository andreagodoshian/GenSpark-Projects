import React from 'react';

import genspark from '../../src/genspark.png';
import fcc from '../../src/freecodecamp-cute.png';
import python from '../../src/python_ml.png';
import book from '../../src/book.jpg';

const Portfolio = () => {
  return (
    <div id="portfolio" className='portfolio'>
        <h1 className='py-5'>Portfolio</h1>
            <div className='container'>
                <div className='row'>

                <div className='col-md-3 col-sm-6'>
                    <div className='box'>
                        <img className='portfolio-image' src={genspark} alt="genspark logo"></img>
                        <h5><a href='https://github.com/godoshian/GenSpark-Projects' target="_blank">GenSpark Repository</a></h5>
                            <p>Functional Java, Spring Boot, MySQL, React, etc.</p>
                    </div>
                </div>

                <div className='col-md-3 col-sm-6'>
                    <div className='box'>
                        <img className='portfolio-image' src={fcc} alt="genspark logo"></img>
                        <h5><a href='https://github.com/godoshian/basic-html-css' target="_blank">Design Repository</a></h5>
                            <p>Certified by freeCodeCamp, for basic HTML and CSS.</p>
                    </div>
                </div>

                <div className='col-md-3 col-sm-6'>
                    <div className='box'>
                        <img className='portfolio-image' src={python} alt="genspark logo"></img>
                        <h5><a href='https://github.com/godoshian/AI_ML' target="_blank">Python Repository</a></h5>
                            <p>Data Science projects (pandas, matplotlib, tensorflow, etc).</p>
                    </div>
                </div>

                <div className='col-md-3 col-sm-6'>
                    <div className='box'>
                        <img className='portfolio-image' src={book} alt="genspark logo"></img>
                        <h5><a href='https://andreasbook.tumblr.com' target="_blank">My Book!</a></h5>
                            <p>I wrote a book lol. Sorry.</p>
                    </div>
                </div>
            
            </div>
        </div>
    </div>
  )
}

export default Portfolio