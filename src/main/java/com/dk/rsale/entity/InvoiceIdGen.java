package com.dk.rsale.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class InvoiceIdGen extends SequenceStyleGenerator {
	 public static final String CODE_NUMBER_SEPARATOR_PARAMETER = "codeNumberSeparator";
	    public static final String CODE_NUMBER_SEPARATOR_DEFAULT = "_";
	    private String codeNumberSeparator;
	 
	    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	    public static final String NUMBER_FORMAT_DEFAULT = "%05d";
	    private String numberFormat;
	    private String format;
		@Override
		public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
			// TODO Auto-generated method stub
			super.configure(LongType.INSTANCE, params, serviceRegistry);
			codeNumberSeparator=ConfigurationHelper.getString(CODE_NUMBER_SEPARATOR_PARAMETER, params,CODE_NUMBER_SEPARATOR_DEFAULT);
			numberFormat=ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params,NUMBER_FORMAT_DEFAULT);
			this.format=codeNumberSeparator+numberFormat;
		}
		@Override
		public Serializable generate(SharedSessionContractImplementor session, Object object)
				throws HibernateException {
			 
			return  String.format(format,((Bill)object).getUser().getUsermid() ,super.generate(session, object));
		}
	    
	    
	 
		 
}
