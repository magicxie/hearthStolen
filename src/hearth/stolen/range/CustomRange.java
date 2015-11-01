package hearth.stolen.range;

import hearth.stolen.creature.Creature;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by eggcanfly on 15/11/1.
 */
public class CustomRange implements Range{

    private List<Creature> targets;

    public CustomRange(Creature... creature) {

        this.targets = new LinkedList<Creature>();

        for (Creature c : creature){
            this.targets.add(c);
        }

    }

    @Override
    public List<Creature> getTargets() {
        return this.targets;
    }
}
