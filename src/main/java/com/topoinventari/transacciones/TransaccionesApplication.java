package com.topoinventari.transacciones;


import com.topoinventari.transacciones.controllers.TransactionApi;
import com.topoinventari.transacciones.controllers.TransactionController;
import com.topoinventari.transacciones.controllers.UsersController;
import com.topoinventari.transacciones.services.TransactionService;
import com.topoinventari.transacciones.services.UserService;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TransaccionesApplication extends Application<TransaccionesConfiguration> {
//Alt + intro per desplegar ho de sugerencias de errores

	public static void main(String[] args) throws Exception {
		new TransaccionesApplication().run(args);
	}

	@Override
	public String getName() {
		return "Transactions";
	}

	@Override
	public void initialize(Bootstrap<TransaccionesConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets/", "/assets/"));
	}

	@Override
	public void run(TransaccionesConfiguration configuration, Environment environment) {

		/**
		 * The services that we need
		 * */
		TransactionService transactionService = new TransactionService();
		UserService userService = new UserService();

		/**
		 * Controllers
		 * */
		TransactionController transactionController = new TransactionController(transactionService);
		UsersController usersController = new UsersController(userService);

		/**
		 * APIs
		 * */
		TransactionApi transactionApi = new TransactionApi(transactionService);

		/**
		 * Setup controllers and api to dropwizard
		 * */
		//Controllers
		environment.jersey().register(transactionController);
		environment.jersey().register(usersController);

		//API
		environment.jersey().register(transactionApi);


	}
}
