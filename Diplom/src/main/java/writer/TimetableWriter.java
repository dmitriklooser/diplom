package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import geneticalg.Clazz;
import geneticalg.Group;
import geneticalg.Timetable;





public class TimetableWriter {
	private final String F_NAME = "C:/Users/Dmitry/Desktop/tabl.html";
	private FileWriter writer;
	private final ArrayList<String> moduleList = new ArrayList<>();
	private final ArrayList<Integer> groupList = new ArrayList<>();
	private final ArrayList<String> roomList = new ArrayList<>();
	private final ArrayList<String> professorList = new ArrayList<>();
	private final ArrayList<LocalTime> timeList = new ArrayList<>();
	private final ArrayList<DayOfWeek> weekList = new ArrayList<>();
	
private void Header () {
	
}
//Заполняем нашу модель данных из timetable.(класс Lesson). Возвращаем Map  сгруппированными списки уроков по группам. Каждой группы соостветствует свой список Lesson-ов.
    public Map<Group, List<Lesson>> fillLessons(Timetable tTbl){
        Clazz[] classes = tTbl.getClasses();
        List<Clazz> clsList = Arrays.asList(classes); //превращаем массив в коллекцию List
        Map<Group, List<Lesson>> groupLessons = new HashMap<>(); //map - структура, в которой каждому ключу соответствует свое значение
        for(int i = 0; i < clsList.size(); i++){
            Clazz cls = clsList.get(i);
            Group group = tTbl.getGroup(cls.getGroupId());
            List<Lesson> lessons = groupLessons.get(group);// из map берем по ключу(по группе) список уроков
            if(lessons == null){
                lessons = new ArrayList<>();// если к ключу нет ничего, то создаем новый список 
                groupLessons.put(group, lessons);//и добавляем его в map с этим ключом(группой)
            }
            ModRoomTeach mrt = new ModRoomTeach();
            mrt.setModule(tTbl.getModule(cls.getModuleId()));// set - заполнение
            mrt.setRoom(tTbl.getRoom(cls.getRoomId()));
            mrt.setProfessor(tTbl.getProfessor(cls.getProfessorId()));
            Lesson lesson = new Lesson();
            lesson.setModRoomTeach(mrt);
            lesson.setDayOfWeek(tTbl.getTimeslot(cls.getTimeslotId()).getDay());
            lesson.setLocalTime(tTbl.getTimeslot(cls.getTimeslotId()).getTime());
            lessons.add(lesson);// заносим lesson(урок) в lessons(список, который хранится с ключом-группой в map)
        }
        return groupLessons;
    }
        
    //фильтрация уроков по времени конкретной группы
    private List<Lesson> filterByLessonStart(List<Lesson> lessons, LocalTime start){
        return lessons.stream()
                      .filter((lesson)->lesson.getLocalTime().equals(start))
                      .collect(Collectors.toList());
    }
    

