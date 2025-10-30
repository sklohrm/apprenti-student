import React, { useEffect, useState } from "react";
import Swal from "sweetalert2";

import Header from "./Header";
import Table from "./Table";
import Add from "./Add";
import Edit from "./Edit";

import { employeesData } from "../../data/";

const Dashboard = ({ setIsAuthenticated }) => {

    const [employees, setEmployees] = useState(employeesData);
    const [selectedEmployee, setSelectedEmployee] = useState(null);
    const [isAdding, setIsAdding] = useState(false);
    const [isEditing, setIsEditing] = useState(false);

    useEffect(() => {
        const data = JSON.parse(localStorage.getItem("employees_data"));
        if (data !== null && Object.keys(data).length !== 0) {
            setEmployees(data);
        }
    }, []);

    const handleEdit = id => {
        const [employee] = employees.filter(employee => employee.id);
        setSelectedEmployee(employee);
        setIsEditing(true);
    };

    const handleDelete = id => {
        Swal.fire({
            icone: "warning",
            title: "Are you sure?",
            text: "This employee wil be permanently deleted.",
            showCancelButton: true,
            confirmButtonText: "DO IT",
            cancelButtonText: "I am afraid not."
        }).then(result => {
            if (result.value) {
                const [employee] = employees.filter(employee => employee.id === id)
                Swal.fire({
                    icon: "success",
                    title: "Deleted",
                    text: `${employee.firstName} ${employee.lastName}'s data has been deleted.`,
                    showConfirmButton: false,
                    time: 1500
                });
                const employeesCopy = employees.filter(employee => employee.id !== id);
                localStorage.setItem('employees_data', JSON.stringify(employeesCopy));
                setEmployees(employeesCopy);
            }
        });
    };

    return (
        <div className="container">
            {!isAdding && !isEditing && (
                <>
                    <Header
                        setIsAdding={setIsAdding}
                        setIsAuthenticated={setIsAuthenticated}
                    />
                    <Table employees={employees} handleEdit={handleEdit} handleDelete={handleDelete} />
                </>
            )}
            {isAdding && (
                <Add
                    employees={employees}
                    setEmployees={setEmployees}
                    setIsAdding={setIsAdding}
                />
            )}
            {isEditing && (
                <Edit
                    employees={employees}
                    selectedEmployee={selectedEmployee}
                    setEmployees={setEmployees}
                    setIsEditing={setIsEditing}
                />
            )}
        </div>
    );
};

export default Dashboard;