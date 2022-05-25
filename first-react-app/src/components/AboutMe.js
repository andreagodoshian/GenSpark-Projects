import React from 'react'
import img from '../../src/self-2022.jpg'

const AboutMe = () => {
  return (
    <div className='container py-5'>
        <div className='row'>
            <div className='col-lg-6 col-xm-12'>
                <div className='photo-wrap mb-5'>
                    <img className='profile-img' src={img} alt="author"></img>
                </div>
            </div>
            <div className='col-lg-6 col-xm-12'>
                <h1 className='about-heading'>About</h1>
                <p>Hello! My name is Andrea Godoshian. Since English isn't always phonetic,
                    my name is pronounced Андрия Годошьян. I'm a Junior Software Developer.
                    I work primarily with Java, React.js, Python.

                    I got my Bachelor's Degree from Eastern Michigan University in December 2021. Overall,
                    I ended with a 3.5 GPA. Although my major was Percussion Performance, I saw an advertisement for
                    SheCodes and fell in love with coding.

                    As a self-proclaimed "life-long learner," I have strong time management skills, which ensure that I
                    am constantly learning and meeting all of my deadlines. Additionally,
                    I am a highly self-motivated individual, dedicated to exceeding customer expectations.
                    Not to mention, I am an excellent team player, who also thrives when working with limited supervision. 
                    
                    Seeking mutually beneficial opportunities!
                </p>
            </div>
        </div>
    </div>
  )
}

export default AboutMe