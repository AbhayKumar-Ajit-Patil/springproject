<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            background: url('https://machinelearningmastery.com/wp-content/uploads/2017/01/A-Gentle-Introduction-to-the-Random-Walk-for-Times-Series-Forecasting-with-Python.jpg') center/cover no-repeat;
            animation: backgroundAnimation 10s infinite alternate;
            color: white;
        }
        @keyframes backgroundAnimation {
            0% {
                background-size: 100% 100%;
            }
            50% {
                background-size: 110% 110%;
            }
            100% {
                background-size: 100% 100%;
            }
        }
        nav {
            background-color: rgba(0, 0, 0, 0.6);
            color: white;
            padding: 1rem;
            display: flex;
            justify-content: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
        }
        nav ul li {
            margin: 0 1rem;
        }
        nav ul li a {
            text-decoration: none;
            color: white;
            font-size: 1.1rem;
            transition: color 0.3s ease, transform 0.3s ease;
        }
        nav ul li a:hover {
            color: #ffd700;
            transform: scale(1.1);
        }
        .container {
            padding: 2rem;
            text-align: center;
            animation: fadeIn 2s ease-in-out;
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        /* Footer Styling */
        footer {
            background-color: rgba(0, 0, 0, 0.8);
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        }
        footer a {
            color: #ffd700;
            text-decoration: none;
            font-weight: bold;
        }
        footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <nav>
        <ul>
            <li><a href="./add-contact-page">Add Contact</a></li>
              <li><a href="./users">All Users</a></li>
          
            <li><a href="./contacts">All Contacts</a></li>
            <li><a href="./logout">Log Out</a></li>
        </ul>
    </nav>
    <div class="container">
        <h1>Welcome to the Contact Management System</h1>
    </div>

    <!-- Footer Section -->
    <footer>
        <p>&copy; 2025 Contact Management System. All rights reserved.</p>
        <p><a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a></p>
    </footer>
</body>
</html>
