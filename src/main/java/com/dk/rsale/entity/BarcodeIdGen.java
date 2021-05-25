package com.dk.rsale.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class BarcodeIdGen extends SequenceStyleGenerator {

	public static final String DATE_FORMAT_PARAMETER = "dateFormat";
    public static final String DATE_FORMAT_DEFAULT = "%tY";
    private String dateFormat;
 
    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%05d";
    private String numberFormat;
    public static final String DATE_NUMBER_SEPARATOR_PARAMETER = "dateNumberSeprator";
    public static final String DATE_NUMBER_SEPARATOR_DEFAULT = "";
    private String  dateNumberSeprator;
    private String format;
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		// TODO Auto-generated method stub
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		dateFormat=ConfigurationHelper.getString(DATE_FORMAT_PARAMETER, params,DATE_FORMAT_DEFAULT).replace("%", "%1$");
		numberFormat=ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params,NUMBER_FORMAT_DEFAULT).replace("%", "%2$");
		dateNumberSeprator=ConfigurationHelper.getString(DATE_NUMBER_SEPARATOR_PARAMETER, params,DATE_NUMBER_SEPARATOR_DEFAULT);
		this.format=dateFormat+dateNumberSeprator+numberFormat;
	}
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object)
			throws HibernateException {
		// TODO Auto-generated method stub
		return  String.format(format,LocalDate.now(),super.generate(session, object));
	}
    
	
}
