package com.xiao.common.util;

import junit.framework.TestCase;
import org.junit.Test;

public class StringUtilsTest extends TestCase {

    @Test
    public void testIsEmpty() {
        assert StringUtils.isNullOrEmpty("");
        assert StringUtils.isNullOrEmpty(null);
        assert StringUtils.isNullOrEmpty("a") == false;
    }

    @Test
    public void testIsNotEmpty() {
        assert StringUtils.isNotNullOrEmpty("") == false;
        assert StringUtils.isNotNullOrEmpty(null) == false;
        assert StringUtils.isNotNullOrEmpty("a") == true;
    }

}