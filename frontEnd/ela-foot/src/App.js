import { Routes } from 'react-router-dom';
// import './App.css';
import { BrowserRouter as Router, Route } from "react-router-dom";
import Home from '../src/pages/home'
import SignIn from '../src/pages/signIn'


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<SignIn />} />
        <Route path="/signin" element={<SignIn />} />
        <Route path="/home" element={<Home />} />
      </Routes>
    </Router>
);
}

export default App;
