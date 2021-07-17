package com.xiao.common.util;

import junit.framework.TestCase;
import org.junit.Test;

public class StringUtilsTest extends TestCase {

    @Test
    public void testIsEmpty() {
        assert StringUtils.isEmpty("");
        assert StringUtils.isEmpty(null);
        assert StringUtils.isEmpty("a") == false;
    }

    @Test
    public void testIsNotEmpty() {
        assert StringUtils.isNotEmpty("") == false;
        assert StringUtils.isNotEmpty(null) == false;
        assert StringUtils.isNotEmpty("a") == true;
    }

}