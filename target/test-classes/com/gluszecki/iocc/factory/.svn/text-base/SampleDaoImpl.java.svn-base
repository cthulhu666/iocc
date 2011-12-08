package com.gluszecki.iocc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import com.gluszecki.iocc.annotation.Component;
import com.gluszecki.iocc.annotation.In;

@Component(name = "sampleDao")
public class SampleDaoImpl implements SampleDao {
	
	@In(name = "connection")
	private Connection connection;

	@Override
	public void doSomething() {
		try {
			connection.prepareStatement("select * from foo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
