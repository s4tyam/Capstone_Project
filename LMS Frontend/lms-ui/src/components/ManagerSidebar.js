import React from "react";
import { NavLink } from "react-router-dom";
import "./../style/sidebar.css";

const ManagerSidebar = () => {
  return (
    <div className="sidebar">
      <ul>
        <li>
          <NavLink to="/manager" end className={({ isActive }) => isActive ? "active-link" : ""}>
            My Profile
          </NavLink>
        </li>
        <li>
          <NavLink to="/manager/notifications" className={({ isActive }) => isActive ? "active-link" : ""}>
            Verify Leave
          </NavLink>
        </li>
        <li>
          <NavLink to="/manager/view-employee" className={({ isActive }) => isActive ? "active-link" : ""}>
            View Employees
          </NavLink>
        </li>
        <li>
          <NavLink to="/manager/holiday-list" className={({ isActive }) => isActive ? "active-link" : ""}>
            Holiday List
          </NavLink>
        </li>
      </ul>
    </div>
  );
};

export default ManagerSidebar;
