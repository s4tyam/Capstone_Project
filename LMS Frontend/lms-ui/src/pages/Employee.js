import React from "react";
import { Routes, Route, Outlet } from "react-router-dom";
import EmployeeSidebar from "../components/EmployeeSidebar";
import GetEmployee from "../components/GetEmployee";
import ApplyLeave from "../components/ApplyLeave";
import LeaveHistory from "../components/LeaveHistory";
import HolidayList from "../components/HolidayList";

const Employee = () => {
  return (
    <div className="page-container">
      <EmployeeSidebar />
      <div className="content">
        <Routes>
          <Route index element={<GetEmployee />} />
          <Route path="apply-leave" element={<ApplyLeave />} />
          <Route path="leave-history" element={<LeaveHistory />} />
          <Route path="holiday-list" element={<HolidayList />} />
        </Routes>
        <Outlet />
      </div>
    </div>
  );
};

export default Employee;
