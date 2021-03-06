package com.tp2assignment6.domaindesign.services.vehicle;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.tp2assignment6.domaindesign.domain.services.vehicle.Impl.SUVServiceImpl;

import junit.framework.Assert;

/**
 * Created by NXA-C.unltd on 2016/05/11.
 */
public class SUVServiceTest extends AndroidTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testSUVService(){
        Intent intent = new Intent(getContext(), SUVServiceImpl.class);
        super.mContext.startService(intent);
        Assert.assertEquals("CA 36987", getContext());
    }
}
