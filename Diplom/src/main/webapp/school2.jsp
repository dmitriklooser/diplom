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
            <form action="" method="post">
             <div class="leftCtrl">
                <p><font size="5">Поставьте галочки напротив дня недели и времени, выделенных для занятий и нажмите "сохранить".</font><br/><br/><br/>
                <table width="100" border="2" align="center" cellpadding="4" cellspacing="0">
                <tr>
                <th width="600">время\день недели</th>
                <th>понедельник</th>
                <th>вторник</th>
                <th>среда</th>
                <th>четверг</th>
                <th>пятница</th>
                <th>суббота</th>
                </tr>
                <tr>
                <td>9:00</td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td>11:00</td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td>13:00</td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td>15:00</td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td>17:00</td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                <td><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                </table>              
              </div>
                <br/>             
              <div class="rightCtrl">
                  <input name="item12" id="item12" type="submit" value="Сохранить"><br/><br/><br/>
                  <input name="item13" id="item13" type="submit" value="Далее"><br/><br/><br/>
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

