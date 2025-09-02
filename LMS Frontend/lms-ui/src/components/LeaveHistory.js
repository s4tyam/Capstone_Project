import React, { useEffect, useState } from "react";
import "../style/leavehistory.css";
import {
  viewLeaveHistoryOfEmployee,
  cancelLeave,
  withdrawLeave,
} from "../services/ApiServices";
import toast from "react-hot-toast";
import { useNavigate } from "react-router-dom";

const LeaveHistory = () => {
  const [leaveData, setLeaveData] = useState([]);
  const today = new Date();
  const navigate = useNavigate();

  useEffect(() => {
    fetchLeaveHistory();
  }, []);

  const fetchLeaveHistory = async () => {
    const storedEmployee = sessionStorage.getItem("employee");
    if (!storedEmployee) {
      toast.error("Session Expired, Login Again");
      navigate("/")
      return;
    }

    const { empId } = JSON.parse(storedEmployee);

    try {
      const { data } = await viewLeaveHistoryOfEmployee(empId);
      setLeaveData(data);
    } catch (error) {
      console.error(error);
      toast.error("Failed to fetch leave history");
    }
  };

  const handleCancel = async (id) => {
    try {
      await cancelLeave(id);
      toast.success(`Leave cancelled successfully!`);
      fetchLeaveHistory();
    } catch (error) {
      console.error(error);
      toast.error(`Failed to cancel Leave ID`);
    }
  };

  const handleWithdraw = async (id) => {
    try {
      await withdrawLeave(id);
      toast.success(`Leave withdrawn successfully!`);
      fetchLeaveHistory();
    } catch (error) {
      console.error(error);
      toast.error(`Failed to withdraw Leave`);
    }
  };

  return (
    <div className="leave-history">
      <h2>Leave History</h2>
      <table className="leave-table">
        <thead>
          <tr>
            <th>From Date</th>
            <th>To Date</th>
            <th>Leave Type</th>
            <th>Status</th>
            <th>Total Days</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {leaveData.map((leave) => {
            const leaveStart = new Date(leave.fromDate);
            const isFuture = leaveStart > today;

            return (
              <tr key={leave.id}>
                <td>{leave.fromDate}</td>
                <td>{leave.toDate}</td>
                <td>{leave.leaveType}</td>
                <td>{leave.leaveStatus}</td>
                <td>{leave.numberOfDays}</td>
                <td>
                  {isFuture && leave.leaveStatus === "APPROVED" && (
                    <button
                      className="action-btn cancel-btn"
                      onClick={() => handleCancel(leave.id)}
                    >
                      Cancel
                    </button>
                  )}
                  {isFuture && leave.leaveStatus === "APPLIED" && (
                    <button
                      className="action-btn withdraw-btn"
                      onClick={() => handleWithdraw(leave.id)}
                    >
                      Withdraw
                    </button>
                  )}
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default LeaveHistory;