	public void write(Group group, List<Lesson> lessons){
		//Collections.sort(lessons, Lesson.BY_DAY_COMPARATOR);
		//
		Set<LocalTime> lessonStartSet = lessons.stream() //каждый lesson попадает в map(не хранилище, а метод, преобразующий каждый лессон, попадающий в stream в LocalTime)
                            		           .map((lesson)->lesson.getLocalTime())
                            		           .collect(Collectors.toSet());//терминальная операция. Собирает в Set(коллекция уникальных значений).
		List<LocalTime> lessonStarts = new ArrayList<>(lessonStartSet);//преобразуем в arraylist для сортировки
		Collections.sort(lessonStarts);//сортируем
		for(LocalTime lessonStart : lessonStarts){
		    List<Lesson> currentLessons = filterByLessonStart(lessons, lessonStart);//фильтруем уроки по временам
		    Collections.sort(currentLessons, Lesson.BY_DAY_COMPARATOR);//сортировка по дням недели
		    
		}
		
		
		
		try{
				StringBuilder buf = new StringBuilder();
				buf.append("<html>\n <head>\n <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n "
						+ "<title>school timetable</title>\n </head>\n <body>\n <table width=\"900\" border=\"3\" align=\"center\" cellpadding=\"4\" cellspacing=\"0\">\n <tr>\n");
				
				
				buf.append("<th colspan=11>group" + groupList.get(3) + "</th>\n </tr>\n "
						+ "<tr>\n	<th width=\"600\">time\\week</th>\n <th colspan=2>mon</th>\n <th colspan=2>tue</th>\n"
						+ " <th colspan=2>wen</th>\n <th colspan=2>thu</th>\n <th colspan=2>fri</th>\n </tr>\n ");
				
//				for (int i = 0; i < moduleList.size(); i++) {
//					
//					if (groupList.get(i) == groupList.get(3)){
////					buf.append("<th colspan=11>group" + groupList.get(i) + "</th>\n </tr>\n "
////							+ "<tr>\n	<th width=\"600\">time\\week</th>\n <th colspan=2>mon</th>\n <th colspan=2>tue</th>\n"
////							+ " <th colspan=2>wen</th>\n <th colspan=2>thu</th>\n <th colspan=2>fri</th>\n </tr>\n ");
//					if (timeList.get(i) == Collections.min(timeList)){
//					buf.append("<tr>\n <td rowspan=3>" + timeList.get(i) + "</td>\n	<td>subject</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.MONDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n <td>subject</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.TUESDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n <td>subject</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.WEDNESDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n	<td>subject</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.THURSDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n <td>subject</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.FRIDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n	</tr>\n <tr>\n	<td>room</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.MONDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n <td>room</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.TUESDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n <td>room</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.WEDNESDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n	<td>room</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.THURSDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n <td>room</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.FRIDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n </tr>\n <tr>\n	<td>teacher</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.MONDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n <td>teacher</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.TUESDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n <td>teacher</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.WEDNESDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n	<td>teacher</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.THURSDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n <td>teacher</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.FRIDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n </tr>\n");
//					}
//					if (timeList.get(i) != Collections.min(timeList) && timeList.get(i) != Collections.max(timeList)){
//					buf.append("<tr>\n <td rowspan=3>" + timeList.get(i) + "</td>\n	<td>subject</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.MONDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n <td>subject</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.TUESDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n <td>subject</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.WEDNESDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n	<td>subject</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.THURSDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n <td>subject</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.FRIDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n	</tr>\n <tr>\n	<td>room</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.MONDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n <td>room</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.TUESDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n <td>room</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.WEDNESDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n	<td>room</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.THURSDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n <td>room</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.FRIDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n </tr>\n <tr>\n	<td>teacher</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.MONDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n <td>teacher</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.TUESDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n <td>teacher</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.WEDNESDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n	<td>teacher</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.THURSDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n <td>teacher</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.FRIDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n </tr>\n");
//					}
//					if (timeList.get(i) == Collections.max(timeList)){
//					buf.append("<tr>\n <td rowspan=3>" + timeList.get(i) + "</td>\n	<td>subject</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.MONDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n <td>subject</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.TUESDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n <td>subject</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.WEDNESDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n	<td>subject</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.THURSDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n <td>subject</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.FRIDAY){buf.append( moduleList.get(i) );}
//					buf.append("</td>\n	</tr>\n <tr>\n	<td>room</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.MONDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n <td>room</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.TUESDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n <td>room</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.WEDNESDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n	<td>room</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.THURSDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n <td>room</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.FRIDAY){buf.append( roomList.get(i) );}
//					buf.append("</td>\n </tr>\n <tr>\n	<td>teacher</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.MONDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n <td>teacher</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.TUESDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n <td>teacher</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.WEDNESDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n	<td>teacher</td>\n	<td>");
//					if (weekList.get(i) == DayOfWeek.THURSDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n <td>teacher</td>\n <td>");
//					if (weekList.get(i) == DayOfWeek.FRIDAY){buf.append( professorList.get(i) );}
//					buf.append("</td>\n </tr>\n");
//					}
//					}
//				}
								
				buf.append("</table>\n </body>\n </html>");
				buf.toString();
				
//				System.out.println(buf);
//				System.out.println(moduleList);
//				System.out.println(groupList);
//				System.out.println(roomList);
//				System.out.println(professorList);
//				System.out.println(timeList);
//				System.out.println(weekList);
				
				writer = new FileWriter(new File(F_NAME));
						writer.write(buf.toString());
				
				/*writer = new FileWriter(new File(F_NAME));
				Arrays.asList(tTbl.getClasses()).forEach((cls)->{
					try{
						writer.write("Module " + tTbl.getModule(cls.getModuleId()).getModuleName() + "\n");
						writer.write("Group " + tTbl.getGroup(cls.getGroupId()).getGroupId() + "\n");
						writer.write("Room " + tTbl.getRoom(cls.getRoomId()).getRoomNumber() + "\n");
						writer.write("Professor " + tTbl.getProfessor(cls.getProfessorId()).getProfessorName() + "\n");
						writer.write("Time " + tTbl.getTimeslot(cls.getTimeslotId()).getTimeslot() + "\n");
						writer.write("---------------" + "\n");
						
					}catch(IOException ex){
						ex.printStackTrace(System.err);
					}
				}); */
		}catch(IOException ex){
			ex.printStackTrace(System.err);
		}finally{
			try{
				writer.flush();
				writer.close();
			}catch(IOException ex){}
		}
	}
}
