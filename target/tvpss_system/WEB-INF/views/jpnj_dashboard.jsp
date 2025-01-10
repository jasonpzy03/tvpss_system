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
        .header a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
        }
        .header a:hover {
            text-decoration: underline;
        }
        .content {
            margin: 20px;
        }
        .content h1 {
            text-align: center;
        }
        .info {
            margin: 20px 0;
            font-size: 18px;
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
            <a href="dashboard">Home</a>
            <a href="statistics">Statistics</a>
            <a href="monitorTVPSSResource">Monitor School TVPSS Resources</a>
            <a href="#">Log Out</a>
        </nav>
    </div>

    <div class="content">
        <h1>INFORMATION OF TVPSS PROGRAM IN JOHOR</h1>
        <div class="info">
            <p><strong>NUMBER OF SCHOOLS:</strong> 50</p>
            <p><strong>UPCOMING ACTIVITIES / COMPETITION:</strong></p>
            <table>
                <tr>
                    <th>Date</th>
                    <th>Event Name</th>
                    <th>Description</th>
                    <th>Total Participants</th>
                </tr>
                <tr>
                    <td>24/11/2024</td>
                    <td>Seminar Photoshooting</td>
                    <td>Masa: 10:00am - 5:30pm<br>Tempat: UTM, Skudai</td>
                    <td>30/100</td>
                </tr>
                <tr>
                    <td>30/11/2024</td>
                    <td>Webinar Film</td>
                    <td>Masa: 10:00am - 5:30pm</td>
                    <td>70/100</td>
                </tr>
            </table>
        </div>
    </div>

    <div class="footer">
        &copy; TVPSS, All Rights Reserved
    </div>
</body>
</html>
