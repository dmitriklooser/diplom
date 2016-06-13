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
            <form action="" method="post" name="mainForm" id="mainForm">
            <input type="hidden" name="step" id="step" value="STEP4"/>
            <input type="hidden" name="action" id="action" value=""/>
             <div class="leftCtrl">
                <p><font size="5">Для добавления преподавателя заполните поле ФИО. Поставьте галочки напротив предметов, которые он преподает и нажмите "сохранить"</font><br>
                <p><font size="5">ФИО преподавателя:</font><br>
                <input name="profName" id="profName" type="text" value=""><br/>
                <p><font size="5">Преподаваемые дисциплины:</font><br>
	                <c:forEach var="modue" items="${modules}">
	                    <input name="${modue.id}" id="${modue.id}" type="checkbox"> ${modue.name} <br/>
	                </c:forEach>
                <!-- 
                 <input name="item2" id="item2" type="checkbox"> Информатика <br/> 
                 <input name="item3" id="item3" type="checkbox"> Математика <br/> 
                 <input name="item4" id="item4" type="checkbox"> Английский яз. <br/> 
                 <input name="item5" id="item5" type="checkbox"> История <br/> 
                 <input name="item6" id="item6" type="checkbox"> Химия <br/> 
                 <input name="item7" id="item7" type="checkbox"> Физкультура<br/> 
                 <input name="item8" id="item8" type="checkbox"> Экология<br/> 
                 <input name="item9" id="item9" type="checkbox"> Русский яз.<br/> 
                 <input name="item10" id="item10" type="checkbox"> Черчение <br/><br/><br/>
                 -->
                 <input name="item11" id="item11" type="submit" value="Добавить" onclick="javascript:onAdd('mainForm')"><br/><br/><br/>
             </div>
                                            
              <div class="rightCtrl">
                 <p><font size="5">Текущие преподаватели:</font><br>
                 <p><font size="5">Преподаватель:<span style='padding-left:120px;'></span> дисциплина:</font>
                 <div class="scroll">
                 <table width="550" border="2" align="center" cellpadding="4" cellspacing="0">
                    <c:forEach var="pmPair" items="${pmList}">
		                <tr>
    		                <th width="225"><c:out value="${pmPair.keyItem.professorName}"/></th>
	       	                <th width="225"><c:out value="${pmPair.groupedItem.moduleName}"/></th>
		                    <td align="center"><input name="pm_${gmPair.keyItem.id}_${gmPair.groupedItem.id}" id="pm_${gmPair.keyItem.id}_${gmPair.groupedItem.id}" type="checkbox"><br/></td>
		                </tr>
                    </c:forEach>
                 <!-- 
                <tr>
                <th width="225">З.Л.Ложечкин</th>
                <th width="225">Черчение</th>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">З.Л.Ложечкин</td>
                <td align="center">Черчение</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">З.Л.Ложечкин</td>
                <td align="center">Черчение</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">З.Л.Ложечкин</td>
                <td align="center">Черчение</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">З.Л.Ложечкин</td>
                <td align="center">Черчение</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">З.Л.Ложечкин</td>
                <td align="center">Черчение</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">З.Л.Ложечкин</td>
                <td align="center">Черчение</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">З.Л.Ложечкин</td>
                <td align="center">Черчение</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">З.Л.Ложечкин</td>
                <td align="center">Черчение</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">З.Л.Ложечкин</td>
                <td align="center">Черчение</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                   -->             
                </table>
                </div>
                <br/>
                 <div class="right">
                 <input name="item13" id="item13" type="submit" value="удалить отмеченные"  onclick="javascript:onDelete('mainForm')"></div>
                 <br/><br/><br/>
                 <input name="item12" id="item12" type="submit" value="Далее" onclick="javascript:onSubmit('mainForm');"><br/><br/><br/>
                 <input name="item13" id="item13" type="submit" value="Выйти" onclick="javascript:onReset('mainForm')"><br/>            
                <br/>
                          
              </div>               
            </form>
        </div>  

    </div>
    
    <div class="footer">
    </div>
    
    
  </body> 
</html>

