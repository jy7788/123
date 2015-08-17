package com.yiyang.action.appointment;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yiyang.dao.ObjectDao;
import com.yiyang.model.appointment.Appointment;
import com.yiyang.model.order.Order;
import com.yiyang.sevice.appointment.AppointmentService;
import com.yiyang.util.Page;

public class AppointmentAction extends ActionSupport implements ModelDriven<Appointment>,ServletRequestAware{

	protected HttpServletRequest request;
	protected Appointment appointment = new Appointment();
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public AppointmentAction(){
		page=new Page();
		page.setCurrentPage(1);
		page.setPageSize(10);
	}

	public String add()
	{
		System.out.println(appointment.getRealName());
		System.out.println(appointment.getAddress());
		AppointmentService appointmentService = new AppointmentService();
		if(appointmentService.add(appointment)){
			return "success";
		}else{
			return "input";
		}
		
	}
	
	public String show(){
		String hql="from Appointment";
		hql += page.getOrderByString();
		ObjectDao<Appointment> appointmentdao=new ObjectDao<Appointment>();
		appointmentdao.search(page, hql);
		return "show";
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public Appointment getModel() {
		// TODO Auto-generated method stub
		return appointment;
	}
	
}
