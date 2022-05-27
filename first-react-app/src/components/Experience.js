import React from 'react'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHockeyPuck } from "@fortawesome/free-solid-svg-icons";

const Experience = () => {
  return (
    <div id="experience" className='experience'>
        <div className='d-flex justify-content-center my-5'>
            <h1>Experience</h1>
        </div>
        <div className='container experience-wrapper'>

            <div className="timeline">
                    <h3><FontAwesomeIcon icon={faHockeyPuck}></FontAwesomeIcon> 2018</h3>
                    <p>Taught myself how to play Ice Hockey (goaltending is my passion)</p>
            </div>

            <div className="timeline">
                    <h3><FontAwesomeIcon icon={faHockeyPuck}></FontAwesomeIcon> 2019-2020</h3>
                    <p>Taught ESL and Music in Tbilisi, Georgia</p>
            </div>

            <div className="timeline">
                    <h3><FontAwesomeIcon icon={faHockeyPuck}></FontAwesomeIcon> 2020-2022</h3>
                    <p>Worked at pizzeria in Waterford, Michigan</p>
            </div>

            <div className="timeline">
                    <h3><FontAwesomeIcon icon={faHockeyPuck}></FontAwesomeIcon> 2021 (August)</h3>
                    <p>Saw an advertisement for SheCodes.io and began coding</p>
            </div>

            <div className="timeline">
                    <h3><FontAwesomeIcon icon={faHockeyPuck}></FontAwesomeIcon> 2021 (December)</h3>
                    <p>Earned Bachelor's from EMU - 3.5 GPA</p>
            </div>

            <div className="timeline">
                    <h3><FontAwesomeIcon icon={faHockeyPuck}></FontAwesomeIcon> 2022</h3>
                    <p>Started work at GenSpark, focusing on Java Development</p>
            </div>

        </div>
    </div>
  )
}

export default Experience