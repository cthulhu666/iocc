package com.gluszecki.iocc.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.gluszecki.iocc.Container;
import com.gluszecki.iocc.ContainerImpl;
import com.gluszecki.iocc.context.ConversationContext;
import com.gluszecki.iocc.context.SessionContext;

public class ContainerListener implements HttpSessionListener,
		ServletContextListener {

	private Container container;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		container.stop();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		container = new ContainerImpl();
		container.start();
	}

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		HttpSession session = e.getSession();
		
		SessionContext sessionContext = new SessionContext();
		session.setAttribute("sessionContext", sessionContext);
		
		ConversationContext conversationContext = new ConversationContext();
		session.setAttribute("conversationContext", conversationContext);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		// TODO Auto-generated method stub

	}

}
