package com.uscs.common.config.utils.compare;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.omg.DynamicAny.NameValuePair;

import com.uscs.dao.DiffObject;



public class ObjectCompare {

	public  Map<String, DiffObject> compareObjects(Object firstObj, Object secondObj) {
        
        BeanMap beanmap = new BeanMap(firstObj);
        PropertyUtilsBean propUtils=new PropertyUtilsBean();
       Map<String,DiffObject> diffField = new HashMap<String,DiffObject>();
       
       
        for(Object propObject:beanmap.keySet()){
               try {
                      Object property1=propUtils.getProperty(firstObj, (String)propObject);
                      Object property2=propUtils.getProperty(secondObj, (String)propObject);
                      if(!(property1.equals(property2))){
                    	 DiffObject diffObj = new DiffObject();
                    	
                    	 	diffObj.setOldValue((String) property1 != null ? (String)property1 : "");
                    	 	diffObj.setNewValue((String) property2 != null ? (String)property2 :"");
                    	 	
                    	 	diffField.put((String)propObject, diffObj);
                         
                         
                      }
               } catch (IllegalAccessException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
               } catch (InvocationTargetException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
               } catch (NoSuchMethodException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
               }
        }
        return diffField;
	}
}
