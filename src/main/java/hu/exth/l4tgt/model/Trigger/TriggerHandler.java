package hu.exth.l4tgt.model.Trigger;


import hu.exth.l4tgt.model.Trigger.annotations.TriggerElementVariable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface TriggerHandler {
    Trigger getTriggerById(int id);
    void setTriggerElementJarPath(String path);
    Class getTriggerElementClassByName(String name);

    /**
     * For setting values in triggerSubElements
     * @param element the initialized element, that we want to set value for
     * @param values the String that contains the names of the variables and their values
     */
    public default void setValues(TriggerSubElement element,String values){
        List<String> list=Arrays.stream(values.split(";")).collect(Collectors.toList());
        Map<String,String> x=new HashMap<>();

        for(String i: list){
            x.put(StringMethods.getName(i),StringMethods.getValue(i));
        }

        for(Field f:element.getClass().getDeclaredFields()){
            if(f.isAnnotationPresent(TriggerElementVariable.class)){
                if( x.keySet().contains(f.getAnnotation(TriggerElementVariable.class).value())){
                    f.setAccessible(true);
                    try {
                        f.set(element,x.get(f.getAnnotation(TriggerElementVariable.class).value()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public default TriggerSubElement instantiateFromClassName(String name){
        try {
            return (TriggerSubElement) getTriggerElementClassByName(name).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("TriggerSubElement instantiation failed for class: "+name);
    }
}


