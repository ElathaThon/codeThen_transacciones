package com.topoinventari.transacciones.util;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by elatha on 12/8/17.
 */
public class MustacheUtil {

    private static final MustacheFactory mf = new DefaultMustacheFactory();
    private static final String templateDirectory = "templates/mustache";

    /**
     * Takes template and subtitute the placehoders {{}} for the values.
     * The value can be a collection, a map or another object (getters will be used).
     * */
    public static String processTemplate(String filename, Object value) {

        Mustache mustache = mf.compile(templateDirectory + filename + ".mustache");
        StringWriter writer = new StringWriter();

        try {
            mustache.execute(writer, value).flush();
            return writer.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error while writing template result", e);
        }

    }


}
