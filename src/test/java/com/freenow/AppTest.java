package com.freenow;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;


public abstract class AppTest extends TestCase {
    public static final Logger LOG = Logger.getLogger(AppTest.class);

    @Before
    public void setUp() {
        LOG.info("Start test: " + getName());
    }
}