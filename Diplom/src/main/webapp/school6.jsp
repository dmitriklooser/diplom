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
              <input type="hidden" name="step" id="step" value="STEP6"/>
              <input type="hidden" name="action" id="action" value=""/>
             <div class="leftCtrl">
                 <p><font size="5">Для каждой аудитории заполните поля номер комнаты, вместимость, укажите ее тип и нажмите "сохранить"</font><br>
                 <p><font size="5">№ комнаты:</font><br>
                 <input name="item1" id="item1" type="text" value=""><br/>
                 <p><font size="5">Вместимость:</font><br>
                 <input name="item2" id="item2" type="text" value=""><br/>
                 <p><font size="5">Тип аудитории:</font><br>
                 <input name="item3" id="item3" type="radio"> Аудитория <br/> 
                 <input name="item3" id="item3" type="radio"> Лаборатория <br/> 
                 <input name="item3" id="item3" type="radio"> Спортзал <br/>
                 <input name="item3" id="item3" type="radio"> Компьютерный класс <br/><br/><br/>
                 <input name="item4" id="item4" type="submit" value="Добавить">
             </div>
                                            
              <div class="rightCtrl">
                 <p><font size="5">Текущие комнаты:</font><br>
                 <p><font size="5">№ группы:&nbsp&nbsp вместимость: &nbsp&nbsp&nbsp&nbsp&nbsp тип аудитории:</font>
                 <div class="scroll">
                 <table width="550" border="2" align="center" cellpadding="4" cellspacing="0">
                <tr>
                <th width="100">1</th>
                <th width="100">20</th>
                <th width="350">математика</th>
                <th><input name="item7" id="item7" type="checkbox"><br/></th>
                </tr>
                <tr>
                <td align="center">1</td>
                <td align="center">20</td>
                <td align="center">математика</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">1</td>
                <td align="center">20</td>
                <td align="center">математика</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">1</td>
                <td align="center">20</td>
                <td align="center">математика</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">1</td>
                <td align="center">20</td>
                <td align="center">математика</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">1</td>
                <td align="center">20</td>
                <td align="center">математика</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">1</td>
                <td align="center">20</td>
                <td align="center">математика</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">1</td>
                <td align="center">20</td>
                <td align="center">математика</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                <tr>
                <td align="center">1</td>
                <td align="center">20</td>
                <td align="center">математика</td>
                <td align="center"><input name="item7" id="item7" type="checkbox"><br/></td>
                </tr>
                
                </table>
                </div>
                <br/>
                 <div class="right">
                 <input name="item13" id="item13" type="submit" value="удалить отмеченные"></div><br/><br/>
                 <input name="item5" id="item5" type="submit" value="Далее"><br/><br/><br/>
                 <input name="item6" id="item6" type="submit" value="Выйти"><br/>
                          
              </div>               
            </form>
        </div>  

    </div>
    
    <div class="footer">
    </div>
    
    
  </body> 
</html>

