package action;

import base.GameObject;

public class RepeatCountAction implements Action {

    private Action action;
    private  int count = 0;
    private int max;

    public  RepeatCountAction(Action action, int max){
        this.action = action;
        this.max = max;
    }
    @Override
    public boolean run(GameObject owner) {
        if (this.action.run(owner)){
            this.count += 1;
            this.action.reset();
        }
        return this.count == this.max;
    }

    @Override
    public void reset() {

    }
}
