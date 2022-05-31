// pages
import Home from './pages/Home';
import Login from './pages/Login';

// styled containers
import {StyledContainer} from './components/Styles';

// how are you gonna route?? DUH!!!!!
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

function App() {
  return (
    <Router>
      <StyledContainer>
        {/* <Home></Home> */}
        <Login></Login>
      </StyledContainer>
    </Router>
  );
}

export default App;
