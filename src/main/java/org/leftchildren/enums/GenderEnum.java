package org.leftchildren.enums;

/**
 * Created by kay on 2017/5/2.
 */
public enum GenderEnum {
    MAN(1,"男"),
    FEMALE(0,"女");

    private int state;

    private String stateInfo;

    GenderEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public static GenderEnum stateOf(int index){
        for(GenderEnum state : values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
