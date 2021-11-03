package com.dn.boot.enable_interface;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * ClassName:ServerImportSelector
 * Package:com.dn.boot.enable_interface
 * Description:
 *
 * @Date:2021/10/23 10:49
 * @Author: mark
 */
public class ServerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        Map<String,Object> annotationAttributes =
                annotationMetadata.getAnnotationAttributes(EnableServer.class.getName());
        Server.Type type = (Server.Type) annotationAttributes.get("type");
        String[] importClassNames = new String[0];
        switch (type){
            case Http:
                importClassNames = new String[]{HttpServer.class.getName()};
                break;
            case Ftp:
                importClassNames = new String[]{HttpServer.class.getName()};
                break;
        }

        return importClassNames;
    }
}
