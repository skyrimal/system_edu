package com.education.system_edu.pojo.output;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月11日 13:01
 */
public class HomMsgsAndTeanMsgs {
    private List<HomworkMsg> homworkMsgs;
    private List<TeamMsg> teamMsgs;

    public List<HomworkMsg> getHomworkMsgs() {
        return homworkMsgs;
    }

    public void setHomworkMsgs(List<HomworkMsg> homworkMsgs) {
        this.homworkMsgs = homworkMsgs;
    }

    public List<TeamMsg> getTeamMsgs() {
        return teamMsgs;
    }

    public void setTeamMsgs(List<TeamMsg> teamMsgs) {
        this.teamMsgs = teamMsgs;
    }
}
