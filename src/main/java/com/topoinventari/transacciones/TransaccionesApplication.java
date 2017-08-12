package com.topoinventari.transacciones;


import com.topoinventari.transacciones.controllers.TransactionController;
import com.topoinventari.transacciones.controllers.UsersController;
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
        bootstrap.addBundle(new AssetsBundle("/assets/","/files"));
    }

    @Override
    public void run(TransaccionesConfiguration configuration, Environment environment) {

        TransactionController transactionController = new TransactionController();
        UsersController usersController = new UsersController();

        //Tell dropwizard to setup my resource
        environment.jersey().register(transactionController);
        environment.jersey().register(usersController);


    }
}
