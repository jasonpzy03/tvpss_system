<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Application Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .header {
            background-color: #333;
            padding: 10px;
            color: white;
            text-align: center;
        }
        .header h1 {
            margin: 0;
            font-size: 18px;
        }
        .container {
            text-align: center;
            margin: 40px auto;
        }
        .result-box {
            display: inline-block;
            text-align: left;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .result-box h2 {
            font-size: 22px;
            color: #333;
        }
        .result-box p {
            font-size: 14px;
            color: #555;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <div class="header">
        <h1>Application Result</h1>
    </div>

    <!-- Main Content -->
    <div class="container">
        <div class="result-box">
            <h2>Application Submitted Successfully!</h2>
            <p><strong>Full Name:</strong> ${application.fullName}</p>
            <p><strong>IC No:</strong> ${application.icNo}</p>
            <p><strong>Email:</strong> ${application.email}</p>
            <p><strong>School:</strong> ${application.school}</p>
            <p>Thank you for applying. We will contact you soon.</p>
        </div>
    </div>

</body>
</html>