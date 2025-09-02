import React from "react";
import { NavLink } from "react-router-dom";
import "./../style/sidebar.css";

const EmployeeSidebar = () => {
  return (
    <div className="sidebar">
      <ul>
        <li>
          <NavLink to="/employee" end className={({ isActive }) => isActive ? "active-link" : ""}>
            My Profile
          </NavLink>
        </li>
        <li>
          <NavLink to="/employee/apply-leave" className={({ isActive }) => isActive ? "active-link" : ""}>
            Apply Leave
          </NavLink>
        </li>
        <li>
          <NavLink to="/employee/leave-history" className={({ isActive }) => isActive ? "active-link" : ""}>
            Leave History
          </NavLink>
        </li>
        <li>
          <NavLink to="/employee/holiday-list" className={({ isActive }) => isActive ? "active-link" : ""}>
            Holiday List
          </NavLink>
        </li>
      </ul>
    </div>
  );
};

export default EmployeeSidebar;
