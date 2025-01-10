<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: #fff;
            width: 400px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .form-container img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            margin-bottom: 20px;
        }

        .form-container h1 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
        }

        .form-container form {
            display: flex;
            flex-direction: column;
        }

        .form-container label {
            text-align: left;
            font-size: 14px;
            color: #555;
            margin-bottom: 5px;
        }

        .form-container input,
        .form-container select {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        .form-container button {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
        }

        .form-container button:hover {
            background-color: #0056b3;
        }

        .form-container p {
            font-size: 14px;
            color: #555;
            margin-top: 10px;
        }

        .form-container a {
            color: #007bff;
            text-decoration: none;
        }

        .form-container a:hover {
        	color: #0056b3;
            text-decoration: underline;
        }

        .error {
            color: red;
            font-size: 14px;
            margin-bottom: 15px;
        }
    </style>
    <script>
        function toggleFields() {
            const role = document.getElementById("role").value;
            const districtField = document.getElementById("districtField");
            const schoolField = document.getElementById("schoolField");

            districtField.style.display = role === "ROLE_PPDADMIN" ? "block" : "none";
            schoolField.style.display = role === "ROLE_TEACHER" || role === "ROLE_STUDENT" ? "block" : "none";
        }
    </script>
</head>
<body>
    <div class="form-container">
        <img src="@{/resources/images/logo.png}" alt="Logo">
        <h1>Register</h1>

        <!-- Display Error Messages -->
        <div th:if="${error != null}" class="error">
            <p th:text="${error}"></p>
        </div>

        <!-- Registration Form -->
        <form action="register" method="post">
            <!-- CSRF Token -->
            <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" th:value="${username}" required>

            <div id="districtField" style="display: none;">
                <label for="district">District:</label>
                <input type="text" id="district" name="district" th:value="${district}">
            </div>

            <div id="schoolField" style="display: none;">
                <label for="school">School:</label>
                <input type="text" id="school" name="school" th:value="${school}">
            </div>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>

            <label for="role">Role:</label>
            <select id="role" name="role" required onchange="toggleFields()">
                <option value="ROLE_PPDADMIN">PPD Admin</option>
                <option value="ROLE_JPNJADMIN">JPNJ Admin</option>
                <option value="ROLE_TEACHER">Teacher</option>
                <option selected value="ROLE_STUDENT">Student</option>
            </select>

            <button type="submit">Register</button>
        </form>

        <p>
            Already have an account? <a th:href="@{/login}">Login here</a>.
        </p>
    </div>
</body>
</html>
