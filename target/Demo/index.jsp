<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            background-image: url('man.jpg'); /* Add your background image URL here */
            background-size: cover;
            background-repeat: no-repeat;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        h1 {
            text-align: center;
            color: white;
        }

        .container {
            width: 600px;
            margin: 0 auto;
            padding: 40px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 20px;
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
        <h1>WELCOME</h1>
    </div>
    <div class="container">
        <h2>Login</h2>
        <form action="login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required autofocus/><br/>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required/><br/>
            <button type="submit">Login</button>
        </form>
        <div>
         <a href="registration.jsp">Sign Up</a>
        </div>
    </div>
</body>
</html>
