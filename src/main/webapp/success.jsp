<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
    <!-- Add your CSS styles here -->
      <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            background-image: url('iron.jpg'); /* Add your background image URL here */
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

        <h2>Registration Status</h2>
        <% if (request.getAttribute("registrationSuccess") != null && (boolean) request.getAttribute("registrationSuccess")) { %>
         <p>Successfully registered!</p>
        <p>Thank you for registering!</p>

        <h3>Registration Details:</h3>
        <ul>
            <li><strong>Username:</strong> <%= request.getParameter("username") %></li>
            <li><strong>Phone Number:</strong> <%= request.getParameter("phoneNumber") %></li>
            <li><strong>Email:</strong> <%= request.getParameter("email") %></li>
            <!-- You may choose to display more details here -->
        </ul>

        <!-- Add additional content or links here -->

            <!-- Display user profile details here -->
        <% } else { %>
            <p>Registration failed. Please check your data.</p>
             <p>Try to register Again!</p>
            <!-- Display an error message or redirect as needed -->
        <% } %>
            </div>
</body>
</html>
