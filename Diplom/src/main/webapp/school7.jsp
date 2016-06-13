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
             <input type="hidden" name="step" id="step" value="STEP7"/>
             <input type="hidden" name="action" id="action" value=""/>
             <div class="leftCtrl">
                 <p><font size="5">Расписание почти составлено. Выберите "сгенерировать новое расписание" </font><br>                                
                
             </div>
                                            
              <div class="rightCtrl">
                 <input name="item15" id="item15" type="submit" value="сгенерировать новое расписание" onclick="javascript:onSubmit('mainForm');"><br/><br/><br/>
                 <input name="item16" id="item16" type="submit" value="Выйти"  onclick="javascript:onReset('mainForm')"><br/>
                          
              </div>               
            </form>
        </div>  

    </div>
    
    <div class="footer">
    </div>
    
    
  </body> 
</html>

