/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xsocket.server;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import org.noear.socketd.transport.core.EntityMetas;
import org.noear.socketd.transport.core.entity.EntityDefault;

@BA.ShortName("xEntityMetas")
public class xEntityMetas implements EntityMetas {    
    
    public String META_DATA_DISPOSITION_FILENAME = "META_DATA_DISPOSITION_FILENAME";
    
    public String getMeta(String metaName) {
        if (metaName == "META_DATA_DISPOSITION_FILENAME") {
            return EntityMetas.META_DATA_DISPOSITION_FILENAME;
        } else {
            return "";
        }
    }
}
