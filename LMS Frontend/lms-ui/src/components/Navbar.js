import React, { useContext } from "react";
import "./../style/navbar.css";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const { isAuthenticated, setIsAuthenticated } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    sessionStorage.removeItem("employee");
    setIsAuthenticated(false);
    navigate("/");
  };

  const handleLoginRedirect = () => {
    navigate("/");
  };

  return (
    <nav className="navbar">
      <div className="navbar-left">Leave Management System</div>
      <div className="navbar-right">
        {isAuthenticated ? (
          <button onClick={handleLogout} className="btn-logout">
            Logout
          </button>
        ) : (
          <button onClick={handleLoginRedirect} className="btn-login">
            Login
          </button>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
