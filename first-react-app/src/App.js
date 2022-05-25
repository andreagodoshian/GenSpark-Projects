import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from './components/Navbar';
import Header from './components/Header';
import AboutMe from './components/AboutMe';

function App() {
  return (
    <>
      <Navbar></Navbar>
      <Header></Header>
      <AboutMe></AboutMe>
    </>
  );
}

export default App;