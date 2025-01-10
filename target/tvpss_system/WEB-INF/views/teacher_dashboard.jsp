<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TVPSS Smart Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        /* Navigation bar styles */
        .navbar {
            background-color: #000;
            color: #fff;
            padding: 10px 20px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .navbar a {
            color: #fff;
            text-decoration: none;
            margin-right: 20px;
        }

        .navbar a:hover {
            text-decoration: underline;
        }

        .navbar .right {
            display: flex;
        }

        /* Main container */
        .container {
            display: flex;
            justify-content: space-between;
            padding: 20px;
        }

        /* School details */
        .details {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            width: 70%;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .details h1 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
        }

        .details p {
            margin: 10px 0;
            font-size: 16px;
            color: #555;
        }

        /* Sidebar */
        .sidebar {
            width: 25%;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .sidebar h3 {
            font-size: 18px;
            margin-bottom: 15px;
        }

        .competition {
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
        }

        .competition p {
            margin: 5px 0;
            font-size: 14px;
        }

        .competition a {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        .competition a:hover {
            text-decoration: underline;
        }

        /* Footer */
        .footer {
            text-align: center;
            padding: 10px;
            background-color: #f4f4f4;
            font-size: 14px;
            color: #555;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <div class="navbar">
        <div class="left">
            <span>TVPSS SMART MANAGEMENT SYSTEM</span>
        </div>
        <div class="right">
            <a href="dashboard">Home</a>
            <a href="availablecompetitions">Available Competitions</a>
            <a href="updateinformation">Update TVPSS Information</a>
            <a href="crewapplications">View TVPSS Crew Application</a>
            <a href="#">Log Out</a>
        </div>
    </div>

    <!-- Main Container -->
    <div class="container">
        <!-- School Details -->
        <div class="details">
            <h1>SK Seri Perling TVPSS Team</h1>
            <p><strong>School ID:</strong> #TVPSS001</p>
            <p><strong>School Name:</strong> SK SERI PERLING</p>
            <p><strong>TVPSS Team Name:</strong> Perling Dinamik TV</p>
            <p><strong>YouTube Channel Link:</strong> <a href="https://www.youtube.com/@perlingdinamiktv" target="_blank">https://www.youtube.com/@perlingdinamiktv</a></p>
            <p><strong>Available Equipment:</strong> Camera; Tripod; External Mic; Mobile Lighting (3 Point); Green Screen (Permanent); Editing Software (Paid Version)</p>
            <p><strong>Studio Level:</strong> 2</p>
            <p><strong>TVPSS Version:</strong> 3</p>
        </div>

        <!-- Sidebar -->
        <div class="sidebar">
            <h3>Upcoming Competitions</h3>
            <div class="competition">
                <p><strong>Most Popular TVPSS Video in YouTube</strong></p>
                <p>25/11/2024</p>
                <p><a href="availablecompetitions">Details ></a></p>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        © TVPSS, All Rights Reserved
    </div>
</body>
</html>
