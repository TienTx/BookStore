
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/image/thumb" var="image" />
<%@include file="../template/header.jsp" %>
<%@include file="inc/topHeader.jsp" %>
<%@include file="inc/navigation.jsp" %>

<section class="inside clearfix mg">
    <section class="content">
        <fieldset id="addressShipping">
            <legend>CardPoint</legend>
            <form action="" method="post" name="checkcp" id="checkcp">
                <label for="code">Code: </label>
                <input style="text-transform: uppercase;" required=""
                       type="text" id="code" name="code" pattern="([A-Za-z0-9]){6,6}">
                <input type="submit" value="Check">
            </form>
            <h2 class="hide" id="wrong"><spring:message code="order.isnotcardpoint"/></h2>
            <h2>Point: <font color="blue" id="cpoint">&nbsp;</font></h2>
            <h2>Email: <font color="blue" id="cemail">&nbsp;</font></h2>
            <h2>Phone: <font color="blue" id="cphone">&nbsp;</font></h2>
        </fieldset>
    </section>
    <%@include file="inc/rightAside.jsp" %>
</section>
<%@include file="inc/seenBook.jsp" %>

<%@include file="../template/footer.jsp" %>