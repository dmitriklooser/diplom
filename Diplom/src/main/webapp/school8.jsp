<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="timetable" prefix="tt"%>
<%@ page isELIgnored="false" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<html>
<%@ include file="/HtmlHeader.jsp"%>  
  <body>
    <div class="header"><p class="stroke" align="center"><font size="8" color="c6fbb3" face="Arial">Просмотр нового расписания</font></p>
    </div>
    <div class="body">
        <div class="form">
            <form action="" method="post">
              <input type="hidden" name="step" id="step" value="STEP8"/>
              <input type="hidden" name="action" id="action" value=""/>
             <div class="leftCtrl">
                 <p><font size="5">Расписание составлено! Выберите номер группы и нажмите "далее"</font><br>                 
                
             </div>
                                            
              <div class="rightCtrl">
                 <p><font size="5">№ группы:</font>
                 <select name="group" id="group">
                   <c:forEach var="group" items="${groups}">
                     <option value="${group.id}"><c:out value="${group.id}"/></option> 
                   </c:forEach>
                </select>
                <br>
                 <input name="item15" id="item15" type="submit" value="Далее" onclick="javascript:onAdd('mainForm')"><br/><br/><br/>
                 <input name="item16" id="item16" type="submit" value="Выйти" onclick="javascript:onReset('mainForm')"><br/>
                          
              </div>               
            </form>
            <table width="900" border="3" align="center" cellpadding="4" cellspacing="0" class="ttable">
            <tr>
                <th colspan=13><c:out value="${crGroup != null ? crGroup:'N'}"/></th>
            </tr>
            <tr>
                <th width="600">время\день недели</th>
                <th colspan=2>понедельник</th>
                <th colspan=2>вторник</th>
                <th colspan=2>среда</th>
                <th colspan=2>четверг</th>
                <th colspan=2>пятница</th>
                <th colspan=2>суббота</th>
            </tr>
            <c:forEach var="tStart" items="${times}">
                <c:set var="timeOn" scope="page" value="true"/>
                    <tr>
	                <c:forEach var="wd" items="${weekDays}">
	                <c:set var="lss" scope="request" value="${tt:filterByDT(lessons, wd, tStart)}"/>
	                     <c:if test="${timeOn eq 'true'}">
	                        <td rowspan=3>${tt:formatLessonTime(tStart)}</td>
	                        <c:set var="timeOn" scope="page" value="false"/>
	                      </c:if>  	                
		                    <td>предмет</td>
   	                        <td><c:out value="${lss != null ? lss.module.moduleName:' '}" escapeXml="true"/></td>
	                </c:forEach>
	                </tr>
                    <tr>
                    <c:forEach var="wd" items="${weekDays}">
                    <c:set var="lss" scope="request" value="${tt:filterByDT(lessons, wd, tStart)}"/>
                            <td>комната</td>
                            <td><c:out value="${lss!=null?lss.room.roomNumber:''}" escapeXml="true"/></td>
                    </c:forEach>
                    </tr>
                    <tr>
                    <c:forEach var="wd" items="${weekDays}">
                    <c:set var="lss" scope="request" value="${tt:filterByDT(lessons, wd, tStart)}"/>
                            <td>учитель</td>
                            <td><c:out value="${lss!=null?lss.professor.professorName:''}" escapeXml="true"/></td>
                    </c:forEach>
                    </tr>
            </c:forEach>

            <!-- 
            <tr>
                <td rowspan=3>9:00 - 11:00</td>
                <td>предмет</td>
                <td>п1</td>
                <td>предмет</td>
                <td>п2</td>
                <td>предмет</td>
                <td>п3</td>
                <td>предмет</td>
                <td>п4</td>
                <td>предмет</td>
                <td>п5</td>
            </tr>
            <tr>
                <td>комната</td>
                <td>к1</td>
                <td>комната</td>
                <td>к2</td>
                <td>комната</td>
                <td>к3</td>
                <td>комната</td>
                <td>к4</td>
                <td>комната</td>
                <td>к5</td>
            </tr>
            <tr>
                <td>преподаватель</td>
                <td>п1</td>
                <td>преподаватель</td>
                <td>п2</td>
                <td>преподаватель</td>
                <td>п3</td>
                <td>преподаватель</td>
                <td>п4</td>
                <td>преподаватель</td>
                <td>п5</td>
            </tr>
            <tr>
                <td rowspan=3>11:00 - 13:00</td>
                <td>предмет</td>
                <td>п1</td>
                <td>предмет</td>
                <td>п2</td>
                <td>предмет</td>
                <td>п3</td>
                <td>предмет</td>
                <td>п4</td>
                <td>предмет</td>
                <td>п5</td>
            </tr>
            <tr>
                <td>комната</td>
                <td>к1</td>
                <td>комната</td>
                <td>к2</td>
                <td>комната</td>
                <td>к3</td>
                <td>комната</td>
                <td>к4</td>
                <td>комната</td>
                <td>к5</td>
            </tr>
            <tr>
                <td>преподаватель</td>
                <td>п1</td>
                <td>преподаватель</td>
                <td>п2</td>
                <td>преподаватель</td>
                <td>п3</td>
                <td>преподаватель</td>
                <td>п4</td>
                <td>преподаватель</td>
                <td>п5</td>
            </tr>
            <tr>
                <td rowspan=3>13:00 - 15:00</td>
                <td>предмет</td>
                <td>п1</td>
                <td>предмет</td>
                <td>п2</td>
                <td>предмет</td>
                <td>п3</td>
                <td>предмет</td>
                <td>п4</td>
                <td>предмет</td>
                <td>п5</td>
            </tr>
            <tr>
                <td>комната</td>
                <td>к1</td>
                <td>комната</td>
                <td>к2</td>
                <td>комната</td>
                <td>к3</td>
                <td>комната</td>
                <td>к4</td>
                <td>комната</td>
                <td>к5</td>
            </tr>
            <tr>
                <td>преподаватель</td>
                <td>п1</td>
                <td>преподаватель</td>
                <td>п2</td>
                <td>преподаватель</td>
                <td>п3</td>
                <td>преподаватель</td>
                <td>п4</td>
                <td>преподаватель</td>
                <td>п5</td>
            </tr>
            -->
        </table>
        </div>  
    </div>
    
  </body> 
</html>

