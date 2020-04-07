package fr.redstom.betterpluginsapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;

public abstract class BetterEventExecutor<T extends Event> implements EventExecutor, Listener {

    /**
     *
     * @param event Event who has executed. Extends {@link Event}
     */
    public abstract void run(T event);

    @Override
    @SuppressWarnings("unchecked")
    public void execute(Listener listener, Event event) throws EventException {
        if(event != null){
            run((T) event);
        }
    }
}
