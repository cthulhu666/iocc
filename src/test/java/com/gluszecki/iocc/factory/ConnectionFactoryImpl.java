/**
 * 
 */
package com.gluszecki.iocc.factory;

import java.sql.Connection;

import org.easymock.EasyMock;

import com.gluszecki.iocc.annotation.Component;
import com.gluszecki.iocc.annotation.Factory;

/**
 * @author cthulhu
 *
 */
@Component(name = "connectionFactory")
public class ConnectionFactoryImpl implements ConnectionFactory {

	@Override
	@Factory(name = "connection")
	public Connection getConnection() {
		return EasyMock.createMock(Connection.class);
	}
}