package com.yiyang.sevice.appointment;


import com.yiyang.dao.ObjectDao;
import com.yiyang.model.appointment.Appointment;

public class AppointmentService {

	public boolean add(Appointment appointment)
	{
        try 
        {  
        	ObjectDao<Appointment> objectDao = new ObjectDao<Appointment>();
        	objectDao.saveT(appointment);
        	return true;
        } catch (Exception e) {  
            e.printStackTrace();
            return false;
        } 
	}
}
