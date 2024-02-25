package States;

import game.Game;
import game.Handler;

import java.awt.*;


    public abstract class State
    {

        private static State previousState  = null;
        private static State currentState   = null;
        protected Handler handler;
        public State(Handler handler)
        {
            this.handler=handler;
        }


        public static void setState(State state)
        {

            previousState = currentState;
            currentState = state;
        }

        public static State getState()
        {
            return currentState;
        }


        public abstract void update();

        public abstract void render(Graphics g);



}
