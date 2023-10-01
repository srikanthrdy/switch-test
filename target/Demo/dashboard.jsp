<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <!-- Add your CSS styles here -->
      <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            background-image: url('background.jpg'); /* Add your background image URL here */
            background-size: cover;
            background-repeat: no-repeat;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .container {
            width: 600px;
            margin: 0 auto;
            padding: 40px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="tel"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        button[type="submit"],
        .signup-link {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
        }

        button[type="submit"]:hover,
        .signup-link:hover {
            background-color: #0056b3;
        }

        .signup-link {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div>
        <h2>Welcome to Your Dashboard</h2>
        
        <!-- Add content for the dashboard here -->
        <p>This is the dashboard page where you can display user-specific information and functionality.</p>
        
        <!-- Example: Display user's username -->
        <p><strong>Username:</strong> <%= request.getAttribute("username") %></p>
        
        <!-- Add more content, links, or functionality as needed -->
        
        <a href="logout.jsp">Logout</a> <!-- Example logout link -->
    </div>
</body>
</html>
