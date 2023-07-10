const express = require('express');
const mysql = require('mysql');

const app = express();
app.use(express.json());

// MySQL database configuration
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'niranjan@19',
    database: 'SDM'
});

// Connect to MySQL database
connection.connect(err => {
    if (err) {
        console.error('Error connecting to MySQL database:', err);
    } else {
        console.log('Connected to MySQL database');
    }
});

// GET - Display All employees using e_name
app.get('/employees', (req, res) => {
    const query = 'SELECT * FROM Employee_Tb ORDER BY e_name';
    connection.query(query, (error, results) => {
        if (error) {
            console.error('Error retrieving employees:', error);
            res.status(500).json({ error: 'Failed to retrieve employees' });
        } else {
            res.json(results);
        }
    });
});

// POST - ADD Employee data into MySQL table
app.post('/employees', (req, res) => {
    const { e_name, email, password, emp_id, dname, doj } = req.body;
    const query = 'INSERT INTO Employee_Tb (e_name, email, password, emp_id, dname, doj) VALUES (?, ?, ?, ?, ?, ?)';
    connection.query(query, [e_name, email, password, emp_id, dname, doj], (error, result) => {
        if (error) {
            console.error('Error adding employee:', error);
            res.status(500).json({ error: 'Failed to add employee' });
        } else {
            res.json({ message: 'Employee added successfully' });
        }
    });
});

// DELETE - Delete Employee from table by doj
app.delete('/employees/:doj', (req, res) => {
    const doj = req.params.doj;
    const query = 'DELETE FROM Employee_Tb WHERE doj = ?';
    connection.query(query, [doj], (error, result) => {
        if (error) {
            console.error('Error deleting employee:', error);
            res.status(500).json({ error: 'Failed to delete employee' });
        } else {
            if (result.affectedRows === 0) {
                res.status(404).json({ error: 'Employee not found' });
            } else {
                res.json({ message: 'Employee deleted successfully' });
            }
        }
    });
});

// PUT - Update dname and doj
app.put('/employees/:id', (req, res) => {
    const id = req.params.id;
    const { dname, doj } = req.body;
    const query = 'UPDATE Employee_Tb SET dname = ?, doj = ? WHERE id = ?';
    connection.query(query, [dname, doj, id], (error, result) => {
        if (error) {
            console.error('Error updating employee:', error);
            res.status(500).json({ error: 'Failed to update employee' });
        } else {
            if (result.affectedRows === 0) {
                res.status(404).json({ error: 'Employee not found' });
            } else {
                res.json({ message: 'Employee updated successfully' });
            }
        }
    });
});

// Start the server
const port = 7008;
app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
