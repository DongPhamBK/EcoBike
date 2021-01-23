package com.ebr;

import com.ebr.service.BikeService;
import com.ebr.service.RentService;
import com.ebr.service.UserService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.ebr.service.StationService;

// thiet lap ket noi server va database
public class EBRServer {
	public static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		Server jettyServer = new Server(PORT);
		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);

		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
				StationService.class.getCanonicalName() + "," +
						BikeService.class.getCanonicalName() + "," +
						RentService.class.getCanonicalName() + "," +
						UserService.class.getCanonicalName());
		// cho nay them cac class lien quan den xe, thanh toan

		try {
			jettyServer.start();
			jettyServer.join();
		} catch (Exception e) {
			jettyServer.stop();
			jettyServer.destroy();
		} finally {
			jettyServer.destroy();
		}
	}
}