import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';

import {NavBar} from './components/nav-bar';
import {HomePage} from './pages/home/home.page';
import {LoginPage} from './pages/login/login.page';
import {RegisterPage} from './pages/register/register.page';
import {ProfilePage} from './pages/profile/profile.page';
import {AdminPage} from './pages/admin/admin.page';
import {NotFoundPage} from './pages/not-found/not-found.page';
import {UnauthorizedPage} from './pages/unauthorized/unauthorized.page'

function App() {
  return (
    <BrowserRouter>
      <NavBar></NavBar>
      <div className='container'>
        <Routes>
          <Route path='/' element={<HomePage/>}></Route>
          <Route path='/home' element={<HomePage/>}></Route>
          <Route path='/login' element={<LoginPage/>}></Route>
          <Route path='/register' element={<RegisterPage/>}></Route>
          <Route path='/profile' element={<ProfilePage/>}></Route>
          <Route path='/admin' element={<AdminPage/>}></Route>
          <Route path='/404' element={<NotFoundPage/>}></Route>
          <Route path='/401' element={<UnauthorizedPage/>}></Route>
          <Route path='*' element={<NotFoundPage/>}></Route>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
