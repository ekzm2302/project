package co.kr.jkcompany;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import common.CommonService;
import employee.EmployeeVO;
import schedule.ScheduleVO;


@Controller
public class ScheduleController {
	@Autowired @Qualifier("hanul")
	SqlSession sql;
	@Autowired
	private CommonService common;


	@RequestMapping(value= "/list.sche" , produces="text/html;charset=utf-8")
	public String emp_list(HttpSession session, Model model) {
		
		//각 컨트롤러 입장 메소드는 category에 속성을 넣어주세요!
		session.setAttribute("cate", "sche" );

		
		EmployeeVO info = common.tempLogin("3");
		
		//임시로그인
		session.setAttribute("loginInfo", info);
		
		model.addAttribute("countCompany",sql.selectOne("sche.countCompPeriod"));
		model.addAttribute("countDept",sql.selectOne("sche.countDeptPeriod",info.getEmp_no()));
		model.addAttribute("countPersonal",sql.selectOne("sche.countPeriodPersional",info.getEmp_no()));
		sql.selectList("sche.compPeriod");
		return "schedule/list";
	}
	
	
	@ResponseBody
	@RequestMapping(value= "/calendars" , produces="text/html;charset=utf-8")
	public String calendars(HttpSession session, Model model,String id) {
		return new Gson().toJson(getEventList(id));
	}
	

	public List<Map<String, Object>> getEventList(String id) {
		List<ScheduleVO> company = sql.selectList("sche.compPeriod");
		List<ScheduleVO> department = sql.selectList("sche.deptbyId",id);		
		List<ScheduleVO> personal = sql.selectList("sche.personalbyId",id);		
        List<Map<String, Object>> eventList = new ArrayList<Map<String, Object>>();
        
        for (ScheduleVO each : company) {
        	Map<String, Object> event = new HashMap<String, Object>();
        	event.put("start", each.getSche_start());
            event.put("title", each.getSche_title());
            event.put("end",each.getSche_end());
            event.put("color","#00FF00");
            eventList.add(event);
		}
        for (ScheduleVO each : department) {
        	Map<String, Object> event = new HashMap<String, Object>();
        	event.put("start", each.getSche_start());
            event.put("title", each.getSche_title());
            event.put("end",each.getSche_end());
            event.put("color","#FF0000");
            eventList.add(event);
		}
        for (ScheduleVO each : personal) {
        	Map<String, Object> event = new HashMap<String, Object>();
        	event.put("start", each.getSche_start());
            event.put("title", each.getSche_title());
            event.put("end",each.getSche_end());
            event.put("color","#0000FF");
            eventList.add(event);
		}
        return eventList;
    }
}
