import React from 'react'
import {VKShareButton, VKIcon, TumblrShareButton, TumblrIcon, MailruShareButton, MailruIcon, TelegramShareButton, TelegramIcon} from 'react-share';

const Footer = () => {
  return (
    <div className='footer'>
        <div className='container'>
            <div className='row'>

                <div className='col-lg-4 col-md-6 col-sm-6'>
                    <div className='d-flex'>
                        <p>Location: Pontiac, MI, USA</p>
                    </div>

                    <div className='d-flex'>
                        <p><a href='https://github.com/godoshian' target='_blank'>Link to GitHub</a></p>
                    </div>

                    <div className='d-flex'>
                        <p>Mantra: "All hope abandon, ye who enter here."</p>
                    </div>
                </div>

                <div className='col-lg-5 col-md-5 col-sm-6 align-items-center'>
                    <div className='d-flex justify-content-center'>
                        <VKShareButton
                        url='https://github.com/godoshian'
                        quote="What's Andrea Godoshian doing??"
                        hashtag="#WomenWhoCode">
                            <VKIcon className='mx-3' size={36}></VKIcon>
                        </VKShareButton>

                        <TumblrShareButton
                        url='https://github.com/godoshian'
                        quote="What's Andrea Godoshian doing??"
                        hashtag="#WomenWhoCode">
                            <TumblrIcon className='mx-3' size={36}/>
                        </TumblrShareButton>

                        <MailruShareButton
                        url='https://github.com/godoshian'
                        quote="What's Andrea Godoshian doing??"
                        hashtag="#WomenWhoCode">
                            <MailruIcon className='mx-3' size={36}/>
                        </MailruShareButton>

                        <TelegramShareButton
                        url='https://github.com/godoshian'
                        quote="What's Andrea Godoshian doing??"
                        hashtag="#WomenWhoCode">
                            <TelegramIcon className='mx-3' size={36}/>
                        </TelegramShareButton>
                    </div>
                    <p className='pt-3 text-center'>Website designed by Андрия Годошьян</p>
                </div>

            </div>
        </div>
    </div>
  )
}

export default Footer