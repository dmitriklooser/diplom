<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Школьное расписание</title>
  </head>
  
  <body>
    <div class="header"><p class="stroke" align="center"><font size="8" color="c6fbb3" face="Arial">Просмотр нового расписания</font></p>
    </div>
    <div class="body">
        <div class="form">
            <form action="" method="post">
             <div class="leftCtrl">
                 <p><font size="5">Расписание составлено! Выберите номер группы и нажмите "далее"</font><br>                 
                
             </div>
                                            
              <div class="rightCtrl">
                 <p><font size="5">№ группы:</font>
                 <select name="group">
                  <option value="1" selected>1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                </select>
                <br>
                 <input name="item15" id="item15" type="submit" value="Далее"><br/><br/><br/>
                 <input name="item16" id="item16" type="submit" value="Выйти"><br/>
                          
              </div>               
            </form>
            <table width="900" border="3" align="center" cellpadding="4" cellspacing="0">
            <tr>
                <th colspan=11>Группа номер</th>
            </tr>
            <tr>
                <th width="600">время\день недели</th>
                <th colspan=2>понедельник</th>
                <th colspan=2>вторник</th>
                <th colspan=2>среда</th>
                <th colspan=2>четверг</th>
                <th colspan=2>пятница</th>
            </tr>
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
        </table>
        </div>  
    </div>
    
  </body> 
</html>

