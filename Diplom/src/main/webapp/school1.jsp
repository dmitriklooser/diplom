<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<html>
<%@ include file="/HtmlHeader.jsp"%>  
  <body>
    <div class="header">
    <p class="stroke" align="center"><font size="8" color="c6fbb3" face="Arial">Подготовка нового расписания</font></p>
    </div>
    <div class="body">
        <div class="form">
        <form action="main" method="post" name="mainForm" id="mainForm">
            <input type="hidden" name="step" id="step" value="STEP1"/>
            <input type="hidden" name="action" id="action" value=""/>
            <div class="leftCtrl">
                 <p><font size="5">Здравствуйте, данная программа поможет вам составить наиболее оптимальное школьное расписание (расписание занятий (уроков) в школе).</font></p>              
                <br/>
                       
              </div>
            <div class="rightCtrl">
                 <input name="item1" id="item1" type="submit" value="Составить расписание" onclick="javascript:onSubmit('mainForm')">             
                <br/>
                       
              </div>               
            </form>
        </div>  

    </div>
    
    <div class="footer">
    </div>
    
    
  </body> 
</html>

