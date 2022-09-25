package pl.edu.pjwstk.project;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class BasicNode {
    private Integer id;
    private InetAddress ip;
    private Integer port;
    private Integer listenPort;

    public BasicNode(Integer id, InetAddress ip, Integer port) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.listenPort = null;
    }

    public BasicNode(Integer id, Integer listenPort) {
        this.id = id;
        this.ip = null;
        this.port = null;
        this.listenPort = listenPort;
    }

    public BasicNode(String gateway) throws UnknownHostException {
        String[] gatewaySplit = gateway.split(":");
        this.id = null;
        this.ip = InetAddress.getByName(gatewaySplit[0]);
        this.port = Integer.parseInt(gatewaySplit[1]);
        this.listenPort = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getListenPort() {
        return listenPort;
    }

    public void setListenPort(Integer listenPort) {
        this.listenPort = listenPort;
    }
}
