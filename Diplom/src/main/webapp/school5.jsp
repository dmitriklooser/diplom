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
                 <p><font size="5">Для каждой дисциплины выберите аудиторию, в которой она может проводиться и нажмите "сохранить"</font><br>
                 <p><font size="5">Дисциплины:</font><br>
                 <select name="subjects">
                  <option value="inf" selected>Информатика</option>
                  <option value="mat">Математика</option>
                  <option value="ang">Английский яз.</option>
                  <option value="his">История</option>
                  <option value="hem">Химия</option>
                  <option value="phy">Физкультура</option>
                  <option value="eco">Экология</option>
                  <option value="rus">Русский яз.</option>
                  <option value="dra">Черчение</option>
                </select>
                <p><font size="5">Типы аудиторий:</font><br>
                 <input name="item2" id="item2" type="radio"> Аудитория <br/> 
                 <input name="item2" id="item2" type="radio"> Лаборатория <br/> 
                 <input name="item2" id="item2" type="radio"> Спортзал <br/>
                 <input name="item2" id="item2" type="radio"> Компьютерный класс <br/><br/><br/>
                 <input name="item3" id="item3" type="submit" value="Сохранить">
                                
             </div>
                                            
              <div class="rightCtrl">
                 <p><font size="5">Требуемые аудитории:</font><br>
                 <p><font size="5">Дисциплины: <span style='padding-left:120px;'></span> Типы аудиторий:</font>
                 <div class="scroll">
                 <table width="550" border="2" align="center" cellpadding="4" cellspacing="0">
                <tr>
                <th width="225">Информатика</th>
                <th width="225">Компьютерный класс</th>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">Информатика</td>
                <td align="center">Компьютерный класс</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">Информатика</td>
                <td align="center">Компьютерный класс</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">Информатика</td>
                <td align="center">Компьютерный класс</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">Информатика</td>
                <td align="center">Компьютерный класс</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">Информатика</td>
                <td align="center">Компьютерный класс</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">Информатика</td>
                <td align="center">Компьютерный класс</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">Информатика</td>
                <td align="center">Компьютерный класс</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">Информатика</td>
                <td align="center">Компьютерный класс</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                </table>                 
                </div>
                <br/>
                 <div class="right">
                 <input name="item13" id="item13" type="submit" value="удалить отмеченные"></div><br/><br/>
                 <input name="item4" id="item4" type="submit" value="Далее"><br/><br/><br/>
                 <input name="item5" id="item5" type="submit" value="Выйти"><br/>
                                           
              </div>               
            </form>
        </div>  

    </div>
    
    <div class="footer">
    </div>
    
    
  </body> 
</html>

