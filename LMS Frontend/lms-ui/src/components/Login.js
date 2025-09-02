import React, { useContext, useState } from "react";
import "./../style/login.css";
import { employeeLogin } from "../services/ApiServices";
import toast from "react-hot-toast";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [form, setForm] = useState({ empId: "", password: "" });
  const { setIsAuthenticated } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const { data } = await employeeLogin(form);
      sessionStorage.setItem("employee", JSON.stringify(data));
      setIsAuthenticated(true);
      
      toast.success("Login successful");

      if (data.job.toLowerCase() === "manager") {
        navigate("/manager");
      } else {
        navigate("/employee");
      }
    } catch (error) {
      console.error(error);
      toast.error("Invalid Employee ID or Password");
    }
  };

  return (
    <div className="home-container">
      <div className="login-card">
        <h2>Login</h2>
        <form onSubmit={handleLogin}>
          <input
            type="text"
            name="empId"
            placeholder="Employee Id"
            value={form.empId}
            onChange={handleChange}
            required
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={form.password}
            onChange={handleChange}
            required
          />
          <button type="submit">Login</button>
        </form>
      </div>
    </div>
  );
};

export default Login;
