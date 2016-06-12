<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="/Diplom/styles.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Школьное расписание</title>
  </head>
  
  <body>
    <div class="header"><p class="stroke" align="center"><font size="8" color="c6fbb3" face="Arial">Подготовка нового расписания</font></p>
    </div>
    <div class="body">
        <div class="form">
            <form action="" method="post">
             <div class="leftCtrl">
                <p><font size="5">Заполните поля номер, количество учеников для каждой группы. Поставьте галочки напротив предметов, которые изучает группа и нажмите "сохранить"</font><br>
                <p><font size="5">№ группы:</font><br>
                <input name="item1" id="item1" type="text" value=""><br/>
                <p><font size="5">Количество учеников:</font><br>
                <input name="item2" id="item2" type="text" value=""><br/>
                
                <p><font size="5">Изучаемые предметы:</font><br>
                 <input name="item3" id="item3" type="checkbox"> Информатика <br/> 
                 <input name="item4" id="item4" type="checkbox"> Математика <br/> 
                 <input name="item5" id="item5" type="checkbox"> Английский яз. <br/> 
                 <input name="item6" id="item6" type="checkbox"> История <br/> 
                 <input name="item7" id="item7" type="checkbox"> Химия <br/> 
                 <input name="item8" id="item8" type="checkbox"> Физкультура<br/> 
                 <input name="item9" id="item9" type="checkbox"> Экология<br/> 
                 <input name="item10" id="item10" type="checkbox"> Русский яз.<br/> 
                 <input name="item11" id="item11" type="checkbox"> Черчение<br/><br/><br/>
                 <input name="item12" id="item12" type="submit" value="Сохранить">
                 
             </div>             
                                            
              <div class="rightCtrl">
                 <p><font size="5">Текущие группы:</font><br>
                 <p><font size="5">№ группы:&nbsp&nbsp количество: &nbsp&nbsp&nbsp&nbsp&nbsp предмет:</font>
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
                 <input name="item13" id="item13" type="submit" value="удалить отмеченные"></div>
                 <br/><br/><br/>
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

