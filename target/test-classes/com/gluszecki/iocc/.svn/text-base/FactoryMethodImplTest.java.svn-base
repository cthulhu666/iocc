/**
 * 
 */
package com.gluszecki.iocc;

import java.sql.Connection;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gluszecki.iocc.component.Component;
import com.gluszecki.iocc.component.Components;
import com.gluszecki.iocc.component.TwoStageInit;
import com.gluszecki.iocc.factory.ConnectionFactory;
import com.gluszecki.iocc.factory.ConnectionFactoryImpl;

/**
 * @author cthulhu
 * 
 */
public class FactoryMethodImplTest {

	@Test
	public void testExecute() throws Exception {
		Component<ConnectionFactoryImpl> component = Components.instance()
				.newInstance(ConnectionFactoryImpl.class);
		((TwoStageInit) component).firstStageInit();
		((TwoStageInit) component).secondStageInit();
		ConnectionFactory connectionFactory = component.newInstance();
		FactoryMethodImpl factoryMethod = new FactoryMethodImpl("getConnection",
				component);

		Connection connection = (Connection) factoryMethod.execute(connectionFactory);
		Assert.assertNotNull(connection);
	}

}
