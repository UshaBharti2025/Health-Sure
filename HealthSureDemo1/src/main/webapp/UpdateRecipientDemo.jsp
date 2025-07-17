<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Recipient</title>
    </head>
    <body style="background-color: white;">
        <h:form prependId="false">
            <h2>Update Recipient Details</h2>

            <h:outputLabel value="HID: " />
            <h:inputText id="hId" value="#{recipientBean.hId}" readonly="true"/><br/><br/>

            <h:outputLabel value="First Name: " />
            <h:inputText id="firstName" value="#{recipientBean.firstName}"/><br/><br/>

            <h:outputLabel value="Last Name: " />
            <h:inputText id="lastName" value="#{recipientBean.lastName}"/><br/><br/>

            <h:outputLabel value="Mobile: " />
            <h:inputText id="mobile" value="#{recipientBean.mobile}"/><br/><br/>

            <h:outputLabel value="Email: " />
            <h:inputText id="email" value="#{recipientBean.email}"/><br/><br/>

            <h:commandButton action="#{recipientBean.update}" value="Update Recipient" style="background-color:blue;color:white;" /><br/><br/>

            <h:commandLink value="Back to Search Page" action="SearchRecipientDemo.jsp" /><br/>
            <h:commandLink value="Go to Recipient Dashboard" action="dashboardDemo.jsp" />
        </h:form>
    </body>
</html>
</f:view>
