package com.xiao.common.util;

import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * shell工具
 * <p>
 *
 * @author： jianjun.xiao
 * @e-mail： xiaocen65535@163.com
 * @date： 2021/8/17 17:16
 */
@Slf4j
public class ShellClient {

    private Session session;

    private Channel channel;

    private ChannelExec channelExec;

    private ShellClient() {
    }

    /**
     * 获取ExecuteShellUtil类实例对象
     *
     * @return 实例
     * @date 2019/4/29 16:58
     */
    public static ShellClient getInstance() {
        return new ShellClient();
    }

    /**
     * 初始化
     *
     * @param ip       远程Linux地址
     * @param port     端口
     * @param username 用户名
     * @param password 密码
     * @throws JSchException JSch异常
     */
    public void init(String ip, Integer port, String username, String password) throws JSchException {
        JSch jsch = new JSch();
        jsch.getSession(username, ip, port);
        session = jsch.getSession(username, ip, port);
        session.setPassword(password);
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        session.setConfig(sshConfig);
        session.connect(60 * 1000);
        log.info("ssh session connected!");
        // 打开执行shell指令的通道
        channel = session.openChannel("exec");
        channelExec = (ChannelExec) channel;
    }

    /**
     * 执行一条命令
     */
    public String execute(String command) throws Exception {
        if (session == null || channel == null || channelExec == null) {
            throw new Exception("please invoke init(...) first!");
        }
        log.info("execute command - > {}", command);
        channelExec.setCommand(command);
        channel.setInputStream(null);
        channelExec.setErrStream(System.err);
        channel.connect();
        StringBuilder sb = new StringBuilder(16);
        try (InputStream in = channelExec.getInputStream();
             InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr)) {
            String buffer;
            while ((buffer = reader.readLine()) != null) {
                sb.append("\n").append(buffer);
            }
            // 释放资源
            close();
            log.info("shell execute result - > {}", sb);
            return sb.toString();
        }
    }

    public static void put(String host, String username, String password, String srcFile, String desFile) {

    }

    public static void get(String host, String username, String password, String srcFile, String desFile) {

    }

    /**
     * 释放资源
     */
    private void close() {
        if (channelExec != null && channelExec.isConnected()) {
            channelExec.disconnect();
        }
        if (channel != null && channel.isConnected()) {
            channel.disconnect();
        }
        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }

}
