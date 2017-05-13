package org.leftchildren.enums;


/**
 * Created by kay on 2017/5/1.
 */
public enum ApplyStatEnum {
    SUCCESS(1,"审核通过"),
    APPLYING(0,"审核中"),
    FAIl(-1,"审核未通过");

    private int state;

    private String stateInfo;

    ApplyStatEnum(int state, String stateInfo) {
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

    public static ApplyStatEnum stateOf(int index){
        for(ApplyStatEnum state : values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }

}
