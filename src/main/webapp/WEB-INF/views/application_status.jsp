<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Check Application Status</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
            box-sizing: border-box;
        }
        *, *::before, *::after {
            box-sizing: inherit;
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
            width: 100%;
            margin: 40px auto;
            text-align: center;
        }
        .form-box {
            width: 90%;
            max-width: 400px;
            margin: 0 auto;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        .form-box h2 {
            font-size: 22px;
            color: #333;
            margin-bottom: 20px;
        }
        .form-box input {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            display: block;
            width: calc(100% - 20px);
        }
        .form-box button {
            padding: 10px;
            background-color: #333;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
        }
        .result {
            margin-top: 20px;
            font-size: 16px;
            color: #333;
        }
        .footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <div class="header">
        <h1>TVPSS SMART MANAGEMENT SYSTEM</h1>
    </div>

    <!-- Main Content -->
    <div class="container">
        <div class="form-box">
            <h2>Check Application Status</h2>
            
            <!-- Form -->
            <form action="checkApplicationStatus" method="post">
                <input type="text" name="icNo" placeholder="ENTER IC NO" required>
                <input type="email" name="email" placeholder="ENTER EMAIL" required>
                <button type="submit">CHECK STATUS</button>
            </form>

            <!-- Result Section -->
            <div class="result">
                <% 
                    // Assuming the status message is set in a request attribute
                    String statusMessage = (String) request.getAttribute("statusMessage");
                    if (statusMessage != null) {
                        out.println("<p>" + statusMessage + "</p>");
                    }
                %>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        &copy; TVPSS, All Rights Reserved
    </div>

</body>
</html>
