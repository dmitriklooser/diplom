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
    <div class="header"><p class="stroke" align="center"><font size="8" color="c6fbb3" face="Arial">Подготовка нового расписания</font></p>
    </div>
    <div class="body">
        <div class="form">
            <form action="main" method="post" name="mainForm" id="mainForm">
            <input type="hidden" name="step" id="step" value="STEP3"/>
            <input type="hidden" name="action" id="action" value=""/>
            
             <div class="leftCtrl">
                <p><font size="5">Заполните поля номер, количество учеников для каждой группы. Поставьте галочки напротив предметов, которые изучает группа и нажмите "сохранить"</font><br>
                <p><font size="5">№ группы:</font><br>
                <input name="grpName" id="grpName" type="text" value=""><br/>
                <p><font size="5">Количество учеников:</font><br>
                <input name="grpSize" id="grpSize" type="text" value=""><br/>
                
                <p><font size="5">Изучаемые предметы:</font><br>
                <c:forEach var="modue" items="${modules}">
                    <input name="${modue.id}" id="${modue.id}" type="checkbox"> ${modue.name} <br/>
                </c:forEach>
                 <input name="item12" id="item12" type="submit" value="Добавить" onclick="javascript:onAdd('mainForm')">
             </div>             
                                            
              <div class="rightCtrl">
                 <p><font size="5">Текущие группы:</font><br>
                 <p><font size="5">№ группы:&nbsp&nbsp количество: &nbsp&nbsp&nbsp&nbsp&nbsp предмет:</font>
                 <div class="scroll">
	                 <table width="550" border="2" align="center" cellpadding="4" cellspacing="0">
	                   <c:forEach var="gmPair" items="${gmList}">
		                    <tr>
		                    <th width="100"><c:out value="${gmPair.keyItem.id}"/></th>
		                    <th width="100"><c:out value="${gmPair.keyItem.groupSize}"/></th>
		                    <th width="350">${gmPair.groupedItem.moduleName}</th>
		                    <th><input name="gm_${gmPair.keyItem.id}_${gmPair.groupedItem.id}" id="gm_${gmPair.keyItem.id}_${gmPair.groupedItem.id}" type="checkbox"><br/></th>
		                    </tr>
                      </c:forEach>
                </table>
                </div>
                <br/>
                 <div class="right">
                 <input name="item13" id="item13" type="submit" value="удалить отмеченные" onclick="javascript:onDelete('mainForm')"></div>
                 <br/><br/><br/>
                 <input name="item13" id="item13" type="submit" value="Далее" onclick="javascript:onSubmit('mainForm');"><br/><br/><br/>
                 <input name="item14" id="item14" type="submit" value="Выйти" onclick="javascript:onReset('mainForm')"><br/>            
                <br/>
                          
              </div>               
            </form>
        </div>  

    </div>
    
    <div class="footer">
    </div>
    
    
  </body> 
</html>

