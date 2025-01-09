<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Monitor School TVPSS Resources</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f5f5f5;">
    <div style="background-color: #333; padding: 10px; color: white; text-align: center;">
        <h1 style="margin: 0; font-size: 18px;">TVPSS SMART MANAGEMENT SYSTEM</h1>
    </div>
    <div style="padding: 10px;">
        <a href="#" style="text-decoration: none; color: #333; font-size: 14px;">&#8592; Back</a>
    </div>
    <div style="width: 80%; margin: 20px auto; background-color: white; box-shadow: 0 0 10px rgba(0,0,0,0.1); border-radius: 8px;">
        <h2 style="text-align: center; font-size: 20px; padding: 20px; margin: 0; color: #333;">MONITOR SCHOOL TVPSS RESOURCES</h2>
        <div style="padding: 20px;">
            <table style="width: 100%; border-collapse: collapse;">
                <thead>
                    <tr style="background-color: #f0f0f0; text-align: left;">
                        <th style="padding: 10px; border: 1px solid #ddd;">School ID</th>
                        <th style="padding: 10px; border: 1px solid #ddd;">School</th>
                        <th style="padding: 10px; border: 1px solid #ddd;">Equipment</th>
                        <th style="padding: 10px; border: 1px solid #ddd;">Studio Level</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="school" items="${schools}">
                        <tr>
                            <td style="padding: 10px; border: 1px solid #ddd;">${school.id}</td>
                            <td style="padding: 10px; border: 1px solid #ddd;">${school.name}</td>
                            <td style="padding: 10px; border: 1px solid #ddd;">${school.equipment}</td>
                            <td style="padding: 10px; border: 1px solid #ddd;">${school.studioLevel}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div style="text-align: center; margin-top: 20px;">
                <button style="padding: 10px 20px; border: none; border-radius: 4px; background-color: #ccc; color: #333; cursor: not-allowed;">Previous</button>
                <button style="padding: 10px 20px; border: none; border-radius: 4px; background-color: #007bff; color: white;">Next</button>
            </div>
        </div>
    </div>
    <div style="text-align: center; padding: 10px; background-color: #333; color: white; position: relative;">
        &copy; TVPSS, All Rights Reserved
    </div>
</body>
</html>
