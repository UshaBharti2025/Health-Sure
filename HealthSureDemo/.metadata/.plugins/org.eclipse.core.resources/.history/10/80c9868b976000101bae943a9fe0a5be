<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Recipient</title>
    <style>
        body {
            background-color: #f3f4f6;
            color: #1f2937;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            min-height: 100vh;
        }

        /* Navbar */
        .navbar {
            background-color: #1e3a8a;
            padding: 16px 0;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: center;
            gap: 24px;
            margin-bottom: 40px;
        }

        .navbar h\:commandLink {
            color: white;
            font-size: 18px;
            font-weight: 600;
            text-decoration: none;
            transition: color 0.3s;
        }

        .navbar h\:commandLink:hover {
            color: #facc15;
        }

        .navbar .active {
            color: #facc15;
            text-decoration: underline;
            font-weight: bold;
        }

        /* Form container */
        .form-container {
            max-width: 520px;
            margin: auto;
            background-color: white;
            padding: 32px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        .form-title {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 24px;
        }

        .form-group {
            margin-bottom: 16px;
        }

        .form-group label {
            display: block;
            margin-bottom: 6px;
            font-weight: 600;
        }

        .form-group input[type="text"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #d1d5db;
            border-radius: 4px;
            font-size: 14px;
            outline: none;
        }

        .form-group input[readonly] {
            background-color: #e5e7eb;
        }

        .form-group input:focus {
            border-color: #2563eb;
            box-shadow: 0 0 0 2px rgba(37, 99, 235, 0.2);
        }

        .error-msg {
            color: red;
            font-size: 13px;
            margin-top: 4px;
        }

        .btn {
            background-color: #1d4ed8;
            color: white;
            font-weight: 600;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin: 10px auto;
            display: block;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
        }

        .btn:hover {
            background-color: #1e40af;
        }

        .link-group {
            margin-top: 20px;
            text-align: center;
        }

        .link-group h\:commandLink {
            color: #1d4ed8;
            margin: 0 12px;
            font-weight: 500;
            text-decoration: none;
        }

        .link-group h\:commandLink:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <!--Navbar -->
    <div class="navbar">
        <h:form><h:commandLink value="Dashboard" action="dashboard1" /></h:form>
        <h:form><h:commandLink value="Search" action="SearchRecipient1" /></h:form>
        <h:form><h:commandLink value="Show" action="ShowRecipient1" /></h:form>
        <h:form><h:commandLink value="Update" action="UpdateRecipient1" styleClass="active" /></h:form>
    </div>

   
    <!-- ✅ JS Alert for Global Message -->
    <h:panelGroup rendered="#{not empty facesContext.messageList}">
    <h:outputText escape="false" value="
        <script>
            alert('#{facesContext.messageList[0].summary}');
        </script>
    " />
</h:panelGroup>

    
     <!--Form Container -->
    <div class="form-container">
    
        <h:form prependId="false">
            <div class="form-title">Update Recipient Details</div>
            
            
             <!--  FacesMessages Block for inline messages -->
            <h:messages globalOnly="true" layout="table" style="color: green; font-weight: bold;" />
            
           

            <div class="form-group">
                <h:outputLabel for="hId" value="Health ID:" />
    
            <!-- ✅ Single readonly input with correct ID -->
                <h:inputText id="hId" value="#{recipientController.recipient.hId}" />

            <!-- ✅ This error message will now bind correctly -->
                <h:message for="hId" styleClass="error-msg" />
            </div>

            <div class="form-group">
                <h:outputLabel for="firstName" value="First Name:" />
                <h:inputText id="firstName" value="#{recipientController.recipient.firstName}" />
                <h:message for="firstName" styleClass="error-msg" />
            </div>

            <div class="form-group">
                <h:outputLabel for="lastName" value="Last Name:" />
                <h:inputText id="lastName" value="#{recipientController.recipient.lastName}" />
            </div>



            <div class="form-group">
                <h:outputLabel for="mobile" value="Mobile:" />
                <h:inputText id="mobile" value="#{recipientController.recipient.mobile}" />
                <h:message for="mobile" styleClass="error-msg" />
            </div>

            <div class="form-group">
                <h:outputLabel for="email" value="Email:" />
                <h:inputText id="email" value="#{recipientController.recipient.email}" />
            </div>

            <!--Submit Button -->
            <h:commandButton value="Update Recipient" action="#{recipientController.updateRecipient}" styleClass="btn" />

            <!--Links -->
            <div class="link-group">
                <h:commandLink value="Back to Search Page" action="SearchRecipient1" />
                <h:commandLink value="Go to Recipient Dashboard" action="dashboard1" />
            </div>
        </h:form>
    </div>

</body>
</html>
</f:view>
