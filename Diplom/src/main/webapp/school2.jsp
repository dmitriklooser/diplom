<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="timetable" prefix="tt"%>
<%@ page isELIgnored="false" %>
<%@ page import="web.Step2Data" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<html>
<%@ include file="/HtmlHeader.jsp"%>  
  <body>
    <div class="header"><p class="stroke" align="center"><font size="8" color="c6fbb3" face="Arial">Подготовка нового расписания</font></p>
    </div>
    <div class="body">
        <div class="form">
            <form action="" method="post">
             <div class="leftCtrl">
                <p><font size="5">Поставьте галочки напротив дня недели и времени, выделенных для занятий и нажмите "сохранить".</font><br/><br/><br/>
                <table width="100" border="2" align="center" cellpadding="4" cellspacing="0">
                <tr>
                <th width="600">время\день недели</th>
                <c:forEach var="day" items="${weekDays}">
                    <th>${day}</th>
                </c:forEach>
                </tr>
                <c:forEach var="time" items="${times}">
                    <tr>
	                    <td>${tt:formatTime(time)}</td>
	                    <c:forEach var="tSl" items="${grpTSlots[time]}">
	                       <td><input name="${tSl.id}" id="${tSl.id}" type="checkbox" ${tSl.inUse?'checked':''}><br/></td>
	                    </c:forEach>
                    </tr>
                </c:forEach>
                </table>              
              </div>
                <br/>             
              <div class="rightCtrl"><br/><br/><br/>
                  <input name="item13" id="item13" type="submit" value="Далее" ><br/><br/><br/>
                  <input name="item14" id="item14" type="submit" value="Выйти"><br/>            
                <br/>
                           
              </div>               
            </form>
        </div>  

    </div>
    
    <div class="footer">
    </div>
    
    
  </body> 
</html>

