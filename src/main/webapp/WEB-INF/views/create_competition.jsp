<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create TVPSS Competition</title>
    <style>
        /* General Styles */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            color: #333;
        }
        
         /* Navbar Styles */
        .navbar {
            background-color: #20232a;
            color: #fff;
            padding: 10px 20px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .navbar a {
            color: #fff;
            text-decoration: none;
            margin: 0 15px;
            font-size: 14px;
        }

        .navbar a:hover {
            text-decoration: underline;
        }

        .navbar .logo {
            font-weight: bold;
            font-size: 18px;
        }

        /* Page Header */
        h1 {
            text-align: center;
            font-size: 22px;
            margin: 20px 0;
        }

        /* Form Container Styles */
        .form-container {
            width: 90%;
            max-width: 500px;
            background-color: #fff;
            padding: 20px;
            margin: 30px auto;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            box-sizing: border-box;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-size: 14px;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input, 
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
        }

        .form-group textarea {
            resize: none;
            height: 100px;
        }

        .form-group input:focus, 
        .form-group textarea:focus {
            outline: none;
            border-color: #6c63ff;
        }

        /* Submit Button Styles */
        .submit-btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #6c63ff;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            text-align: center;
        }

        .submit-btn:hover {
            background-color: #5a54d8;
        }

        /* Footer Styles */
        footer {
            text-align: center;
            padding: 15px 0;
            background-color: #20232a;
            color: #fff;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <div class="navbar">
        <div class="logo">TVPSS SMART MANAGEMENT SYSTEM</div>
        <div>
            <a href="dashboard">Home</a>
            <a href="createCompetition">Create Competition</a>
            <a href="validateTVPSSInfo">Validate School TVPSS Information</a>
            <a href="monitorTVPSSResource">Monitor School TVPSS Resources</a>
            <a href="#">Log Out</a>
        </div>
    </div>

    <!-- Main Content -->
    <div class="form-container">
        <h1>Create TVPSS Competition</h1>
        <form action="submitCompetition.jsp" method="post">
            <!-- Competition Name -->
            <div class="form-group">
                <label for="competitionName">Competition Name</label>
                <input type="text" id="competitionName" name="competitionName" placeholder="Competition Name" required>
            </div>

            <!-- Competition Description -->
            <div class="form-group">
                <label for="competitionDescription">Competition Description</label>
                <textarea id="competitionDescription" name="competitionDescription" placeholder="Description" required></textarea>
            </div>

            <!-- Submit Button -->
            <button type="submit" class="submit-btn">SUBMIT</button>
        </form>
    </div>

    <!-- Footer -->
    <footer>
        © TVPSS, All Rights Reserved
    </footer>
</body>
</html>
