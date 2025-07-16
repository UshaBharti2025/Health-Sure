<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All Recipients</title>

    <style>
        body {
            background-color: #f3f4f6;
            color: #1f2937;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            min-height: 100vh;
        }

        .navbar {
            background-color: #1e40af;
            padding: 16px 0;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: center;
            gap: 30px;
        }

        .navbar h\:commandLink {
            color: white;
            font-size: 18px;
            font-weight: 600;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .navbar h\:commandLink:hover {
            color: #facc15;
        }

        .navbar .active {
            color: #facc15;
            font-weight: bold;
            text-decoration: underline;
        }

        .heading {
            text-align: center;
            padding: 40px 0 10px;
        }

        .heading h2 {
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 8px;
        }

        .heading p {
            color: #6b7280;
        }

        .table-wrapper {
            max-width: 1200px;
            margin: 0 auto;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            overflow-x: auto;
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 14px;
            color: #374151;
        }

        th, td {
            padding: 10px 12px;
            border: 1px solid #d1d5db;
            text-align: left;
        }

        th {
            background-color: #f3f4f6;
            font-weight: 600;
        }

        .no-data {
            text-align: center;
            color: red;
            font-weight: 600;
            margin-top: 20px;
        }
    </style>
</head>

<body>

    <!-- ✅ Navbar -->
    <div class="navbar">
        <h:form style="display:inline;">
            <h:commandLink value="Dashboard" action="dashboardbase" />
        </h:form>
        <h:form style="display:inline;">
            <h:commandLink value="Search" action="SearchRecipientbase" />
        </h:form>
        <h:form style="display:inline;">
            <h:commandLink value="Show" action="ShowRecipientbase" styleClass="active" />
        </h:form>
        <h:form style="display:inline;">
            <h:commandLink value="Update" action="UpdateRecipientbase" />
        </h:form>
    </div>

    <!-- ✅ Heading -->
    <div class="heading">
        <h2>All Recipients</h2>
        <p>Below is the list of all registered recipients.</p>
    </div>

    <!-- ✅ Table Section -->
    <div class="table-wrapper">
        <h:form>
            <h:dataTable value="#{recipientController.showRecipient}" var="rec" styleClass="recipient-table">

                <h:column>
                    <f:facet name="header"><h:outputText value="Health ID" /></f:facet>
                    <h:outputText value="#{rec.hId}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputText value="First Name" /></f:facet>
                    <h:outputText value="#{rec.firstName}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputText value="Last Name" /></f:facet>
                    <h:outputText value="#{rec.lastName}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputText value="Mobile" /></f:facet>
                    <h:outputText value="#{rec.mobile}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputText value="Gender" /></f:facet>
                    <h:outputText value="#{rec.gender}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputText value="DOB" /></f:facet>
                    <h:outputText value="#{rec.dob}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputText value="Email" /></f:facet>
                    <h:outputText value="#{rec.email}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputText value="Address" /></f:facet>
                    <h:outputText value="#{rec.address}" />
                </h:column>

                <h:column>
                    <f:facet name="header"><h:outputText value="Created At" /></f:facet>
                    <h:outputText value="#{rec.createdAt}" />
                </h:column>

            </h:dataTable>

            <!-- ✅ No Recipients Message -->
            <h:outputText value="No recipients to display."
                          rendered="#{empty recipientController.showRecipient}"
                          styleClass="no-data" />
        </h:form>
    </div>

</body>
</html>
</f:view>
