package daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import util.HibernateUtil;
import actionForm.Admin_EmpChPW;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Admin_EmpChPW_DaoImpl.class, HibernateUtil.class, SessionFactory.class, Session.class, Admin_EmpChPW.class}) 
public class Admin_EmpChPW_DaoImplTest {

	@Test
	public final void testchangepw() {
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Query mockQuery =PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenReturn(mockQuery);
		PowerMockito.when(mockQuery.executeUpdate()).thenReturn(Integer.valueOf("1"));
		Admin_EmpChPW adminAddEmp= new Admin_EmpChPW();
		adminAddEmp.setBank_id("111");
		adminAddEmp.setNewpw("password");
		Admin_EmpChPW_DaoImpl admin_ClientChPW_DaoImpl = new Admin_EmpChPW_DaoImpl();
		Admin_EmpChPW addEmp = admin_ClientChPW_DaoImpl.changepw(adminAddEmp);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	
	
	@Test
	public final void testchangepwExceptionHandled() {
	
		PowerMockito.mockStatic(HibernateUtil.class);
		SessionFactory mocksessionFactory = PowerMockito.mock(SessionFactory.class);
		Session mockSession = PowerMockito.mock(Session.class);
		Transaction mockTransaction = PowerMockito.mock(Transaction.class);
		
		PowerMockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
		PowerMockito.when(HibernateUtil.getSessionFactory()).thenReturn(mocksessionFactory);
		PowerMockito.when(mocksessionFactory.getCurrentSession()).thenReturn(mockSession);
		PowerMockito.when(mockSession.getTransaction()).thenReturn(mockTransaction);
		
		Query mockQuery =PowerMockito.mock(Query.class);
		PowerMockito.when(mockSession.createQuery(Mockito.anyString())).thenThrow(new HibernateException("exception handled"));
		PowerMockito.when(mockQuery.executeUpdate()).thenReturn(Integer.valueOf("1"));
		Admin_EmpChPW adminAddEmp= new Admin_EmpChPW();
		adminAddEmp.setBank_id("111");
		adminAddEmp.setNewpw("password");
		Admin_EmpChPW_DaoImpl admin_ClientChPW_DaoImpl = new Admin_EmpChPW_DaoImpl();
		Admin_EmpChPW addEmp = admin_ClientChPW_DaoImpl.changepw(adminAddEmp);
		
		Assert.assertNotNull("Admin Object is not null", addEmp);
		
	}
	

}
