package net.gigaclub.team;

import net.gigaclub.base.odoo.Odoo;
import org.apache.xmlrpc.XmlRpcException;

import java.util.*;

public class Team {

    private Odoo odoo;

    public Team(String hostname, String database, String username, String password) {
        this.odoo = new Odoo(hostname, database, username, password);
    }

}