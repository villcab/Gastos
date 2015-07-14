package com.villcab.gastos.utils.model;

import android.util.Log;

import com.villcab.gastos.utils.App;
import com.villcab.gastos.utils.model.annotations.Ignored;

import java.io.Serializable;

public class Entity implements Serializable, Cloneable {

    @Ignored
    private Action action = Action.NONE;

    public Action getAction() {
        return this.action;
    }

    public void setAction(Action value) {
        this.action = value;
    }

    public <T extends Entity> T getClone() {
        Entity obj = null;
        try {
            obj = (Entity) super.clone();
        } catch (CloneNotSupportedException e) {
            Log.e(App.TAG, e.getMessage());
        }

        return (T) obj;
    }

    public <T extends Entity> T getMe() {
        return (T) this;
    }

}
