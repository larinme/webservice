package templator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Map;

public class VelocityHelper {

    private final String path;
    private final Map<String, String> params;
    private String result;

    public VelocityHelper(String path, Map<String, String> params){
        this.path = path;
        this.params = params;
        
        build();
    }

    private void build() {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();


        Template template = ve.getTemplate(path);

        VelocityContext vc = new VelocityContext();
        for (Map.Entry<String, String> values : params.entrySet()) {
            vc.put(values.getKey(), values.getValue());
        }

        StringWriter sw = new StringWriter();
        template.merge(vc, sw);

        result = sw.toString();
    }

    @Override
    public String toString() {
        return result;
    }
}
