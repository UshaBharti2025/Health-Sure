<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <title>Search Recipient</title>
    <style>
        body {
            background-color: white;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        /* NAVBAR STYLING */
        .navbar {
            display: flex;
            justify-content: center;
            background-color: #003366; /* Dark Blue */
            padding: 15px 0;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }

        .navbar a {
            color: white;
            margin: 0 30px;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
            transition: color 0.3s;
        }

        .navbar a:hover {
            color: #ffcc00;
        }

        /* SEARCH BOX CENTERED */
        .content {
            text-align: center;
            margin-top: 50px;
        }

        form {
            display: inline-block;
            text-align: left;
            margin-top: 30px;
        }

        select, input[type="text"] {
            padding: 10px;
            font-size: 16px;
            width: 250px;
            margin-right: 10px;
            border: 2px solid #003366;
            border-radius: 0px; /* Sharp edges */
        }

        .blue-btn {
            background-color: #003366;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 0px; /* Sharp edges */
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .blue-btn:hover {
            background-color: #002244;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 40px auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            border: 1px solid #000;
            padding: 10px;
            text-align: center;
            font-size: 15px;
        }

        th {
            background-color: #003366;
            color: white;
        }

        h2, h3 {
            color: #003366;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="dashboardDemo.jsp">Dashboard</a>
        <a href="SearchRecipientDemo.jsp">Search</a>
        <a href="ShowRecipientDemo.jsp">Show</a>
        <a href="UpdateRecipientDemo.jsp">Update</a>
    </div>

    <div class="content">
        <h2>Search Recipient</h2>

        <form method="get" action="SearchRecipientDemo.jsp">
            <label for="searchType">Search By:</label><br/><br/>
            <select name="searchType" id="searchType">
                <option value="hId">Health ID</option>
                <option value="firstName">User Name</option>
                <option value="mobile">Mobile</option>
                <option value="createdAt">Created At</option>
            </select><br/><br/>
            <input type="text" name="searchValue" placeholder="Enter search value..." required />
            <input type="submit" class="blue-btn" value="Search" />
        </form>
    </div>

<%
    class DummyRecipient {
        String hId, firstName, mobile, createdAt;
        DummyRecipient(String h, String f, String m, String c) {
            hId = h; firstName = f; mobile = m; createdAt = c;
        }
    }

    java.util.List<DummyRecipient> list = new java.util.ArrayList<>();
    list.add(new DummyRecipient("H101", "Alice", "9876543210", "2023-01-15"));
    list.add(new DummyRecipient("H102", "Albert", "9876541111", "2023-02-10"));
    list.add(new DummyRecipient("H103", "Susan", "9876549999", "2023-05-25"));

    String searchType = request.getParameter("searchType");
    String searchValue = request.getParameter("searchValue");
    java.util.List<DummyRecipient> resultList = new java.util.ArrayList<>();

    if (searchType != null && searchValue != null) {
        for (DummyRecipient r : list) {
            String value = "";
            switch (searchType) {
                case "hId": value = r.hId; break;
                case "firstName": value = r.firstName; break;
                case "mobile": value = r.mobile; break;
                case "createdAt": value = r.createdAt; break;
            }
            if (value.toLowerCase().contains(searchValue.toLowerCase())) {
                resultList.add(r);
            }
        }
    }
%>

<%
    if (request.getParameter("searchValue") != null) {
%>
    <h3 style="text-align:center;">Search Results</h3>
    <table>
        <tr>
            <th>Health ID</th>
            <th>First Name</th>
            <th>Mobile</th>
            <th>Created At</th>
        </tr>
        <%
            if (resultList.size() == 0) {
        %>
            <tr><td colspan="4">No matching results found.</td></tr>
        <%
            } else {
                for (DummyRecipient r : resultList) {
        %>
            <tr>
                <td><%= r.hId %></td>
                <td><%= r.firstName %></td>
                <td><%= r.mobile %></td>
                <td><%= r.createdAt %></td>
            </tr>
        <%
                }
            }
        %>
    </table>
<%
    }
%>
</body>
</html>
