package hu.exth.l4tgt.model.Trigger;

import hu.exth.l4tgt.model.Map.Map;

import java.util.List;


public class Trigger {
    private List<TriggerSubElement> subElementList;
    private int id;

    private void run(Map map){
        for(TriggerSubElement tse: subElementList){
            tse.run(map);
        }
    }
}
