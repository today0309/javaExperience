package com.ztw.netty;

public class ServerManager
{
    private AbstractNettyServer tcpServer;

    public ServerManager() {
        tcpServer = (AbstractNettyServer)SpringContextHolder.getBean("tcpServer");
    }

    public void startServer(int port) throws Exception {
        tcpServer.startServer(port);
    }

    public void startServer() throws Exception {
        tcpServer.startServer();
    }
    public void stopServer() throws Exception {
        tcpServer.stopServer();
    }
}
