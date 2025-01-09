<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Choose School</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f5f5f5;">

    <!-- Header -->
    <div style="background-color: #333; padding: 10px; color: white; text-align: center;">
        <h1 style="margin: 0; font-size: 18px;">TVPSS SMART MANAGEMENT SYSTEM</h1>
    </div>

    <!-- Main Content -->
    <div style="width: 80%; margin: 20px auto; text-align: center;">
        <h2 style="color: #333; font-size: 20px; margin-bottom: 20px;">Choose school to view content</h2>

        <!-- School List -->
        <div style="background-color: #001f3f; border-radius: 8px; padding: 20px; color: white; display: inline-block; width: 100%; max-width: 500px;">
            <div style="display: flex; justify-content: space-between; align-items: center; padding: 10px 20px; border-bottom: 1px solid #ccc;">
        <span>${school.name}</span>
        <a href="viewSchoolContent?id=${school.id}" 
           style="text-decoration: none; color: white; background-color: #007bff; padding: 5px 10px; border-radius: 4px; font-size: 14px;">View</a>
    </div>
        </div>
    </div>

    <!-- Footer -->
    <div style="text-align: center; margin-top: 40px;">
        <h3 style="font-size: 16px; color: #333; margin-bottom: 10px;">Follow us</h3>
        <div>
            <a href="#" style="text-decoration: none; margin: 0 10px; font-size: 20px; color: #333;">📷</a>
            <a href="#" style="text-decoration: none; margin: 0 10px; font-size: 20px; color: #333;">📘</a>
            <a href="#" style="text-decoration: none; margin: 0 10px; font-size: 20px; color: #333;">🐦</a>
        </div>
    </div>

    <!-- Footer Bottom -->
    <div style="background-color: #333; color: white; text-align: center; padding: 10px;">
        &copy; TVPSS, All Rights Reserved
    </div>

</body>
</html>
