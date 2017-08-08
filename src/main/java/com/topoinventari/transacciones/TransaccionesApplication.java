package com.topoinventari.transacciones;


import com.topoinventari.transacciones.resources.TransactionResource;
import io.dropwizard.Application;
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
        // nothing to do yet
    }

    @Override
    public void run(TransaccionesConfiguration configuration, Environment environment) {

        TransactionResource transactionResource = new TransactionResource();

        //Tell dropwizard to setup my resource
        environment.jersey().register(transactionResource);

    }
}
