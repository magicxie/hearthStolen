package hearth.stolen.event.listener;

import hearth.stolen.creature.action.Action;
import hearth.stolen.event.BattleEventListener;
import hearth.stolen.event.BattleEventType;
import hearth.stolen.event.impl.DeathEvent;

import java.util.List;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class DeathEventListener extends BattleEventListener<DeathEvent> {

    @Override
    public void on(DeathEvent event) {

        List<Action> deathActions = event.getTriggerBy().getDeathActions();

        if(deathActions != null){

            for(Action action : deathActions){
                action.act(event.getTriggerBy());
            }
        }




    }


}
