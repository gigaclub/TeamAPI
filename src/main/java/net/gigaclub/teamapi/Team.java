package net.gigaclub.teamapi;

import net.gigaclub.base.odoo.Odoo;
import org.apache.xmlrpc.XmlRpcException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class Team {

    private Odoo odoo;

    public Team(String hostname, String database, String username, String password) {
        this.odoo = new Odoo(hostname, database, username, password);
    }

    // Status Codes:
    // 4: Other error
    // 3: User has no access to create a team
    // 2: Team with name already exists
    // 1: Team could not be created
    // 0: Team created successfully
    public int createTeam(String playerUUID, String name) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "create_team", Arrays.asList(playerUUID, name)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 4: Other error
    // 3: User already in team
    // 2: Team with name already exists
    // 1: Team could not be created
    // 0: Team created successfully
    public int createTeam(String playerUUID, String name, String description) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "create_team", Arrays.asList(playerUUID, name, description)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 5: Other error
    // 4: User has no team
    // 3: Team does not exist
    // 2: User is not member of this team
    // 1: User is not manager of this team
    // 0: Success
    public int editTeam(String playerUUID, String name, String newName) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "edit_team", Arrays.asList(playerUUID, name, newName)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 5;
    }

    // Status Codes:
    // 5: Other error
    // 4: User has no team
    // 3: Team does not exist
    // 2: User is not member of this team
    // 1: User is not manager of this team
    // 0: Success
    public int editTeam(String playerUUID, String name, String newName, String newDescription) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "edit_team", Arrays.asList(playerUUID, name, newName, newDescription)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 5;
    }

    // Status Codes:
    // 2: Other error
    // 1: User has no team
    // 0: Success
    public int leaveTeam(String playerUUID) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "leave_team", Arrays.asList(playerUUID)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 2;
    }

    // Status Codes:
    // 4: Other error
    // 3: Team does not exist
    // 2: User is not manager
    // 1: User is not user of this team
    // 0: Success
    public int addMember(String playerUUID, String playerUUIDtoAdd) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "add_member", Arrays.asList(playerUUID, playerUUIDtoAdd)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 4: Other error
    // 3: Team does not exist
    // 2: User is not manager
    // 1: User is already member of this team
    // 0: Success
    public int inviteMember(String playerUUID, String playerUUIDtoInvite) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "invite_member", Arrays.asList(playerUUID, playerUUIDtoInvite)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 3: Other error
    // 2: Team does not exist
    // 1: Request does not exist
    // 0: Success
    public int acceptRequest(String playerUUID, String teamName) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "accept_request", Arrays.asList(playerUUID, teamName)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 3;
    }

    // Status Codes:
    // 3: Other error
    // 2: Team does not exist
    // 1: Request does not exist
    // 0: Success
    public int denyRequest(String playerUUID, String teamName) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "deny_request", Arrays.asList(playerUUID, teamName)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 3;
    }

    // Status Codes:
    // 4: Other error
    // 3: Team does not exist
    // 2: User is not manager
    // 1: User is not user of this team
    // 0: Success
    public int kickMember(String playerUUID, String playerUUIDtoKick) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "kick_member", Arrays.asList(playerUUID, playerUUIDtoKick)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 6: Other error
    // 5: Team does not exist
    // 4: User is not manager
    // 3: User to kick is not a team
    // 2: User to kick is not in this team
    // 1: User is already manager of this team
    // 0: Success
    public int promoteMember(String playerUUID, String playerUUIDtoPromote) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "promote_member", Arrays.asList(playerUUID, playerUUIDtoPromote)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 6;
    }

    // Status Codes:
    // 6: Other error
    // 5: Team does not exist
    // 4: User is not manager
    // 3: User to kick is not a team
    // 2: User to kick is not in this team
    // 1: User is already user of this team
    // 0: Success
    public int demoteMember(String playerUUID, String playerUUIDtoDemote) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "demote_member", Arrays.asList(playerUUID, playerUUIDtoDemote)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 6;
    }

    public JSONObject getTeamNameByMember(String playerUUID) {
        try {
            return new JSONObject((Map<String, String>) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "get_team_by_member", Arrays.asList(playerUUID)
            )));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray getAllTeams() {
        try {
            return new JSONArray(this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "get_all_teams", Arrays.asList()
            )));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getTeam(String name) {
        try {
            return new JSONObject((Map<String, String>) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "get_team", Arrays.asList(name)
            )));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

}