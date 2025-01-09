<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>TVPSS Smart Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .header {
            background-color: #101820;
            color: white;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header span {
            font-size: 18px;
        }
        .header a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
        }
        .header a:hover {
            text-decoration: underline;
        }
        .sidebar {
            width: 200px;
            background-color: #f4f4f4;
            position: fixed;
            top: 0;
            bottom: 0;
            padding: 20px 10px;
        }
        .sidebar a {
            display: block;
            padding: 10px;
            margin-bottom: 10px;
            color: #101820;
            text-decoration: none;
            border-radius: 5px;
        }
        .sidebar a:hover {
            background-color: #ddd;
        }
        .content {
            margin-left: 220px;
            padding: 20px;
        }
        .content h1 {
            margin-bottom: 20px;
        }
        .search-bar {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }
        .search-bar input {
            padding: 10px;
            flex: 1;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .search-bar button {
            padding: 10px 15px;
            background-color: #101820;
            color: white;
            border: none;
            border-radius: 5px;
            margin-left: 10px;
            cursor: pointer;
        }
        .search-bar button:hover {
            background-color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        .status {
            padding: 5px 10px;
            border-radius: 5px;
            text-align: center;
        }
        .status.in-progress {
            background-color: #e74c3c;
            color: white;
        }
        .status.checked {
            background-color: #2ecc71;
            color: white;
        }
        .footer {
            text-align: center;
            margin-top: 50px;
            font-size: 14px;
            color: #555;
        }
    </style>
</head>
<body>
    <div class="header">
        <span>TVPSS SMART MANAGEMENT SYSTEM</span>
        <nav>
            <a href="#">EN. ALI</a>
            <a href="#">Log Out</a>
        </nav>
    </div>

    <div class="content">
        <h1>School Submission Status</h1>

        <div class="search-bar">
            <input type="text" placeholder="Search...">
            <button>Search</button>
        </div>

        <table>
            <thead>
                <tr>
                    <th>School</th>
                    <th>Date Submit</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>SK Pulai</td>
                    <td>9/11/2024</td>
                    <td><span class="status in-progress">In Progress</span></td>
                </tr>
                <tr>
                    <td>SK Skudai</td>
                    <td>6/11/2024</td>
                    <td><span class="status checked">Checked</span></td>
                </tr>
                <tr>
                    <td>SK Senai</td>
                    <td>3/11/2024</td>
                    <td><span class="status checked">Checked</span></td>
                </tr>
                <tr>
                    <td>SK Taman Daya</td>
                    <td>5/11/2024</td>
                    <td><span class="status checked">Checked</span></td>
                </tr>
                <tr>
                    <td>SK Johor Daya</td>
                    <td>6/11/2024</td>
                    <td><span class="status checked">Checked</span></td>
                </tr>
                <tr>
                    <td>SK Taman U</td>
                    <td>3/11/2024</td>
                    <td><span class="status checked">Checked</span></td>
                </tr>
                <tr>
                    <td>SK Bukit Tinggi</td>
                    <td>3/11/2024</td>
                    <td><span class="status checked">Checked</span></td>
                </tr>
                <tr>
                    <td>SK Taman Indah</td>
                    <td>1/11/2024</td>
                    <td><span class="status checked">Checked</span></td>
                </tr>
                <tr>
                    <td>SK Paramount</td>
                    <td>1/11/2024</td>
                    <td><span class="status checked">Checked</span></td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="footer">
        &copy; TVPSS, All Rights Reserved
    </div>
</body>
</html>