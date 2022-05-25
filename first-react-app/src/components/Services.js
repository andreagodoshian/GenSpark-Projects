import React from 'react'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faComputer, faCompassDrafting, faDatabase, faPersonChalkboard } from "@fortawesome/free-solid-svg-icons";

const Services = () => {
  return (
    <div className='services'>
        <h1 className='py-5'>Services</h1>
            <div className='container'>
                <div className='row'>

                    <div className='col-md-3 col-sm-6'>
                        <div className='box'>
                            <div className='circle'>
                                <FontAwesomeIcon className="icon" icon={faComputer} size="2x"></FontAwesomeIcon>
                            </div>
                            <h5>Software Development</h5>
                            <p>I approach each project inidivually and always focus on the result.</p>
                        </div>
                    </div>

                    <div className='col-md-3 col-sm-6'>
                        <div className='box'>
                            <div className='circle'>
                                <FontAwesomeIcon className="icon" icon={faCompassDrafting} size="2x"></FontAwesomeIcon>
                            </div>
                            <h5>Web Design</h5>
                            <p>I create websites that are both responsive and beautiful.</p>
                        </div>
                    </div>

                    <div className='col-md-3 col-sm-6'>
                        <div className='box'>
                            <div className='circle'>
                                <FontAwesomeIcon className="icon" icon={faDatabase} size="2x"></FontAwesomeIcon>
                            </div>
                            <h5>Data Science</h5>
                            <p>With great attention to detail, I can help you analyze your data.</p>
                        </div>
                    </div>

                    <div className='col-md-3 col-sm-6'>
                        <div className='box'>
                            <div className='circle'>
                                <FontAwesomeIcon className="icon" icon={faPersonChalkboard} size="2x"></FontAwesomeIcon>
                            </div>
                            <h5>Other</h5>
                            <p>I also have experience teaching Music and ESL; please ask, if interested!</p>
                        </div>
                    </div>

                </div>
            </div>
        </div>
  )
}

export default Services