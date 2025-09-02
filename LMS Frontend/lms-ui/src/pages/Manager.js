import React from "react";
import { Routes, Route, Outlet } from "react-router-dom";
import ManagerSidebar from "../components/ManagerSidebar";
import GetEmployee from "../components/GetEmployee"; // Manager profile
import ManagerEmployees from "../components/ManagerEmployees";
import HolidayList from "../components/HolidayList";
import ManagerNotification from "../components/ManagerNotification";

const Manager = () => {
  return (
    <div className="page-container">
      <ManagerSidebar />
      <div className="content">
        <Routes>
          <Route index element={<GetEmployee />} />
          <Route path="notifications" element={<ManagerNotification />} />
          <Route path="view-employee" element={<ManagerEmployees />} />
          <Route path="holiday-list" element={<HolidayList />} />
          <Route path="verifyleave" element={<h2>Employee Leave History Page</h2>} />
        </Routes>
        <Outlet />
      </div>
    </div>
  );
};

export default Manager;
