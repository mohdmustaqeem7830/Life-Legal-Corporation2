package com.virendrasing.lifelegalcorporation.Classes;

public class UserDetail {
    String name, refferalId, agentId;

    ///Default Constructor
    public UserDetail() {

    }

    public UserDetail(String name, String refferalId, String agentId) {
        this.name = name;
        this.refferalId = refferalId;
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefferalId() {
        return refferalId;
    }

    public void setRefferalId(String refferalId) {
        this.refferalId = refferalId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
