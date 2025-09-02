import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Toaster } from "react-hot-toast";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Employee from "./pages/Employee";
import Manager from "./pages/Manager";
import { AuthProvider } from "./context/AuthContext";

function App() {
  return (
    <AuthProvider>
      <Router>
        <Toaster />
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />

          <Route path="/employee/*" element={<Employee />} />

          <Route path="/manager/*" element={<Manager />} />
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;
