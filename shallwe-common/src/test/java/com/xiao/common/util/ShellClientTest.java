package com.xiao.common.util;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ShellClientTest extends TestCase {

    @Test
    public void testExecute() throws Exception {
        ShellClient shellClient = ShellClient.getInstance();
        shellClient.init("192.168.1.51", 22, "root", "xiaojianjun");
        String command = "mkdir -p /home/xiaojianjun/shelltest & cat >> /home/xiaojianjun/shelltest/shell.test << EOF\n我睡着了 \nEOF";
        String execute = shellClient.execute(command);
        log.info(execute);
    }

}