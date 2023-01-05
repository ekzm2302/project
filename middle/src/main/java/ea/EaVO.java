package ea;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EaVO {
	private int ea_num, ea_receiver, emp_no;
	private String ea_title, ea_content, ea_status, ea_r_statuas, ea_pop, ea_read;
	private Date ea_date, ea_cdate, ea_u_date, ea_r_date;
}