package hearth.stolen.event;

/**
 * Created by eggcanfly on 15/11/1.
 */
public abstract class BattleEventListener<T extends BattleEvent>{

   public abstract void on(T event);

}
