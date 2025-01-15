<%@page import="com.jspiders.springmvc1.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users Page</title>
    <style type="text/css">
        /* General styling */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('https://media.gettyimages.com/id/1352955578/vector/telephone-and-address-book-flat-icon.jpg?s=612x612&w=gi&k=20&c=YdMQwznL2UXNHgTXuhPQy09CZFHgcQ4BaTAqzTHSiyE='); /* Background image URL */
            background-size: cover;
            background-position: center;
            animation: moveBackground 15s linear infinite; /* Animation to move the background image */
            color: #333;
        }

        h1 {
            text-align: center;
            color: #444;
            margin: 20px;
        }

        /* Card container styling */
        .card-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 20px;
            padding: 20px;
            margin: 0 auto;
            max-width: 1200px;
            z-index: 1;
            position: relative;
        }

        /* Individual card styling */
        .card {
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
        }

        .card-header {
            background-color: #007bff;
            color: #fff;
            padding: 15px;
            font-size: 18px;
            text-align: center;
        }

        .card-body {
            padding: 15px;
        }

        .card-body p {
            margin: 10px 0;
            font-size: 14px;
            line-height: 1.6;
        }

        .action-buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 15px;
        }

        /* Edit button styling */
        .edit-button {
            text-decoration: none;
            color: #fff;
            background-color: #28a745; /* Green for edit */
            padding: 8px 16px;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .edit-button:hover {
            background-color: #218838; /* Darker green on hover */
        }

        /* Delete button styling */
        .delete-button {
            text-decoration: none;
            color: #fff;
            background-color: #dc3545; /* Red for delete */
            padding: 8px 16px;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .delete-button:hover {
            background-color: #c82333; /* Darker red on hover */
        }

        /* New card for the message section */
        .message-card {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            margin-top: 20px;
        }

        /* Background animation */
        @keyframes moveBackground {
            0% {
                background-position: 0% 0%;
            }
            50% {
                background-position: 100% 100%;
            }
            100% {
                background-position: 0% 0%;
            }
        }

        /* Responsive styling */
        @media (max-width: 768px) {
            .card-container {
                grid-template-columns: repeat(auto-fill, minmax(260px, 1fr));
            }

            .card-header {
                font-size: 16px;
            }

            .card-body p {
                font-size: 12px;
            }

            .action-buttons a {
                padding: 6px 12px;
                font-size: 12px;
            }

            .message-card {
                padding: 15px;
            }
        }

    </style>
</head>

<body>
    <% 
    @SuppressWarnings("unchecked")
    List<UserDTO> users = (List<UserDTO>) request.getAttribute("users");
    if (users != null) {
    %>
    <div class="card-container">
        <% for (UserDTO user : users) { %>
        <div class="card">
            <div class="card-header">
                <%= user.getName() %> 
            </div>
            <div class="card-body">
                <p><strong>Email:</strong> <%= user.getEmail() %></p>
                <p><strong>Mobile:</strong> <%= user.getMobile() %></p>
                <p><strong>Work:</strong> <%= user.getPassword() %></p>
                
                <div class="action-buttons">
                    <a href="./edit-user?id=<%= user.getId() %>" class="edit-button">Edit</a>
                    <a href="./delete-user?id=<%= user.getId() %>" class="delete-button">Delete</a>
                </div>
            </div>
        </div>
        <% } %>
    </div>
    <% } %>

    <%
    String message = (String) request.getAttribute("message");
    if (message != null) {
    %>
    <div class="message-card">
        <h1><%= message %></h1>
    </div>
    <% } %>

</body>

</html>
