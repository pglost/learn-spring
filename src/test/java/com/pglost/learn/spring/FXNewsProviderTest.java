package com.pglost.learn.spring;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple FXNewsProvider.
 */
public class FXNewsProviderTest
    extends TestCase
{
    private FXNewsProvider newsProvider;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FXNewsProviderTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FXNewsProviderTest.class );
    }


    @Override
    protected void setUp() throws Exception{
        super.setUp();
        newsProvider = new FXNewsProvider(new MockNewsListener(), new MockNewsPersister());
    }

    @Override
    protected void tearDown() throws Exception{
        super.tearDown();
        newsProvider = null;
    }

    public void testGetAndPersistNewsWithOutResourceAvaliable(){
        try {
            newsProvider.getAndPersistNews();
            fail("fail");
        }catch (FXNewsRetrieveFailureException e){
            System.out.println(FXNewsRetrieveFailureException.class.getName());
        }
    }
}
